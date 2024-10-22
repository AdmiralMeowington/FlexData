package com.flexdata.exeptions;

public class NotFoundFlexdataEntityException extends RuntimeException {
    public NotFoundFlexdataEntityException(String s) {
        super(s);
    }
}
