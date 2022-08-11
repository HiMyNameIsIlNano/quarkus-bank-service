package com.himynameisilnano;

import io.smallrye.config.ConfigMapping;

import javax.validation.constraints.Size;

@ConfigMapping(prefix = "bank.support")
public interface BankBusinessSupport {

    Business business();

    interface Business {
        @Size(min = 4, max = 4)
        String phone();
        String email();
    }
}
