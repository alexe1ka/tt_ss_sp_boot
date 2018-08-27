package com.alexe1ka.service;

import com.alexe1ka.model.Vacancy;

import java.util.List;

public interface VacanciesRestService {
    void newVacancy(Vacancy vacancy);

    List<Vacancy> getVacancies();

    Vacancy getVacancyById(Integer id);

    void deleteVacancyById(Integer id);
}
