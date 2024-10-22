package com.flexdata.api.request;

public interface IFlexdataRequest {
    String getData();
    long getExpirationTimeSeconds();
    PublicStatus getPublicStatus();
}
