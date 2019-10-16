package com.mankan.plumad.util;

import com.mankan.plumad.consumer.AddressCodeConsumer;
import com.mankan.plumad.dto.IpInfoDTO;
import com.mipay.base.util.StringUtil;
import net.ipip.ipdb.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author：nbfujx
 * @description：
 * @date：下午12:17 2018/8/3
 */
@Component
public class IpInfoUtil {

    @Autowired
    private AddressCodeConsumer addressCodeConsumer;

    public IpInfoDTO getIpInfo(String ip)
    {

        IpInfoDTO infoDTO = new IpInfoDTO();
        try {
            // City类可用于IPDB格式的IPv4免费库，IPv4与IPv6的每周高级版、每日标准版、每日高级版、每日专业版、每日旗舰版
            City db = new City("C://Users/nbfujx/tool/ipdb/ipipfree.ipdb");
            // db.findInfo(address, language) 返回 CityInfo 对象
            Map<String,String> info = db.findMap(ip, "CN");

            System.out.println(info);

            infoDTO.setRegion(info.get("region_name"));
            infoDTO.setCity(info.get("city_name"));
            infoDTO.setCountry(info.get("country_name"));

            try {
                String region = infoDTO.getRegion();
                String city = infoDTO.getCity();
                if (StringUtil.isNotBlank(region)) {
                    String region_id = addressCodeConsumer.getAddressCode(region);
                    infoDTO.setRegion_id(region_id);

                }
                if (StringUtil.isNotBlank(city)) {
                    String city_id = addressCodeConsumer.getAddressCode(city);
                    infoDTO.setCity_id(city_id);
                }
            }catch (Exception e){

            }

            return infoDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return  null;
    }
}
