package com.navent.integrations.igi.model.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.navent.integrations.igi.IgiApp;
import com.navent.integrations.igi.model.PostProviderGroupRepository;
import com.navent.integrations.igi.ws.security.PostProviderGroup;
import com.navent.integrations.igi.ws.security.PostProviderUser;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IgiApp.class)
@Transactional
public class PostProviderRepositoryTest {

    @Autowired
    private PostProviderGroupRepository repo;

    @Test
    public void NoEntitiesShouldBeFoundWhenDatabaseIsEmpty() throws Exception {
        assertFalse(repo.findAll().iterator().hasNext());
    }

    @Test
    public void saveAndRetrieveEntityById() throws Exception {
        repo.save(new PostProviderGroup(1L, "password", new HashSet<PostProviderUser>()));
        assertTrue(repo.findById(1L).isPresent());
    }
}
