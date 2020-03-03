package com.xuxin.xl050224storeback.service.impl;

import com.alibaba.fastjson.JSON;
import com.xuxin.xl050224storeback.dto.out.ProductShowOutDTO;
import com.xuxin.xl050224storeback.entity.Product;
import com.xuxin.xl050224storeback.entity.ProductDetail;
import com.xuxin.xl050224storeback.mapper.ProductDetailMapper;
import com.xuxin.xl050224storeback.mapper.ProductMapper;
import com.xuxin.xl050224storeback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    @Transactional
    public ProductShowOutDTO getById(Integer productId) {

        Product product = productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);

        ProductShowOutDTO productShowOutDTO = new ProductShowOutDTO();
        productShowOutDTO.setProductId(product.getProductId());
        productShowOutDTO.setProductName(product.getProductName());
        productShowOutDTO.setProductCode(product.getProductCode());
        productShowOutDTO.setPrice(product.getPrice());
        productShowOutDTO.setDiscount(product.getDiscount());
        productShowOutDTO.setMinaPicUrl(product.getMainPicUrl());
        productShowOutDTO.setRewordPoints(product.getRewordPoints());
        productShowOutDTO.setStockQuantity(product.getStockQuantity());

        productShowOutDTO.setDescription(productDetail.getDescription());
        String otherPicUrlsJson = productDetail.getOtherPicUrls();
        List<String> otherPicUrl = JSON.parseArray(otherPicUrlsJson, String.class);
        productShowOutDTO.setOtherPicUrls(otherPicUrl);


        return productShowOutDTO;
    }
}
