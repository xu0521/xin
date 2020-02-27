package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.ProductCreateInDTO;
import com.xuxin.xl050224.dto.in.ProductSearchInDTO;
import com.xuxin.xl050224.dto.in.ProductUpdateInDTO;
import com.xuxin.xl050224.dto.out.ProductShowOutDTO;
import com.xuxin.xl050224.dto.out.ProductListOutDTO;
import com.xuxin.xl050224.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/search")
    public PageInfo<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                              @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,5);
        List<ProductListOutDTO> productListOutDTOS = productService.search(productSearchInDTO);
        PageInfo<ProductListOutDTO> pageInfo = new PageInfo<>(productListOutDTOS);
        return pageInfo;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ProductCreateInDTO productCreateInDTO){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }

    @GetMapping("/getProduct")
    public ProductShowOutDTO getProduct(@RequestParam Integer productId){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){
        productService.update(productUpdateInDTO);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Integer productId){
        productService.delete(productId);
    }

    @PostMapping("/batchDelete")
    public void batchDelete(@RequestBody List<Integer> productIds){
        productService.batchDelete(productIds);
    }

}
