package com.vaadin.tutorial.crm.backend.seed;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.entity.user.UserService;
import com.vaadin.tutorial.crm.backend.entity.user.model.User;
import com.vaadin.tutorial.crm.backend.library.base.seed.BaseSeedService;
import com.vaadin.tutorial.crm.backend.library.base.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SeedService
public class UserSeedService extends BaseSeedService<User, UserService> {

    @Autowired
    public UserSeedService(UserService userService) {
        super(userService);
    }

    @Override
    public List<User> generateSeedData() {
        return List.of(new User("user", new Calendar()));
    }

}
