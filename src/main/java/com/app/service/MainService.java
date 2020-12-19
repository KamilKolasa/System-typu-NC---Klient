package com.app.service;

import com.app.model.InfoDto;
import com.app.model.get.GetPackDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final RestTemplate restTemplate;
    private final TokensService tokensService;

    public InfoDto<List<GetPackDto>> getThreeOffers() {

        HttpHeaders headres = new HttpHeaders();
        HttpEntity entity = new HttpEntity<>(headres);

        var responseData = restTemplate.exchange(CommunicationConfig.MAIN_URL + "listThreeOffers", HttpMethod.GET, entity, new ParameterizedTypeReference<InfoDto>() {
        });
        var info = responseData.getBody();
        return InfoDto.<List<GetPackDto>>builder().data((List<GetPackDto>)info.getData()).build();

        /*HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.BASE_URL + "listThreeOffers", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<String>builder().data(info.getData().toString()).build();*/
    }

    /*public Info<String> testUser() {

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.BASE_URL + "testUser", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<String>builder().data(info.getData().toString()).build();

    }

    public Info<String> testAdmin() {

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.BASE_URL + "testAdmin", HttpMethod.GET, entity, Info.class);
        var info = (Info) responseData.getBody();
        return Info.<String>builder().data(info.getData().toString()).build();

    }*/
}
