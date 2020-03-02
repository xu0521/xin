package com.xuxin.xl050224.service;

import com.xuxin.xl050224.entity.Administrator;

import java.util.List;

public interface AdministratorService {

    Administrator getByUsername(String username);

    Administrator getById(Integer administratorId);

    void updateProfile(Administrator administrator);

    Integer create(Administrator administrator);

    void update(Administrator administrator);

    void delete(Integer administratorId);

    void batchDelete(List<Integer> administratorIds);

    List<Administrator> getList();


}
