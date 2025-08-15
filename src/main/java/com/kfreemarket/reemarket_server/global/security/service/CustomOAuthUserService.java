package com.kfreemarket.reemarket_server.global.security.service;

import com.kfreemarket.reemarket_server.domain.user.entity.User;
import com.kfreemarket.reemarket_server.domain.user.repository.UserRepository;
import com.kfreemarket.reemarket_server.global.enums.UserRole;
import com.kfreemarket.reemarket_server.global.security.dto.*;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuthUserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuthUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        System.out.println(oAuth2User);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        OAuth2Response oAuth2Response = null;

        if (registrationId.equals("naver")) {
            oAuth2Response = new NaverResponse(oAuth2User.getAttributes());

        }
        else if (registrationId.equals("google")) {

            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("kakao")){

            oAuth2Response=new KakaoResponse(oAuth2User.getAttributes());

        }
        else {

            return null;
        }

        //리소스 서버에서 발급 받은 정보로 사용자를 특정할 아이디값을 만듬
        String username = oAuth2Response.getProvider()+" "+oAuth2Response.getProviderId();

        User existData = userRepository.findByUserName(username);

        if (existData == null) {
            User userEntity =  User.builder()
                    .username(username)
                    .email(oAuth2Response.getEmail())
                    .name(oAuth2Response.getName())
                    .userRole(UserRole.ROLE_USER)
                    .build();

            userRepository.save(userEntity);

            SecurityUserDto securityUserDto = new SecurityUserDto();
            securityUserDto.setUsername(username);
            securityUserDto.setName(oAuth2Response.getName());
            securityUserDto.setRole(UserRole.ROLE_USER);

            return new CustomOAuth2User(securityUserDto);

        }else{
            existData.builder()
                    .username(username)
                    .email(oAuth2Response.getEmail())
                    .name(oAuth2Response.getName())
                    .build();

            userRepository.save(existData);

            SecurityUserDto securityUserDto = new SecurityUserDto();
            securityUserDto.setUsername(existData.getUserName());
            securityUserDto.setName(oAuth2Response.getName());
            securityUserDto.setRole(existData.getUserRole());

            return new CustomOAuth2User(securityUserDto);
        }

    }
}
