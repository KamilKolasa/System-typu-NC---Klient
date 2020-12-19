package com.app.service;

import com.app.model.InfoDto;
import com.app.model.create.CreateUserDto;
import com.app.model.security.AuthenticationUserDto;
import com.app.model.security.ForgetPasswordDto;
import com.app.model.security.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final RestTemplate restTemplate;
    private final TokensService tokensService;

    public InfoDto<String> register(CreateUserDto createUserDto) {

        HttpEntity<CreateUserDto> entity = new HttpEntity<>(createUserDto);

        ResponseEntity<InfoDto<String>> responseData = restTemplate.exchange(CommunicationConfig.SECURITY_URL + "registration", HttpMethod.POST, entity, new ParameterizedTypeReference<InfoDto<String>>() {});
        var info = responseData.getBody();
        return info;
    }

    public InfoDto<String> login(AuthenticationUserDto user) {

        HttpEntity<AuthenticationUserDto> entity = new HttpEntity<>(user);

        var responseData = restTemplate.exchange(CommunicationConfig.BASE_URL + "my-login", HttpMethod.POST, entity, Map.class);
        var map = (Map<String, String>)responseData.getBody().get("data");
        tokensService.saveTokens(TokenDto.builder().accessToken(map.get("accessToken")).refreshToken(map.get("refreshToken")).role(map.get("role")).build());
        return InfoDto.<String>builder().data("USER " + user.getUsername() + " LOGGED IN").build();
    }

    public InfoDto<String> generateResetPasswordToken(ForgetPasswordDto forgetPasswordDto) {

        HttpEntity<ForgetPasswordDto> entity = new HttpEntity<>(forgetPasswordDto);

        var responseData = restTemplate.exchange(CommunicationConfig.SECURITY_URL + "forgetPassword", HttpMethod.POST, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<String>builder().data(info.getData().toString()).build();
    }

    public void logout() {
        tokensService.clearTokens();
    }

    public InfoDto<String> refreshToken() {
        var responseData = restTemplate.exchange(CommunicationConfig.SECURITY_URL + "refreshToken?token=" + tokensService.getRefreshToken(), HttpMethod.POST, null, Map.class);
        var map = (Map<String, String>)responseData.getBody().get("data");
        tokensService.saveTokens(TokenDto.builder().accessToken(map.get("accessToken")).refreshToken(map.get("refreshToken")).build());
        return InfoDto.<String>builder().data("TOKEN REFRESHED").build();
    }
}
