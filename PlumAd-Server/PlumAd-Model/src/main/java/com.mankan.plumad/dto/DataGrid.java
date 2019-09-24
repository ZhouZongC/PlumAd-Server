package com.mankan.plumad.dto;



/**
 * @author：nbfujx
 * @description：
 * @date：上午10:29 2018/5/14
 */
public class DataGrid<T> {


    /**
     * 总条目数
     */
    long total;

    /**
     * 版本信息
     */
    long version;

    /**
     * 业务数据
     */
    T data;

    public DataGrid(long total, T data, long version)
    {
        this.total = total;
        this.data = data;
        this.version = version;
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataGrid{" +
                "total='" + total + '\'' +
                ", data=" + data +
                ", version=" + version +
                '}';
    }
}
