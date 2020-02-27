package com.xuxin.xl050224.mapper;

import com.xuxin.xl050224.dto.in.ProductSearchInDTO;
import com.xuxin.xl050224.dto.out.ProductListOutDTO;
import com.xuxin.xl050224.entity.Product;
import org.apache.ibatis.annotations.Param;
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

    int batchDelete(@Param("productIds") List<Integer> productIds);

    List<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO);
}