package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

public interface InMemoryMealRepository {
    void addMeal();
    Meal getMeal();
    Meal updateMeal();
    void deleteMeal();
}
