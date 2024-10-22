package com.flexdata.api.responce;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = FlexdataUrlResponse.class)
public interface IFlexdataUrlResponse {
    String getUrl();
}
