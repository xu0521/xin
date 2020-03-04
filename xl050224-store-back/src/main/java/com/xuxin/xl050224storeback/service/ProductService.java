package com.xuxin.xl050224storeback.service;

import com.xuxin.xl050224storeback.dto.in.ProductSearchInDTO;
import com.xuxin.xl050224storeback.dto.out.ProductShowOutDTO;
import com.xuxin.xl050224storeback.entity.Product;

import java.util.List;

public interface ProductService {
    ProductShowOutDTO getById(Integer productId);

    List<Product> getList(ProductSearchInDTO productSearchInDTO);
}
