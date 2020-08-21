package com.CourtsProject.security;

public class AuthenticationResponse {
    private final String jwc;

    public AuthenticationResponse(String jwc) {
        this.jwc = jwc;
    }

    public String getJwc() {
        return jwc;
    }
}
