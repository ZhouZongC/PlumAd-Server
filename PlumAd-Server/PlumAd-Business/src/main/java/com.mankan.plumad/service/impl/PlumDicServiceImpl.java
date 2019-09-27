package com.mankan.plumad.service.impl;

import com.mankan.plumad.model.PlumDic;
import com.mankan.plumad.mapper.PlumDicMapper;
import com.mankan.plumad.service.IPlumDicService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import java.util.List;
import java.util.Collection;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author lq
 * @since 2019-09-26
 */
@Service
public class PlumDicServiceImpl extends ServiceImpl<PlumDicMapper, PlumDic> implements IPlumDicService {

        @Override
        public List<PlumDic> listPlumDic(PlumDic entity){
            Wrapper<PlumDic> ew = new EntityWrapper<PlumDic>();
            ew.eq(entity.getId()!=null,"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getType()),"type",entity.getType());
            ew.eq(!StringUtils.isEmpty(entity.getCode()),"code",entity.getCode());
            ew.eq(!StringUtils.isEmpty(entity.getValue()),"value",entity.getValue());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getParent()),"parent",entity.getParent());
                return this.selectList(ew);
        }

        @Override
        public List<PlumDic> listPlumDicWithOrderBy(PlumDic entity,Collection<String> columns,Boolean isAsc){
        Wrapper<PlumDic> ew = new EntityWrapper<PlumDic>();
            ew.eq(entity.getId()!=null,"id",entity.getId());
            ew.eq(!StringUtils.isEmpty(entity.getType()),"type",entity.getType());
            ew.eq(!StringUtils.isEmpty(entity.getCode()),"code",entity.getCode());
            ew.eq(!StringUtils.isEmpty(entity.getValue()),"value",entity.getValue());
            ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
            ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
            ew.eq(!StringUtils.isEmpty(entity.getParent()),"parent",entity.getParent());
             ew.orderBy(true,columns,isAsc);
        return this.selectList(ew);
        }


        @Override
        public PlumDic getPlumDicByCondition(PlumDic entity){
              Wrapper<PlumDic> ew = new EntityWrapper<PlumDic>();
                ew.eq(entity.getId()!=null,"id",entity.getId());
                ew.eq(!StringUtils.isEmpty(entity.getType()),"type",entity.getType());
                ew.eq(!StringUtils.isEmpty(entity.getCode()),"code",entity.getCode());
                ew.eq(!StringUtils.isEmpty(entity.getValue()),"value",entity.getValue());
                ew.eq(!StringUtils.isEmpty(entity.getStatus()),"status",entity.getStatus());
                ew.eq(!StringUtils.isEmpty(entity.getRemarks()),"remarks",entity.getRemarks());
                ew.eq(!StringUtils.isEmpty(entity.getParent()),"parent",entity.getParent());
             return this.selectOne(ew);
        }
}
