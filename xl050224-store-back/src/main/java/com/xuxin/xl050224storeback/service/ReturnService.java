package com.xuxin.xl050224storeback.service;

import com.xuxin.xl050224storeback.entity.Return;

import java.util.List;

public interface ReturnService {

    Integer create(Return aReturn);

    List<Return> getByCustomerId(Integer customerId);

}
