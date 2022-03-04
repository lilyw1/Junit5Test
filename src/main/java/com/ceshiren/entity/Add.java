package com.ceshiren.entity;

import java.util.List;

/**
 * @author wyl
 * @create 2022-02-13 14:58
 */
public class Add {
    private List<AData> datas;

    public Add() {
    }

    public Add(List<AData> datas) {
        this.datas = datas;
    }

    public List<AData> getDatas() {
        return datas;
    }

    public void setDatas(List<AData> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Add{" +
                "datas=" + datas +
                '}';
    }
}
