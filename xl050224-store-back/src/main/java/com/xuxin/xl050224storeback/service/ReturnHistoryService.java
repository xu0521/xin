package com.xuxin.xl050224storeback.service;

import com.xuxin.xl050224storeback.entity.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {

    List<ReturnHistory> getById(Integer returnId);

}
