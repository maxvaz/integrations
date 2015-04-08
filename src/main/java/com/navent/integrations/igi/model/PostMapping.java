package com.navent.integrations.igi.model;

public class PostMapping {

    private final Long providerPostId;
    private final Long navPlatId;

    public PostMapping(Long providerPostId, Long navPlatId) {
        this.providerPostId = providerPostId;
        this.navPlatId = navPlatId;
    }

    public Long getNavPlatId() {
        return navPlatId;
    }

    public Long getProviderPostId() {
        return providerPostId;
    }
}
