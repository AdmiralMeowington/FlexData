package com.flexdata.controller;

import com.flexdata.api.request.IFlexdataRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/feed")
public class FlexdataController {
    @GetMapping("/")
    public Collection<String> getPublicFlexdataPosts(){
        return Collections.emptyList();
    }
    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash){
        return hash;
    }
    @PostMapping("/add")
    public String add(@RequestBody IFlexdataRequest request){
        return "data";
    }
}
