package com.xuxin.xl050224storeback.mapper;

import com.xuxin.xl050224storeback.dto.in.ProductSearchInDTO;
import com.xuxin.xl050224storeback.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectProduct(ProductSearchInDTO productSearchInDTO);
}