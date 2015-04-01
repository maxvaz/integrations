package com.navent.integrations.igi.ws;

import static java.lang.Long.valueOf;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;

import com.dridco.inmuebles.ws.g7.model.Aviso;
import com.navent.integrations.igi.model.repository.InMemoryProviderUserRepository;
import com.navent.integrations.igi.model.repository.PostMappingRepository;
import com.navent.integrations.igi.model.repository.ProviderUserRepository;
import com.navent.integrations.igi.navplat.NavPlatClient;
import com.navent.integrations.igi.navplat.NavPlatPost;
import com.navent.integrations.igi.navplat.adapters.AvisoAdapter;

public class RealEstateServiceImplTest {

    private final PostMappingRepository postMappingRepository;
    private final ProviderUserRepository providerUserRepository;
    private final RealEstateServiceImpl realEstateServiceImpl;
    private final NavPlatClient navPlatCLient;
    private final AvisoAdapter avisoAdapter;

    public RealEstateServiceImplTest() {
        postMappingRepository = mock(PostMappingRepository.class);
        providerUserRepository = mock(InMemoryProviderUserRepository.class);
        navPlatCLient = mock(NavPlatClient.class);
        avisoAdapter = mock(AvisoAdapter.class);

        realEstateServiceImpl = new RealEstateServiceImpl(navPlatCLient, avisoAdapter, postMappingRepository,
                providerUserRepository);
    }

    @Test(expected = IllegalStateException.class)
    public void whenNoProviderUserMappingFoundThenThrowsException() throws Exception {

        when(providerUserRepository.mapToNavPlatId(anyLong(), anyString())).thenReturn(empty());

        String ANY_PROVIDER_USER_ID = "ANY_PROVIDER_USER_ID";
        Long ANY_PROVIDER_ID = 1L;
        String ANY_PROVIDER_POST_ID = "ANY_PROVIDER_POST_ID";

        realEstateServiceImpl.consultarAviso(ANY_PROVIDER_USER_ID, ANY_PROVIDER_ID, null, ANY_PROVIDER_POST_ID);
    }

    @Test
    public void whenNavPlatClientDoesNotFoundPostThenAvisoMustBeNull() throws Exception {
        Long ANY_ID = 1L;
        String ANY_NUMERIC_STRING_ID = "1234";

        when(providerUserRepository.mapToNavPlatId(anyLong(), anyString())).thenReturn(of(ANY_ID));
        when(postMappingRepository.mapToNavPlatId(anyLong(), anyString(), anyString())).thenReturn(of(ANY_ID));
        when(navPlatCLient.get(ANY_ID, ANY_ID)).thenReturn(empty());

        Aviso aviso = realEstateServiceImpl.consultarAviso(ANY_NUMERIC_STRING_ID, ANY_ID, null, ANY_NUMERIC_STRING_ID);
        assertNull(aviso);
    }

    @Test
    public void basicFlow() {
        long providerId = 1L;
        String providerPostId = "2";
        String providerUserId = "3";
        Long userId = 4L;
        Long postId = 5L;

        when(providerUserRepository.mapToNavPlatId(eq(providerId), eq(providerUserId))).thenReturn(of(userId));
        when(postMappingRepository.mapToNavPlatId(eq(providerId), eq(providerUserId), eq(providerPostId))).thenReturn(
                of(postId));

        Optional<NavPlatPost> navPlatPost = of(navPlatPost());
        Aviso aviso = aviso();

        when(navPlatCLient.get(postId, userId)).thenReturn(navPlatPost);
        when(avisoAdapter.adapt(eq(navPlatPost))).thenReturn(aviso);

        assertEquals(aviso, realEstateServiceImpl.consultarAviso(providerUserId, providerId, null, providerPostId));
    }

    @Test
    public void whenThereIsNoProviderMappingItFallbackToPostId() {
        long providerId = 1L;
        String providerPostId = "2";
        String providerUserId = "3";
        Long userId = 4L;

        when(providerUserRepository.mapToNavPlatId(eq(providerId), eq(providerUserId))).thenReturn(of(userId));
        when(postMappingRepository.mapToNavPlatId(anyLong(), anyString(), anyString())).thenReturn(empty());

        Optional<NavPlatPost> navPlatPost = of(navPlatPost());
        Aviso aviso = aviso();

        when(navPlatCLient.get(valueOf(providerPostId), userId)).thenReturn(navPlatPost);
        when(avisoAdapter.adapt(eq(navPlatPost))).thenReturn(aviso);

        assertEquals(aviso, realEstateServiceImpl.consultarAviso(providerUserId, providerId, null, providerPostId));
    }

    @Test
    public void whenPostExistsForBothProviderPostIdAndPostIdThenProviderPostMustBePriority() {
        long providerId = 1L;
        String providerPostId = "2";
        String providerUserId = "3";
        Long userId = 4L;
        Long postIdFromMapping = 5L;

        when(providerUserRepository.mapToNavPlatId(eq(providerId), eq(providerUserId))).thenReturn(of(userId));
        when(postMappingRepository.mapToNavPlatId(anyLong(), anyString(), anyString())).thenReturn(
                of(postIdFromMapping));

        Optional<NavPlatPost> navPlatPost = of(navPlatPost());
        Optional<NavPlatPost> otherNavPlatPost = of(navPlatPost());
        Aviso aviso = aviso();
        Aviso otherAviso = aviso();

        when(navPlatCLient.get(valueOf(providerPostId), userId)).thenReturn(navPlatPost);
        when(navPlatCLient.get(valueOf(postIdFromMapping), userId)).thenReturn(otherNavPlatPost);
        when(avisoAdapter.adapt(eq(navPlatPost))).thenReturn(aviso);
        when(avisoAdapter.adapt(eq(otherNavPlatPost))).thenReturn(otherAviso);

        assertEquals(otherAviso, realEstateServiceImpl.consultarAviso(providerUserId, providerId, null, providerPostId));
    }

    private Aviso aviso() {
        return new Aviso();
    }

    private NavPlatPost navPlatPost() {
        return new NavPlatPost();
    }

}
