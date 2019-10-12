package com.mankan.plumad.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.mankan.plumad.mapper.AddressCodeMapper;
import com.mankan.plumad.model.AddressCode;
import com.mankan.plumad.service.IAddressCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 地址字典表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2018-09-17
 */
@Service
public class AddressCodeServiceImpl extends ServiceImpl<AddressCodeMapper, AddressCode> implements IAddressCodeService {

    @Override
    public AddressCode getAddressCode(String code) {
        Wrapper<AddressCode> ew = new EntityWrapper<AddressCode>();
        ew.eq("code",code);
        return this.selectOne(ew);
    }

    @Override
    public List<AddressCode> listAddress(String code, String s) {
        Wrapper<AddressCode> ew = new EntityWrapper<AddressCode>();
        ew.eq("superior_code",code).eq("type",s);
        return this.selectList(ew);
    }

    @Override
    public List<AddressCode> getAllAddress() {
        Wrapper<AddressCode> ew = new EntityWrapper<AddressCode>();
        ew.le("type",4);
        ew.ge("type",2);
        ew.orderBy("code");
        return this.selectList(ew);
    }

    @Override
    public AddressCode getAddressCodeByCode(String code) {
        Wrapper<AddressCode> ew = new EntityWrapper<AddressCode>();
        ew.eq("code",code);
        return this.selectOne(ew);
    }


}
