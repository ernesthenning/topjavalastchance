package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.web.SecurityUtil;
import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

import java.util.List;

@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(MealRestController.class);
    @Autowired
    private MealService service;

    public List<MealTo> getAll() {
        return service.getAll(SecurityUtil.authUserId(), SecurityUtil.authUserCaloriesPerDay());
    }

    public Meal get(int id) {
        return service.get(id, SecurityUtil.authUserId());
    }

    public void delete(int id) {
        service.delete(id, SecurityUtil.authUserId());
    }

    public Meal update(Meal meal, int id) {
        assureIdConsistent(meal, id);
        return service.update(meal, SecurityUtil.authUserId());
    }

    public Meal create(Meal meal) {
        checkNew(meal);
        return service.create(meal, SecurityUtil.authUserId());
    }

}