package com.xuxin.xl050224storeback.service.impl;

import com.xuxin.xl050224storeback.entity.Return;
import com.xuxin.xl050224storeback.mapper.ReturnMapper;
import com.xuxin.xl050224storeback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Integer create(Return aReturn) {
        returnMapper.insertSelective(aReturn);
        Integer returnId = aReturn.getReturnId();
        return returnId;
    }

    @Override
    public List<Return> getByCustomerId(Integer customerId) {
        List<Return> returns = returnMapper.selectReturnByCustomerId(customerId);
        return returns;
    }
}
