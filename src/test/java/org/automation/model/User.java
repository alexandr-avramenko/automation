package org.automation.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class User {
    private String username;
    private String email;
    private String currentAddress;
    private String permanentAddress;
}
