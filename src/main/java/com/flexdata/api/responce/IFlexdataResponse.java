package com.flexdata.api.responce;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = FlexdataResponse.class)
public interface IFlexdataResponse {
    String getData();
    boolean isPublic();
}
