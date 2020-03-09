package com.xuxin.xl050224.service;

import com.xuxin.xl050224.entity.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {

    List<ReturnHistory> getList(Integer returnId);

    Long create(ReturnHistory returnHistory);

}
