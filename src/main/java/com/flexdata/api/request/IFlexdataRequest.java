package com.flexdata.api.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = FlexdataRequest.class)
public interface IFlexdataRequest {
    String getData();
    long getExpirationTimeSeconds();
    PublicStatus getPublicStatus();
}
