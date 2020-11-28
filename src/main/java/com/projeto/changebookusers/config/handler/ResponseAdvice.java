package com.projeto.changebookusers.config.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAdvice {

    private String code;
    private String description;

    public static ResponseAdvice defaultInternal() {
        return ResponseAdvice.builder()
                .code("500")
                .description("Internal Server Error, please contact the support or try it again later.")
                .build();
    }

}
