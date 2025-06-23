package com.kfreemarket.reemarket_server.global.security.dto;

import java.util.Map;

public class NaverResponse implements OAuth2Response {

    private final Map<String, Object> attribute;

    public NaverResponse(Map<String, Object> attribute) {

        this.attribute = (Map<String, Object>) attribute.get("response");
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getProviderId() {
        return attribute.get("id") == null ? "" : attribute.get("id").toString();
    }

    @Override
    public String getEmail() {
        return attribute.get("email") == null ? "" : attribute.get("email").toString();
    }

    @Override
    public String getName() {
        return attribute.get("name") == null ? "" : attribute.get("name").toString();
    }
}
