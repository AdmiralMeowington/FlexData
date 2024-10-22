package com.flexdata.api.responce;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class FlexdataUrlResponse implements IFlexdataUrlResponse{
    private final String url;
}
