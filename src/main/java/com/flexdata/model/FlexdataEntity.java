package com.flexdata.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlexdataEntity {
    private int id;
    private String data;
    private String hash;
    private LocalDateTime expirationTime;
    private Boolean isPublic;
}
