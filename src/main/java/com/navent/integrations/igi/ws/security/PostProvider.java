package com.navent.integrations.igi.ws.security;

public class PostProvider {

    public static final Long TIQUE_IMOVEIS_PROVIDER_ID = 122L;
    static final int DEFAULT_POST_PROVIDER_ID_AS_INT = 1;
    static final int M2_POST_PROVIDER_ID_AS_INT = 101;

    private final Long id;
    private final String password;

    public PostProvider(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean checkPassword(String passwordToCheck) {
        return password.equals(passwordToCheck);
    }

    public Long getId() {
        return id;
    }

}
