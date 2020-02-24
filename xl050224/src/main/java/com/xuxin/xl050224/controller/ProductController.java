package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.ProductCreateInDTO;
import com.xuxin.xl050224.dto.in.ProductUpdateInDTO;
import com.xuxin.xl050224.dto.out.ProductGetProductOutDTO;
import com.xuxin.xl050224.dto.out.ProductSearchOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageInfo<ProductSearchOutDTO> search(@RequestParam String productName,
                                                @RequestParam double price,
                                                @RequestParam Integer stockQuantity,
                                                @RequestParam byte status,
                                                @RequestParam(defaultValue = "1") Integer pageNum){
        return null;
    }

    @PostMapping("/create")
    public String create(@RequestBody ProductCreateInDTO productCreateInDTO){
        return null;
    }

    @GetMapping("/getProduct")
    public ProductGetProductOutDTO getProduct(@RequestParam Integer ProductId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){

    }

}
