package com.app.service;

import com.app.model.CategoryDto;
import com.app.model.InfoDto;
import com.app.model.create.CreateFilmDto;
import com.app.model.get.*;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final RestTemplate restTemplate;
    private final TokensService tokensService;

    public InfoDto<Map<CategoryDto,Long>> countCategories() {

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "countCategories", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<Map<CategoryDto,Long>>builder().data((Map<CategoryDto,Long>)info.getData()).build();
    }

    public InfoDto<List<CategoryDto>> getAllCategorys() {

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "allCategorys", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<List<CategoryDto>>builder().data((List<CategoryDto>)info.getData()).build();
    }

    public InfoDto<String> addCategory(CategoryDto categoryDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity<CategoryDto> entity = new HttpEntity<>(categoryDto, headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "addCategory", HttpMethod.POST, entity, new ParameterizedTypeReference<InfoDto>() {});
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<String>builder().data(info.getData().toString()).build();
    }

    public InfoDto<List<GetFilmDto>> getAllFilms(){

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "allFilms", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<List<GetFilmDto>>builder().data((List<GetFilmDto>)info.getData()).build();
    }

    public InfoDto<String> addFilm(CreateFilmDto createFilmDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity<CreateFilmDto> entity = new HttpEntity<>(createFilmDto, headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "addFilm", HttpMethod.POST, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<String>builder().data(info.getData().toString()).build();
    }

    public InfoDto<List<GetChannelDto>> getAllChannels(){

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "allChannels", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<List<GetChannelDto>>builder().data((List<GetChannelDto>)info.getData()).build();
    }

    public InfoDto<List<GetPackTvDto>> getAllPackTvs(){

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "allPackTvs", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<List<GetPackTvDto>>builder().data((List<GetPackTvDto>)info.getData()).build();
    }

    public InfoDto<List<GetPackInternetDto>> getAllPackInternets(){

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "allPackInternets", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<List<GetPackInternetDto>>builder().data((List<GetPackInternetDto>)info.getData()).build();
    }

    public InfoDto<List<GetPackPhoneDto>> getAllPackPhones(){

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "allPackPhones", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<List<GetPackPhoneDto>>builder().data((List<GetPackPhoneDto>)info.getData()).build();
    }

    public InfoDto<List<GetPackDtoOffert>> getAllPacks(){

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "allPacks", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<List<GetPackDtoOffert>>builder().data((List<GetPackDtoOffert>)info.getData()).build();
    }

    public InfoDto<List<GetUserUserDto>> getAllUsers(){

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "allUsers", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<List<GetUserUserDto>>builder().data((List<GetUserUserDto>)info.getData()).build();
    }

    public InfoDto<List<GetUserAdminDto>> getAllAdmins(){

        HttpHeaders headers = new HttpHeaders();
        headers.add(CommunicationConfig.TOKEN_HEADER, CommunicationConfig.TOKEN_PREFIX + tokensService.getAccessToken());
        HttpEntity entity = new HttpEntity<>(headers);

        var responseData = restTemplate.exchange(CommunicationConfig.ADMIN_URL + "allAdmins", HttpMethod.GET, entity, InfoDto.class);
        var info = (InfoDto) responseData.getBody();
        return InfoDto.<List<GetUserAdminDto>>builder().data((List<GetUserAdminDto>)info.getData()).build();
    }
}
