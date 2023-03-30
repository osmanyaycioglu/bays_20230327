package com.training.spring.bays.error;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         errorDesc;
    private Integer        errorCode;

    @Builder(setterPrefix = "with")
    public ErrorObj(final List<ErrorObj> subErrorsParam,
                    final String errorDescParam,
                    final Integer errorCodeParam) {
        super();
        this.subErrors = subErrorsParam;
        this.errorDesc = errorDescParam;
        this.errorCode = errorCodeParam;
    }

}
