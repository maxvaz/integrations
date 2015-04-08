package com.navent.integrations.igi.ws.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class PostProviderGroup {

    @Id
    @NotNull
    private final Long id;
    @Size(min = 4)
    @NotNull
    private final String password;
    @OneToMany
    private final Set<PostProviderUser> users;

    // used by hibernate
    @SuppressWarnings("unused")
    private PostProviderGroup() {
        this(null, null, null);
    }

    public PostProviderGroup(Long id, String password) {
        this(id, password, new HashSet<PostProviderUser>());
    }

    public PostProviderGroup(Long id, String password, Set<PostProviderUser> users) {
        this.id = id;
        this.password = password;
        this.users = users;
    }

    public boolean checkPassword(String passwordToCheck) {
        return password.equals(passwordToCheck);
    }

    public Set<PostProviderUser> getUsers() {
        return users;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
