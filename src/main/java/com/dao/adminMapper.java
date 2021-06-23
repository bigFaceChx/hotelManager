package com.dao;

import org.apache.ibatis.annotations.Param;

public interface adminMapper {
    //登录
   public int findAdminByUnameAndUword(@Param("uName") String uName, @Param("uPassword") String uPassword);
}
