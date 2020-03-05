package com.xuxin.xl050224storeback.service;

import com.xuxin.xl050224storeback.dto.in.ProductSearchInDTO;
import com.xuxin.xl050224storeback.dto.out.ProductShowOutDTO;
import com.xuxin.xl050224storeback.entity.Product;

import java.util.List;

public interface ProductService {
    ProductShowOutDTO getShowById(Integer productId);

    List<Product> getList(ProductSearchInDTO productSearchInDTO);

    Product getById(Integer productId);
}
