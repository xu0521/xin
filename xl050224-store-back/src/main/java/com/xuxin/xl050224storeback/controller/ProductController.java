package com.xuxin.xl050224storeback.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224storeback.dto.in.ProductSearchInDTO;
import com.xuxin.xl050224storeback.dto.out.ProductShowOutDTO;
import com.xuxin.xl050224storeback.entity.Product;
import com.xuxin.xl050224storeback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageInfo<Product> search(ProductSearchInDTO productSearchInDTO,
                                    @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<Product> products = productService.getList(productSearchInDTO);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        return pageInfo;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getProduct(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }


}
