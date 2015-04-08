package com.navent.integrations.igi.admin;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.navent.integrations.igi.IgiApp;
import com.navent.integrations.igi.model.PostProviderGroup;
import com.navent.integrations.igi.model.PostProviderGroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IgiApp.class)
@WebAppConfiguration
@Transactional
public class PostProviderGroupAdminControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    @Autowired
    private PostProviderGroupRepository postProviderGroupRepository;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getPostProviderGroup() throws Exception {
        Long postProviderGroupId = 1L;

        postProviderGroupRepository.save(new PostProviderGroup(postProviderGroupId, "aPassword"));

        String apiUrl = "/api/postProviderGroups/";
        mockMvc.perform(get(apiUrl + postProviderGroupId)).//
        andExpect(status().isOk()).//
        andExpect(jsonPath("$._links.self.href", is("http://localhost" + apiUrl + postProviderGroupId)));
    }
}
