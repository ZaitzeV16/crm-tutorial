package com.vaadin.tutorial.crm.backend.entity.user;

import com.vaadin.tutorial.crm.backend.entity.user.model.User;
import com.vaadin.tutorial.crm.backend.entity.user.repo.UserRepo;
import com.vaadin.tutorial.crm.backend.library.base.service.BaseEntityService;
import hu.hellp.mdss.service.processor.ModelDtoSerializerService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseEntityService<User, Long, UserRepo> {

    protected UserService(UserRepo repo, ModelDtoSerializerService mds) {
        super(repo, mds);
    }

    public User findLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return this.findByUsername(currentPrincipalName);
    }

    public User findByUsername(String username) {
        return this.repo.findByUsername(username);
    }

}
