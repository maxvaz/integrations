package com.navent.integrations.igi.admin;

import static org.springframework.hateoas.Link.REL_SELF;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navent.integrations.igi.model.PostProviderGroupRepository;
import com.navent.integrations.igi.validation.InvalidRequestException;
import com.navent.integrations.igi.ws.security.PostProviderGroup;

@RestController
@RequestMapping("/api/postProviderGroups")
public class PostProviderGroupAdminController {

    @Autowired
    private PostProviderGroupRepository postProviderGroupRepository;

    @RequestMapping(value = "/{id}", method = GET)
    public PostProviderGroupResource get(@PathVariable Long id) {
        PostProviderGroup postProviderGroup = postProviderGroupRepository.findOne(id);
        return new PostProviderGroupResource(postProviderGroup);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<Object> post(@RequestBody @Valid PostProviderGroup postProviderGroup,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException(bindingResult);
        }
        postProviderGroupRepository.save(postProviderGroup);

        return new ResponseEntity<>(null, selfLocationHeaders(postProviderGroup), CREATED);
    }

    private HttpHeaders selfLocationHeaders(PostProviderGroup postProviderGroup) {
        HttpHeaders httpHeaders = new HttpHeaders();

        Link location = new PostProviderGroupResource(postProviderGroup).getLink(REL_SELF);
        httpHeaders.setLocation(URI.create(location.getHref()));
        return httpHeaders;
    }

}

class PostProviderGroupResource extends ResourceSupport {

    public PostProviderGroupResource(PostProviderGroup postProviderGroup) {
        this.add(linkTo(methodOn(PostProviderGroupAdminController.class).get(postProviderGroup.getId())).withSelfRel());
    }

}
