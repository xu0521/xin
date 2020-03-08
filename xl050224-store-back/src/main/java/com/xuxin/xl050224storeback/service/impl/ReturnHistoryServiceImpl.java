package com.xuxin.xl050224storeback.service.impl;

import com.xuxin.xl050224storeback.entity.ReturnHistory;
import com.xuxin.xl050224storeback.mapper.ReturnHistoryMapper;
import com.xuxin.xl050224storeback.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Override
    public List<ReturnHistory> getById(Integer returnId) {
        List<ReturnHistory> returnHistory = returnHistoryMapper.selectByReturnId(returnId);
        return returnHistory;
    }
}
