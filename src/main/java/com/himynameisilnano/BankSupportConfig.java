package com.himynameisilnano;

import org.eclipse.microprofile.config.inject.ConfigProperties;

@ConfigProperties(prefix = "bank-support")
public class BankSupportConfig {
    private String phone;

    String email;

    public String getPhone() {
        return phone;
    }
}
