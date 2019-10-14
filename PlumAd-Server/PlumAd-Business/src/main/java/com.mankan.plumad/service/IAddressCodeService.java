package com.mankan.plumad.service;

import com.baomidou.mybatisplus.service.IService;
import com.mankan.plumad.model.AddressCode;
import java.util.List;

/**
 * <p>
 * 地址字典表 服务类
 * </p>
 *
 * @author lq
 * @since 2018-09-17
 */
public interface IAddressCodeService extends IService<AddressCode> {

    /**
     * 获取地址字典列表
     * @param code
     * @return
     */
    AddressCode getAddressCode(String code);

    List<AddressCode> listAddress(String code, String s);


    List<AddressCode> getAllAddress();

    AddressCode getAddressCodeByCode(String code);

    String getAddressCodeByName(String name);
}
