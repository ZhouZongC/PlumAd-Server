package com.mankan.plumad.util;

import com.mankan.plumad.dto.IpInfoDTO;
import net.ipip.ipdb.City;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author：nbfujx
 * @description：
 * @date：下午12:17 2018/8/3
 */
@Component
public class IpInfoUtil {

    public IpInfoDTO getIpInfo(String ip)
    {

        IpInfoDTO infoDTO = new IpInfoDTO();
        try {
            // City类可用于IPDB格式的IPv4免费库，IPv4与IPv6的每周高级版、每日标准版、每日高级版、每日专业版、每日旗舰版
            City db = new City("/Users/nbfujx/tool/ipdb/ipipfree.ipdb");
            // db.findInfo(address, language) 返回 CityInfo 对象
            Map<String,String> info = db.findMap(ip, "CN");
            System.out.println(info);
            infoDTO.setRegion(info.get("region_name"));
            infoDTO.setCity(info.get("city_name"));
            infoDTO.setCountry(info.get("country_name"));
            return infoDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return  null;
    }
}
