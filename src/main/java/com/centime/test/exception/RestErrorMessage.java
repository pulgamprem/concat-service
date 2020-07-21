package com.centime.test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RestErrorMessage {
    EC_1001(1001,"Name/Surname cannot be null");

    private int code;
    private String message;

}
