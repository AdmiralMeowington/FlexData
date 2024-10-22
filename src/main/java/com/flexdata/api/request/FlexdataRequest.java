package com.flexdata.api.request;

import lombok.Data;

@Data
public class FlexdataRequest implements IFlexdataRequest{
    private String data;
    private long expirationTimeSeconds;
    private PublicStatus publicStatus;
}
