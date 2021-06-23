package com.serviceImpl;

import com.dao.adminMapper;
import com.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class adminServiceImpl implements adminService {
    @Autowired
    private adminMapper adminMapper;
    @Override
    public boolean login(String uName, String uPassword) {
        int count=adminMapper.findAdminByUnameAndUword(uName,uPassword);
        System.out.println(count);
        return count==1?true:false;
    }
}
