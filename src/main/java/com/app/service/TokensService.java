package com.app.service;

import com.app.model.security.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokensService {

    private char[] accessToken;
    private char[] refreshToken;
    private char[] role;

    public void saveTokens(TokenDto tokens) {
        this.accessToken = tokens.getAccessToken().toCharArray();
        this.refreshToken = tokens.getRefreshToken().toCharArray();
        this.role = tokens.getRole().toCharArray();
    }

    public String getAccessToken() {
        return String.valueOf(accessToken);
    }

    public String getRefreshToken() {
        return String.valueOf(refreshToken);
    }

    public String getRole() {
        return role == null ? "BRAK" : String.valueOf(role);
    }

    public void clearTokens() {
        accessToken = null;
        refreshToken = null;
        role = null;
    }

}
