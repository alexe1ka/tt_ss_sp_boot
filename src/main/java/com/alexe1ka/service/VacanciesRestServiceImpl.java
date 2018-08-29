package com.alexe1ka.service;

import com.alexe1ka.model.Vacancy;
import com.alexe1ka.repository.VacancyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Slf4j
@Service
public class VacanciesRestServiceImpl implements VacanciesRestService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacanciesRestServiceImpl(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }


    @Override
    public void newVacancy(Vacancy vacancy) {
        log.info("save in db");
        this.vacancyRepository.save(vacancy);
    }

    @Override
    public List<Vacancy> getVacancies() {
        log.info("get all vacancies by name");
        return vacancyRepository.findAll(orderBy());
    }

    //sort by title
    private Sort orderBy() {
        return new Sort(Sort.Direction.ASC, "title");
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
