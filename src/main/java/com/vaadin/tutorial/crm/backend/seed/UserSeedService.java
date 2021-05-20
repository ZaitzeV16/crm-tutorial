package com.vaadin.tutorial.crm.backend.seed;

import com.vaadin.tutorial.crm.backend.entity.pkgCalendar.calendar.model.Calendar;
import com.vaadin.tutorial.crm.backend.entity.user.UserService;
import com.vaadin.tutorial.crm.backend.entity.user.model.User;
import com.vaadin.tutorial.crm.backend.library.base.seed.BaseSeedService;
import com.vaadin.tutorial.crm.backend.library.base.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SeedService(dependsOn = CalendarSeedService.class)
public class UserSeedService extends BaseSeedService<User, UserService> {

    private final CalendarSeedService calendarSeedService;

    @Autowired
    public UserSeedService(UserService userService, CalendarSeedService calendarSeedService) {
        super(userService);
        this.calendarSeedService = calendarSeedService;
    }

    @Override
    public List<User> generateSeedData() {
        User user = this.entityService.save(new User("user", null));

        Calendar calendar = this.calendarSeedService.findAll().stream().findAny().orElse(null);
        user.setCalendar(calendar);

        return List.of(user);
    }

}
