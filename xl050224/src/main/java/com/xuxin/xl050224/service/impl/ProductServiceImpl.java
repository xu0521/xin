package com.xuxin.xl050224.service.impl;

import com.alibaba.fastjson.JSON;
import com.xuxin.xl050224.dto.in.ProductCreateInDTO;
import com.xuxin.xl050224.dto.in.ProductUpdateInDTO;
import com.xuxin.xl050224.entity.Product;
import com.xuxin.xl050224.entity.ProductDetail;
import com.xuxin.xl050224.mapper.ProductDetailMapper;
import com.xuxin.xl050224.mapper.ProductMapper;
import com.xuxin.xl050224.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;

    @Override
    @Transactional
    public Integer create(ProductCreateInDTO productCreateInDTO) {

        Product product = new Product();
        product.setProductCode(productCreateInDTO.getProductCode());
        product.setProductName(productCreateInDTO.getProductName());
        product.setPrice(productCreateInDTO.getPrice());
        product.setDiscount(productCreateInDTO.getDiscount());
        product.setStockQuantity(productCreateInDTO.getStockQuantity());
        product.setStatus(productCreateInDTO.getStatus());
        product.setMainPicUrl(productCreateInDTO.getMinaPicUrl());
        product.setRewordPoints(productCreateInDTO.getRewordPoints());
        product.setSortOrder(productCreateInDTO.getSortOrder());
        String description = productCreateInDTO.getDescription();
        String productAbstract = description.substring(0, Math.min(100, description.length()));
        product.setProductAbstract(productAbstract);
        int i = productMapper.insertSelective(product);

        Integer productId = product.getProductId();
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productId);
        productDetail.setDescription(productCreateInDTO.getDescription());
        List<String> otherPicUrls = productCreateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));

        int i1 = productDetailMapper.insertSelective(productDetail);

        return productId;
    }

    @Override
    @Transactional
    public void update(ProductUpdateInDTO productUpdateInDTO) {
        Product product = new Product();
        product.setProductId(productUpdateInDTO.getProductId());
        product.setProductName(productUpdateInDTO.getProductName());
        product.setPrice(productUpdateInDTO.getPrice());
        product.setDiscount(productUpdateInDTO.getDiscount());
        product.setStockQuantity(productUpdateInDTO.getStockQuantity());
        product.setMainPicUrl(productUpdateInDTO.getMinaPicUrl());
        product.setStatus(productUpdateInDTO.getStatus());
        product.setRewordPoints(productUpdateInDTO.getRewordPoints());
        product.setSortOrder(productUpdateInDTO.getSortOrder());
        String description = productUpdateInDTO.getDescription();
        String productAbstract = description.substring(0, Math.min(100, description.length()));
        product.setProductAbstract(productAbstract);
        int i = productMapper.updateByPrimaryKeySelective(product);


        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productUpdateInDTO.getProductId());
        productDetail.setDescription(productUpdateInDTO.getDescription());
        List<String> otherPicUrls = productUpdateInDTO.getOtherPicUrls();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPicUrls));
        productDetailMapper.updateByPrimaryKeySelective(productDetail);

    }

    @Override
    @Transactional
    public void delete(Integer productId) {
        productMapper.deleteByPrimaryKey(productId);
        productDetailMapper.deleteByPrimaryKey(productId);
    }

    @Override
    @Transactional
    public void batchDelete(List<Integer> productIds) {
        productMapper.batchDelete(productIds);
        productDetailMapper.batchDelete(productIds);
    }
}
