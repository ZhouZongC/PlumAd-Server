package com.mankan.plumad.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mankan.plumad.dto.AddressCodeDTO;
import com.mankan.plumad.dubbo.AddressCodeApi;
import com.mankan.plumad.model.AddressCode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：lq
 * @description：
 * @date：16:35 2018/9/28
 */
@Service
public class AddressCodeConsumer {
    @Reference(version = "1.0.0", application = "${dubbo.application.id}",  check = false, retries = 2, timeout = 15000)
    private AddressCodeApi addressCodeApi;

    public AddressCodeDTO getAddressChildren(String province, String city, String country){return addressCodeApi.getAddressChildren(province,city,country);}

    public List<AddressCode> getAddressCodeProvince(String code) {
        return addressCodeApi.listAddress(code,"2");
    }

    public List<AddressCode> getAddressCodeCity(String code) {
        return addressCodeApi.listAddress(code,"3");
    }

    public List<AddressCode> getAddressCodeCountry(String code) {
        return addressCodeApi.listAddress(code,"4");
    }

    public AddressCode getAddressCodeByCode(String code){
        return addressCodeApi.getAddressCodeByCode(code);
    }
}
