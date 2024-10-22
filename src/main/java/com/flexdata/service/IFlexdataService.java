package com.flexdata.service;

import com.flexdata.api.request.IFlexdataRequest;
import com.flexdata.api.responce.IFlexdataResponse;
import com.flexdata.api.responce.IFlexdataUrlResponse;

import java.util.List;

public interface IFlexdataService {
    IFlexdataResponse getByHash(String hash);
    List<IFlexdataResponse> getRecentlyPublicPosts();
    IFlexdataUrlResponse createNew(IFlexdataRequest request);
}
