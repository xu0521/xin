package com.xuxin.xl050224storeback.controller;


import com.github.pagehelper.PageInfo;
import com.xuxin.xl050224storeback.dto.in.ReturnApplyInDTO;
import com.xuxin.xl050224storeback.dto.out.ReturnListOutDTO;
import com.xuxin.xl050224storeback.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO){
        return null;
    }

    @GetMapping("/getList")
    public PageInfo<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                             @RequestParam(defaultValue = "1") Integer pageNum){
        return null;
    }


    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }

}
