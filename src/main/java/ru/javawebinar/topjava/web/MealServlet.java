package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.repository.InMemoryMealRepository;
import ru.javawebinar.topjava.repository.InMemoryMealRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final int CALORIES = 2000;
    private static final Logger log = getLogger(MealServlet.class);

    Map<LocalDate, Integer> caloriesSumByDay = InMemoryMealRepositoryImpl.meals.stream()
            .collect(Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories)));
    List<MealTo> mealTos = InMemoryMealRepositoryImpl.meals.stream()
            .map(meal -> new MealTo(meal.getDateTime(), meal.getDescription(),
                    meal.getCalories(), caloriesSumByDay.get(meal.getDate()) > CALORIES))
            .collect(Collectors.toList());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("mealTos", mealTos);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
