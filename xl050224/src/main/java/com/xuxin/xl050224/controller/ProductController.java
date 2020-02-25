package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.ProductCreateInDTO;
import com.xuxin.xl050224.dto.in.ProductSearchInDTO;
import com.xuxin.xl050224.dto.in.ProductUpdateInDTO;
import com.xuxin.xl050224.dto.out.ProductShowOutDTO;
import com.xuxin.xl050224.dto.out.ProductListOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageInfo<ProductListOutDTO> search(ProductSearchInDTO productSearchInDTO,
                                              @RequestParam(defaultValue = "1") Integer pageNum){
        return null;
    }

    @PostMapping("/create")
    public String create(@RequestBody ProductCreateInDTO productCreateInDTO){
        return null;
    }

    @GetMapping("/getProduct")
    public ProductShowOutDTO getProduct(@RequestParam Integer ProductId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateInDTO productUpdateInDTO){

    }

}
