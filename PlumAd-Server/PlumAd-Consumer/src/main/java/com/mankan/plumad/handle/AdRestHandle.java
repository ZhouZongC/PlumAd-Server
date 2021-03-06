package com.mankan.plumad.handle;

import cn.hutool.core.util.NumberUtil;
import com.mankan.plumad.consumer.*;

import com.mankan.plumad.dto.*;
import com.mankan.plumad.model.*;
import com.mankan.plumad.util.IpInfoUtil;
import com.mankan.plumad.util.NetworkUtil;
import com.mankan.plumad.util.RandomUtils;
import com.mipay.base.common.constant.enums.ReturnCode;
import com.mipay.base.util.JsonResultUtil;
import com.mipay.base.util.OrderNumUtil;
import com.mipay.base.util.RedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

import static com.mankan.plumad.util.WeekUtil.dayForWeek;
import static com.mankan.plumad.util.WeekUtil.hourForday;

/**
 * @author: youtiao
 * @create: 2019-10-10 10:22
 * @description:
 **/

@Component
public class AdRestHandle {

    @Autowired
    private AdPromotionLogConsumer adPromotionLogConsumer;

    @Autowired
    private AdPromotionPositionConsumer adPromotionPositionConsumer;

    @Autowired
    private AdPromotionPositionAdConsumer adPromotionPositionAdConsumer;

    @Autowired
    private AdPromotionModeConsumer adPromotionModeConsumer;

    @Autowired
    private AdPromotionPlanConsumer adPromotionPlanConsumer;

    @Autowired
    private AdPromotionInfoConsumer adPromotionInfoConsumer;

    @Autowired
    private UserConsumeConsumer userConsumeConsumer;

    @Autowired
    private UserFinanceConsumer userFinanceConsumer;

    @Autowired
    private IpInfoUtil ipInfoUtil;

    @Autowired
    private RedisCacheUtil redisCacheUtil;

    @Autowired
    private OrderNumUtil orderNumUtil;

    /**
     * 获取推荐广告列表
     * @param positionCode
     * @return
     */
    public String listAd(String positionCode){
        //查询广告位的信息
        AdPromotionDTO adPromotionDTO = adPromotionPositionConsumer.getAdPromotionDTO(positionCode);
        //查询广告位对应广告，将已经添加的广告过滤掉

        AdPromotionQuery adPromotionQuery = new AdPromotionQuery(adPromotionDTO.getChargingMode(),
                adPromotionDTO.getType(),adPromotionDTO.getAdType(),adPromotionDTO.getAdSizes()
                ,null,null,null);
        List<AdPromotionInfo> adPromotionInfos =  adPromotionModeConsumer.listAd(adPromotionQuery,1,10);
        if(adPromotionInfos.size() == 0) {
            adPromotionQuery = new AdPromotionQuery(adPromotionDTO.getChargingMode(),
                    null,adPromotionDTO.getAdType(),adPromotionDTO.getAdSizes()
                    ,null,null,null);
            adPromotionInfos =  adPromotionModeConsumer.listAd(adPromotionQuery,1,10);
        }

        return JsonResultUtil.toJson(ReturnCode.SUCCESS, adPromotionInfos);
    }

    /**
     * 获取推荐广告（唯一）
     * @param positionCode
     * @param request
     * @return
     */
    public String getAd(String positionCode, HttpServletRequest request,int cfNum) throws Throwable {
        try {
            //查询广告位的信息
            AdPromotionDTO adPromotionDTO = adPromotionPositionConsumer.getAdPromotionDTO(positionCode);
            // 1  指定过滤广告
            if ("1".equals(adPromotionDTO.getAdFilter())) {
                AdPromotionPositionAdQuery adPromotionPositionAdQuery = new AdPromotionPositionAdQuery();
                adPromotionPositionAdQuery.setPageNum(1);
                adPromotionPositionAdQuery.setPageSize(10);
                adPromotionPositionAdQuery.setPositionCode(adPromotionDTO.getPositionCode());
                List<AdPromotionPositionAd> adPromotionPositionAds = adPromotionPositionAdConsumer.listAdPromotionPositionAd(adPromotionPositionAdQuery).getList();
                //创建Random类对象
                Random random = new Random();
//            int serverindex = random.nextInt(adPromotionPositionAds.size() - 0 + 1);
                int serverindex = adPromotionPositionAds.size() < 1 ? random.nextInt(adPromotionPositionAds.size() - 0 + 1) : 0;
                //获取广告
                AdPromotionPositionAd adPromotionPositionAd = adPromotionPositionAds.get(serverindex);
                AdPromotionInfo adPromotionInfo =
                        adPromotionInfoConsumer.getAdPromotionInfo(adPromotionPositionAd.getPromotionInfoId());
                //将请求日志写入数据库
                AdPromotionLog adPromotionLog = new AdPromotionLog();
                String ip = NetworkUtil.getIpAddr(request);
                String userAgent = request.getHeader("user-agent");
                String macAddress = NetworkUtil.getMacAddress(ip);
                String dnsAddress = NetworkUtil.getHostName(ip);
                String ordernum = "999" + orderNumUtil.getOrderNum("GGRZ");
                adPromotionLog.setId(ordernum);
                adPromotionLog.setUserId(adPromotionDTO.getUserId());
                adPromotionLog.setPositionCode(adPromotionDTO.getPositionCode());
                adPromotionLog.setPromotionType(adPromotionDTO.getPromotionType());
                adPromotionLog.setChargingMode(adPromotionDTO.getChargingMode());
                adPromotionLog.setInterfaceType("1");
                adPromotionLog.setIpAddress(ip);
                adPromotionLog.setMacAddress(macAddress);
                adPromotionLog.setDnsAddress(dnsAddress);
                adPromotionLog.setUserAgent(userAgent);
                adPromotionLog.setPromotionInfoId(adPromotionInfo.getId());
                adPromotionLog.setStatus("S");
                adPromotionLog.setCreateTime(new Date());
                Boolean flag = adPromotionLogConsumer.saveAdPromotionLog(adPromotionLog);
                if (flag && "CPM".equals(adPromotionDTO.getChargingMode())) {
                    //广告主进行扣费操作
                    flag = this.chargingFee(adPromotionInfo.getUserId(), adPromotionInfo.getPlanCode(), ordernum);
                    if (flag) {
                        AdShowVO adShowVO = new AdShowVO();
                        adShowVO.setAdType(adPromotionInfo.getAdType());
                        adShowVO.setAdSizes(adPromotionInfo.getAdSizes());
                        adShowVO.setPicUrl(adPromotionInfo.getPicUrl());
                        String shorurl = RandomUtils.getRandomString(20);
                        adShowVO.setShortUrl(shorurl);
                        AdShowDTO adShowDTO = new AdShowDTO();
                        adShowDTO.setAdPromotionDTO(adPromotionDTO);
                        adShowDTO.setAdPromotionInfo(adPromotionInfo);
                        redisCacheUtil.set(shorurl, adShowDTO, 24 * 60 * 60);
                        return JsonResultUtil.toJson(ReturnCode.SUCCESS, adShowVO);
                    } else {
                        cfNum = cfNum + 1;
                        if (cfNum > 5) {
                            return JsonResultUtil.toJson(ReturnCode.ERROR, "系统异常，请联系客服");
                        }
                        return getAd(positionCode, request, cfNum);
                    }
                }
            } else {
                //获取是星期几
                String weekDay = dayForWeek(new Date());
                //获取现在是几点
                int hour = hourForday(new Date());
                //获取访问者ip地址所在区域
                String ip = NetworkUtil.getIpAddr(request);
                IpInfoDTO ipInfoDTO = ipInfoUtil.getIpInfo(ip);
                //封装查询类
                AdPromotionQuery adPromotionQuery = new AdPromotionQuery(adPromotionDTO.getChargingMode(),
                        adPromotionDTO.getType(), adPromotionDTO.getAdType(), adPromotionDTO.getAdSizes()
                        , weekDay, hour, ipInfoDTO.getCity());

                List<AdPromotionInfo> adPromotionInfos = adPromotionModeConsumer.listAd(adPromotionQuery, 1, 10);
                AdPromotionInfo adPromotionInfo = null;
                if (adPromotionInfos.size() == 0) {
                    adPromotionQuery = new AdPromotionQuery(adPromotionDTO.getChargingMode(),
                            null, adPromotionDTO.getAdType(), adPromotionDTO.getAdSizes()
                            , null, null, null);
                    adPromotionInfos = adPromotionModeConsumer.listAd(adPromotionQuery, 1, 10);
                }
                if (adPromotionInfos.size() > 0) {
                    //判断权重
                    List<Integer> weight = new ArrayList<>();
                    for (AdPromotionInfo weightPollingDTO : adPromotionInfos) {
                        weight.add(weightPollingDTO.getWeight());
                    }
                    int serverindex = random(weight);
                    //更具权重拉取最合适的广告
                    adPromotionInfo = adPromotionInfos.get(serverindex);
                    //将请求日志写入数据库
                    AdPromotionLog adPromotionLog = new AdPromotionLog();
                    String userAgent = request.getHeader("user-agent");
                    String macAddress = NetworkUtil.getMacAddress(ip);
                    String dnsAddress = NetworkUtil.getHostName(ip);
                    String ordernum = "999" + orderNumUtil.getOrderNum("GGRZ");
                    adPromotionLog.setId(ordernum);
                    adPromotionLog.setUserId(adPromotionDTO.getUserId());
                    adPromotionLog.setPositionCode(adPromotionDTO.getPositionCode());
                    adPromotionLog.setPromotionType(adPromotionDTO.getPromotionType());
                    adPromotionLog.setChargingMode(adPromotionDTO.getChargingMode());
                    adPromotionLog.setInterfaceType("1");
                    adPromotionLog.setIpAddress(ip);
                    adPromotionLog.setMacAddress(macAddress);
                    adPromotionLog.setDnsAddress(dnsAddress);
                    adPromotionLog.setUserAgent(userAgent);
                    adPromotionLog.setPromotionInfoId(adPromotionInfo.getId());
                    adPromotionLog.setStatus("S");
                    adPromotionLog.setCreateTime(new Date());
                    Boolean flag = adPromotionLogConsumer.saveAdPromotionLog(adPromotionLog);
                    if (flag && "CPM".equals(adPromotionDTO.getChargingMode())) {
                        //广告主进行扣费操作
                        flag = this.chargingFee(adPromotionInfo.getUserId(), adPromotionInfo.getPlanCode(), ordernum);
                        if (flag) {
                            AdShowVO adShowVO = new AdShowVO();
                            adShowVO.setAdType(adPromotionInfo.getAdType());
                            adShowVO.setAdSizes(adPromotionInfo.getAdSizes());
                            adShowVO.setPicUrl(adPromotionInfo.getPicUrl());
                            String shorurl = RandomUtils.getRandomString(20);
                            AdShowDTO adShowDTO = new AdShowDTO();
                            adShowDTO.setAdPromotionDTO(adPromotionDTO);
                            adShowDTO.setAdPromotionInfo(adPromotionInfo);
                            redisCacheUtil.set(shorurl, adShowDTO, 24 * 60 * 60);
                            adShowVO.setShortUrl(shorurl);
                            return JsonResultUtil.toJson(ReturnCode.SUCCESS, adShowVO);
                        } else {
                            cfNum = cfNum + 1;
                            if (cfNum > 5) {
                                return JsonResultUtil.toJson(ReturnCode.ERROR, "系统异常，请联系客服");
                            }
                            return getAd(positionCode, request, cfNum);
                        }
                    }
                } else {
                    return JsonResultUtil.toJson(ReturnCode.ERROR, "无匹配广告");
                }
            }

            return JsonResultUtil.toJson(ReturnCode.ERROR, "系统异常，请联系客服");

        }catch (Exception e){

            return JsonResultUtil.toJson(ReturnCode.ERROR, "系统异常，请联系客服");
        }
    }

    /**
     * 广告短链接跳转
     * @param shorturl
     * @return
     */
    public String translateAd(String shorturl, HttpServletRequest request) {
        AdShowDTO adShowDTO = (AdShowDTO) redisCacheUtil.get(shorturl);
        if(adShowDTO==null){
            return "http://mk.nbmankan.com/";
        }else {
            AdPromotionLog adPromotionLog = new AdPromotionLog();
            String ip = NetworkUtil.getIpAddr(request);
            String userAgent = request.getHeader("user-agent");
            String macAddress = NetworkUtil.getMacAddress(ip);
            String dnsAddress = NetworkUtil.getHostName(ip);
            String ordernum = "999" + orderNumUtil.getOrderNum("GGRZ");
            adPromotionLog.setId(ordernum);
            adPromotionLog.setUserId(adShowDTO.getAdPromotionDTO().getUserId());
            adPromotionLog.setPositionCode(adShowDTO.getAdPromotionDTO().getPositionCode());
            adPromotionLog.setPromotionType(adShowDTO.getAdPromotionDTO().getPromotionType());
            adPromotionLog.setChargingMode(adShowDTO.getAdPromotionDTO().getChargingMode());
            adPromotionLog.setInterfaceType("2");
            adPromotionLog.setIpAddress(ip);
            adPromotionLog.setMacAddress(macAddress);
            adPromotionLog.setDnsAddress(dnsAddress);
            adPromotionLog.setUserAgent(userAgent);
            adPromotionLog.setPromotionInfoId(adShowDTO.getAdPromotionInfo().getId());
            adPromotionLog.setStatus("S");
            adPromotionLog.setCreateTime(new Date());
            Boolean flag = adPromotionLogConsumer.saveAdPromotionLog(adPromotionLog);
            if (flag) {
                if("CPC".equals(adShowDTO.getAdPromotionDTO().getChargingMode())){
                    //广告主进行扣费操作
                    flag = this.chargingFee(adShowDTO.getAdPromotionInfo().getUserId(), adShowDTO.getAdPromotionInfo().getPlanCode(), ordernum);
                    if (flag) {
                        return adShowDTO.getAdPromotionInfo().getAdUrl();
                    } else {
                        return "http://mk.nbmankan.com/";
                    }
                }else{
                    return adShowDTO.getAdPromotionInfo().getAdUrl();
                }
            }
        }
        return "http://mk.nbmankan.com/";
    }


    /**
     * 广告扣费
     * @param userId
     * @param planCode
     * @return
     */
    private Boolean chargingFee(String userId, String planCode,String ordernum) {
        //查询计划
        AdPromotionPlan searchAdPromotionPlan =  new AdPromotionPlan();
        searchAdPromotionPlan.setPlanCode(planCode);
        AdPromotionPlan adPromotionPlan = adPromotionPlanConsumer.getAdPromotionPlanByCondition(searchAdPromotionPlan);
        //查询金额
        UserFinance searchUserFinance = new UserFinance();
        searchUserFinance.setUserId(userId);
        UserFinance userFinance = userFinanceConsumer.getUserFinanceByCondition(searchUserFinance);
        if(NumberUtil.isGreater(adPromotionPlan.getUnitPrice(),userFinance.getRechargeAmount())){
            // 达标下线
            AdPromotionPlan upAdPromotionPlan = new AdPromotionPlan();
            upAdPromotionPlan.setId(adPromotionPlan.getId());
            upAdPromotionPlan.setStatus("R001");
            adPromotionPlanConsumer.saveAdPromotionPlan(upAdPromotionPlan);
            return false;
        }
        //判断余额，日消费 是否达标 达标下线
        BigDecimal dayLimt = (BigDecimal) redisCacheUtil.get("GGJHFY" + planCode + Calendar.DAY_OF_YEAR);
        if(dayLimt == null){
            dayLimt = adPromotionPlan.getUnitPrice();
        }else{
            dayLimt  = NumberUtil.add(dayLimt,adPromotionPlan.getUnitPrice());
        }
        //增加消费记录
        UserConsume userConsume =new UserConsume();
        userConsume.setUserId(userId);
        userConsume.setPromotionLogId(ordernum);
        userConsume.setLimitAmount(NumberUtil.sub(userFinance.getRechargeAmount(),adPromotionPlan.getUnitPrice()));
        userConsume.setDayLimitAmount(dayLimt);
        userConsume.setTotalAmount(adPromotionPlan.getUnitPrice());
        userConsume.setRequestTime(new Date());
        userConsume.setStatus("S001");
        Boolean flag = userConsumeConsumer.saveUserConsume(userConsume);

        if(flag) {
            //扣除余额
            redisCacheUtil.set("GGJHFY" + planCode + Calendar.DAY_OF_YEAR, dayLimt, getSecondsNextEarlyMorning());
            if(NumberUtil.isGreater(dayLimt,adPromotionPlan.getLimitAmount())){
                // 达标下线
                AdPromotionPlan upAdPromotionPlan = new AdPromotionPlan();
                upAdPromotionPlan.setId(adPromotionPlan.getId());
                upAdPromotionPlan.setStatus("R001");
                adPromotionPlanConsumer.saveAdPromotionPlan(upAdPromotionPlan);
            }
            //将可消费剪掉
            flag = userFinanceConsumer.updateUserFinanceForConsume(userFinance.getUserId(),adPromotionPlan.getUnitPrice());
            if(flag){
                return true;
            }

        }

        return false;
    }

    public Long getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        // 坑就在这里
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }



    public static int random(List<Integer> weight){
        List<Integer> weightTmp = new ArrayList<Integer>(weight.size()+1);
        weightTmp.add(0);
        Integer sum = 0;
        for( Integer d : weight ){
            sum += d;
            weightTmp.add(sum);
        }
        Random random = new Random();
        int rand = random.nextInt(sum);
        int index = 0;
        for(int i = weightTmp.size()-1; i >0; i--){
            if( rand >= weightTmp.get(i)){
                index = i;
                break;
            }
        }
        return index;
    }


}
