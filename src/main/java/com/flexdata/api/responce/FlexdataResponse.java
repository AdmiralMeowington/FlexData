package com.flexdata.api.responce;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class FlexdataResponse implements IFlexdataResponse{
    private final String data;
    private final boolean isPublic;
}
