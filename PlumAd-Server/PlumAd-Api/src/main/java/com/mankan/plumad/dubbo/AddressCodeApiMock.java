package com.mankan.plumad.dubbo;


import com.mankan.plumad.dto.AddressCodeDTO;
import com.mankan.plumad.model.AddressCode;
import java.util.List;

public class AddressCodeApiMock implements AddressCodeApi {
    @Override
    public List<AddressCode> getAddressCode(String province, String city, String country) {
        return null;
    }

    @Override
    public AddressCodeDTO getAddressChildren(String province, String city, String country) {
        return null;
    }

    @Override
    public List<AddressCode> listAddress(String code, String s) {
        return null;
    }

    @Override
    public AddressCode getAddressCodeByCode(String code) {
        return null;
    }

    @Override
    public String getAddressCodeByName(String name) {
        return null;
    }
}
