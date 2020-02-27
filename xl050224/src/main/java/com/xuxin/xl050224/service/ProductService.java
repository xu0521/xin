package com.xuxin.xl050224.service;

import com.xuxin.xl050224.dto.in.ProductCreateInDTO;
import com.xuxin.xl050224.dto.in.ProductUpdateInDTO;

import java.util.List;

public interface ProductService {

    Integer create(ProductCreateInDTO productCreateInDTO);

    void update(ProductUpdateInDTO productUpdateInDTO);

    void delete(Integer productId);

    void batchDelete(List<Integer> productIds);


}
