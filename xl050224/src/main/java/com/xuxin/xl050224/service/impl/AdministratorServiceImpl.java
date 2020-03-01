package com.xuxin.xl050224.service.impl;

import com.xuxin.xl050224.entity.Administrator;
import com.xuxin.xl050224.mapper.AdministratorMapper;
import com.xuxin.xl050224.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;


    @Override
    public Administrator getByUsername(String username) {
        Administrator administrator = administratorMapper.selectByUserName(username);
        return administrator;
    }
}
