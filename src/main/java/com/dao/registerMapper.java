package com.dao;

import com.pojo.register;
import com.pojo.registerTwo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface registerMapper {

   public  void ruzhu(register register);

   public List<registerTwo> findRegister();

   public int addEndTime(@Param("rid") String rid,@Param("endTime") String endTime);

   void registerMapper(int reid);
}
