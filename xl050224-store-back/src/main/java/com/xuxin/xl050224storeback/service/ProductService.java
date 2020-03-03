package com.xuxin.xl050224storeback.service;

import com.xuxin.xl050224storeback.dto.out.ProductShowOutDTO;

public interface ProductService {
    ProductShowOutDTO getById(Integer productId);
}
