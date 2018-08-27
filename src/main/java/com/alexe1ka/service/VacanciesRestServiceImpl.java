package com.alexe1ka.service;

import com.alexe1ka.model.Vacancy;
import com.alexe1ka.repository.VacancyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service
public class VacanciesRestServiceImpl implements VacanciesRestService {

    @Autowired
    VacancyRepository vacancyRepository;


    @Override
    public void newVacancy(Vacancy vacancy) {
        log.info("save in db");
        this.vacancyRepository.save(vacancy);
    }

    @Override
    public List<Vacancy> getVacancies() {
        log.info("get all vacancies");
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy getVacancyById(Integer id) {
        log.info("get vacancy by id = {}", id);
        return vacancyRepository.getOne(id);
    }

    @Override
    public void deleteVacancyById(Integer id) {
        log.info("delete vacancy by id = {}", id);
        vacancyRepository.deleteById(id);
    }
}
