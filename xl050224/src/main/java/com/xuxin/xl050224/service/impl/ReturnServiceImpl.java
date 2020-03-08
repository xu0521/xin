package com.xuxin.xl050224.service.impl;

import com.xuxin.xl050224.dto.in.ReturnSearchInDTO;
import com.xuxin.xl050224.entity.Return;
import com.xuxin.xl050224.mapper.ReturnMapper;
import com.xuxin.xl050224.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public List<Return> search(ReturnSearchInDTO returnSearchInDTO) {
        List<Return> returns = returnMapper.selectByReturn(returnSearchInDTO);
        return returns;
    }
}
