package com.service;

import com.pojo.registerTwo;

import java.util.List;

public interface registerService {
    public void ruzhu(String rid, String uName, String idCard, String number, String day);

    public List<registerTwo> findRegister();

    public int tuifang(String rid,String endTime);

    void registerService(int reid);
}
