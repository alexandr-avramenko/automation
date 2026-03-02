package org.automation.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String username;
    private String email;
    private String currentAddress;
    private String permanentAddress;
}
