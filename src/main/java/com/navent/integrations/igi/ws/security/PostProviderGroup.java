package com.navent.integrations.igi.ws.security;

import java.util.Set;

public class PostProviderGroup {

    private final Long id;
    private final String password;
    private final Set<PostProviderUser> users;

    public PostProviderGroup(Long id, String password, Set<PostProviderUser> users) {
        this.id = id;
        this.password = password;
        this.users = users;
    }

    public boolean checkPassword(String passwordToCheck) {
        return password.equals(passwordToCheck);
    }

    public Long getId() {
        return id;
    }

    public Set<PostProviderUser> getUsers() {
        return users;
    }

}
