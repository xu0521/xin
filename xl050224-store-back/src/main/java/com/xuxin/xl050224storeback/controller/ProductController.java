package com.xuxin.xl050224storeback.controller;


import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224storeback.dto.in.ProductSearchInDTO;
import com.xuxin.xl050224storeback.dto.out.ProductListOutDTO;
import com.xuxin.xl050224storeback.dto.out.ProductShowOutDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageInfo<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                              @RequestParam(defaultValue = "1") Integer pageNum){
        return null;
    }

    @GetMapping("/getProduct")
    public ProductShowOutDTO getProduct(@RequestParam Integer ProductId){
        return null;
    }


}
