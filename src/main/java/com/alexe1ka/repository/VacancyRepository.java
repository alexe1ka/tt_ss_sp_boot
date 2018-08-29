package com.alexe1ka.repository;

import com.alexe1ka.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy,Integer> {

}
