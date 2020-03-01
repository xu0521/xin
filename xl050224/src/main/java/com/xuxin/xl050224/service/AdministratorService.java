package com.xuxin.xl050224.service;

import com.xuxin.xl050224.entity.Administrator;

public interface AdministratorService {

    Administrator getByUsername(String username);

    Administrator getById(Integer administratorId);

    void update(Administrator administrator);

}
