package com.common.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public
class ServiceResponse implements Serializable {
    private static final long serialVersionUID = -7608591897563945814L;
    private boolean successful = true;
    private String code;
    private String message;
}
