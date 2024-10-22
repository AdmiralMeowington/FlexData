package com.flexdata.controller;

import com.flexdata.api.request.IFlexdataRequest;
import com.flexdata.api.responce.IFlexdataResponse;
import com.flexdata.api.responce.IFlexdataUrlResponse;
import com.flexdata.exeptions.NotFoundFlexdataEntityException;
import com.flexdata.service.IFlexdataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


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
    @ExceptionHandler(NotFoundFlexdataEntityException.class)
    public ResponseEntity<String> handleNotFoundEntity(NotFoundFlexdataEntityException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
