package com.mankan.plumad.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author: youtiao
 * @create: 2019-08-09 14:05
 * @description:
 **/
public class AddressCodeDTO implements Serializable {

    /*
    * [{ value: 'beijing', label: '北京', children: [ { value: 'gugong', label: '故宫' }, { value: 'tiantan', label: '天坛' }, { value: 'wangfujing', label: '王府井' } ] }, { value: 'jiangsu', label: '江苏', children: [ { value: 'nanjing', label: '南京', children: [ { value: 'fuzimiao', label: '夫子庙', } ] }, { value: 'suzhou', label: '苏州', children: [ { value: 'zhuozhengyuan', label: '拙政园', }, { value: 'shizilin', label: '狮子林', } ] } ], }]*/

    String value;
    String label;
    List<AddressCodeDTO> children;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<AddressCodeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<AddressCodeDTO> children) {
        this.children = children;
    }
}
