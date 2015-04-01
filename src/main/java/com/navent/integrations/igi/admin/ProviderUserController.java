package com.navent.integrations.igi.admin;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navent.integrations.igi.model.repository.ProviderUserRepository;

@RestController
public class ProviderUserController {

    private final ProviderUserRepository providerUserRepository;

    @Autowired
    public ProviderUserController(ProviderUserRepository providerUserRepository) {
        this.providerUserRepository = providerUserRepository;
    }

    @RequestMapping(value = "/providers/{providerId}/users/${providerUserId}", method = PUT)
    public void a(Long providerId, String providerUserId, Long navPlatUserId) {
        providerUserRepository.addMapping(providerId, providerUserId, navPlatUserId);
        // mappings.put(key(8L, "5874251"), 99999L);
    }

}
