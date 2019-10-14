package com.mankan.plumad.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.mankan.plumad.dto.AddressCodeDTO;
import com.mankan.plumad.dubbo.AddressCodeApi;
import com.mankan.plumad.model.AddressCode;
import com.mankan.plumad.service.IAddressCodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：lq
 * @description：
 * @date：19:45 2018/9/17
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class AddressCodeProvider implements AddressCodeApi {

    @Autowired
    private IAddressCodeService addressCodeService;

    @Override
    public List<AddressCode> getAddressCode(String province, String city, String country) {
        AddressCode addressCodeProvince = addressCodeService.getAddressCode(province);
        AddressCode addressCodeCity = addressCodeService.getAddressCode(city);
        AddressCode addressCodeCountry = addressCodeService.getAddressCode(country);
        if(addressCodeProvince==null||addressCodeCity==null||addressCodeCountry==null){
            return null;
        }
        List<AddressCode> list = new ArrayList<AddressCode>();
        list.add(addressCodeProvince);
        list.add(addressCodeCity);
        list.add(addressCodeCountry);
        return list;
    }


    @Override
    public AddressCodeDTO getAddressChildren(String province, String city, String country) {

        AddressCode addressCodeProvince = addressCodeService.getAddressCode(province);
        AddressCode addressCodeCity = addressCodeService.getAddressCode(city);
        AddressCode addressCodeCountry = addressCodeService.getAddressCode(country);
        if(addressCodeProvince==null||addressCodeCity==null||addressCodeCountry==null){
            return null;
        }

        AddressCodeDTO addressCodeDTOCountry = new AddressCodeDTO();
        addressCodeDTOCountry.setValue(String.valueOf(addressCodeCountry.getCode()));
        addressCodeDTOCountry.setLabel(addressCodeCountry.getName());
        //
        AddressCodeDTO addressCodeDTOCity = new AddressCodeDTO();
        addressCodeDTOCity.setValue(String.valueOf(addressCodeCity.getCode()));
        addressCodeDTOCity.setLabel(addressCodeCity.getName());
        List<AddressCodeDTO> listCity = new ArrayList<AddressCodeDTO>();
        listCity.add(addressCodeDTOCountry);
        addressCodeDTOCity.setChildren(listCity);
        //
        AddressCodeDTO addressCodeDTOProvince = new AddressCodeDTO();
        addressCodeDTOProvince.setValue(String.valueOf(addressCodeProvince.getCode()));
        addressCodeDTOProvince.setLabel(addressCodeProvince.getName());
        List<AddressCodeDTO> listProvince = new ArrayList<AddressCodeDTO>();
        listProvince.add(addressCodeDTOCity);
        addressCodeDTOProvince.setChildren(listProvince);

        return addressCodeDTOProvince;
    }

    @Override
    public List<AddressCode> listAddress(String code, String s) {
        return addressCodeService.listAddress( code,  s);
    }

    @Override
    public AddressCode getAddressCodeByCode(String code) {
        return addressCodeService.getAddressCodeByCode(code);
    }

    @Override
    public String getAddressCodeByName(String name) {
        return addressCodeService.getAddressCodeByName(name);
    }


}
