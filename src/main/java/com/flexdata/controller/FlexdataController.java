package com.flexdata.controller;

import com.flexdata.api.request.IFlexdataRequest;
import com.flexdata.api.responce.IFlexdataResponse;
import com.flexdata.api.responce.IFlexdataUrlResponse;
import com.flexdata.service.IFlexdataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FlexdataController {
    private final IFlexdataService _service;
    @GetMapping("/")
    public Collection<IFlexdataResponse> getPublicFlexdataPosts(){
        return _service.getRecentPublicPosts();
    }
    @GetMapping("/{hash}")
    public IFlexdataResponse getByHash(@PathVariable String hash){
        return _service.getByHash(hash);
    }
    @PostMapping("/add")
    public IFlexdataUrlResponse add(@RequestBody IFlexdataRequest flexdata){
        return _service.createNew(flexdata);
    }
}
