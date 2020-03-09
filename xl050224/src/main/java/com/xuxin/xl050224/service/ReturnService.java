package com.xuxin.xl050224.service;

import com.xuxin.xl050224.dto.in.ReturnSearchInDTO;
import com.xuxin.xl050224.entity.Return;

import java.util.List;

public interface ReturnService {

    List<Return> search(ReturnSearchInDTO returnSearchInDTO);

    Return getById(Integer returnId);

    void update(Return aReturn);

}
