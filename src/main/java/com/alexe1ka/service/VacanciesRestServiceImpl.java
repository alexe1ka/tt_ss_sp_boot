package com.alexe1ka.service;

import com.alexe1ka.model.Vacancy;
import com.alexe1ka.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;


@Service
public class VacanciesRestServiceImpl implements VacanciesRestService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacanciesRestServiceImpl(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public void newVacancy(Vacancy vacancy) {
        System.out.println("save in db");
        this.vacancyRepository.save(vacancy);
    }

    @Override
    public List<Vacancy> getVacancies() {
        System.out.println("get all vacancies");
        return vacancyRepository.findAll();
    }

    @Override
    public Vacancy getVacancyById(int id) {
        System.out.println("get vacancy by id");
        return vacancyRepository.getOne(id);
    }

    @Override
    public void deleteVacancyById(int id) {
        System.out.println("delete vacancy by id");
        vacancyRepository.deleteById(id);
    }
}
