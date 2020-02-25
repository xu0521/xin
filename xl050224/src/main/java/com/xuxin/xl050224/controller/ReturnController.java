package com.xuxin.xl050224.controller;

import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224.dto.in.ReturnSearchInDTO;
import com.xuxin.xl050224.dto.in.ReturnUpdateInDTO;
import com.xuxin.xl050224.dto.out.ReturnListOutDTO;
import com.xuxin.xl050224.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @GetMapping("/search")
    public PageInfo<ReturnListOutDTO> search(ReturnSearchInDTO returnSearchInDTO,
                                             @RequestParam(defaultValue = "1") Integer pageNum){
        return null;
    }


    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody ReturnUpdateInDTO returnUpdateInDTO){

    }

}
