package com.navent.integrations.igi.model;
//package com.navent.integrations.igi.model.repository;
//
//import static java.util.Optional.ofNullable;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//import com.navent.integrations.igi.ws.security.PostProviderGroup;
//
////@Repository
//public class InMemoryPostProviderRepository implements PostProviderRepository {
//
//    private final Map<Long, PostProviderGroup> postProviders;
//
//    public InMemoryPostProviderRepository() {
//        postProviders = new HashMap<Long, PostProviderGroup>();
//    }
//
//    @Override
//    public Optional<PostProviderGroup> findById(Long providerId) {
//        // boolean providerAllowed = provider.getCategory().equals(EXTERNAL);
//        // if (!providerAllowed) {
//        // throw new RuntimeException("Provider " + provider.getId() + " is not allowed to use this interface.");
//        // }
//
//        return ofNullable(postProviders.get(providerId));
//    }
//
// }
