package com.mankan.plumad.dubbo;

import com.mankan.plumad.dto.AddressCodeDTO;
import com.mankan.plumad.model.AddressCode;
import java.util.List;

/**
 * @author：lq
 * @description：
 * @date：19:42 2018/9/17
 */
public interface AddressCodeApi {

    /**
     * 获取地址列表
     * @param province
     * @param city
     * @param country
     * @return
     */
    List<AddressCode> getAddressCode(String province, String city, String country);


    AddressCodeDTO getAddressChildren(String province, String city, String country);

    /**
     * 获取地址列表
     * @param code
     * @param s
     * @return
     */
    List<AddressCode> listAddress(String code, String s);

    AddressCode getAddressCodeByCode(String code);
}
