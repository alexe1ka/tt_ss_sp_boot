package com.alexe1ka.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "all_vacancies")
public class Vacancies {
    @JacksonXmlProperty(localName = "vacancy")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Vacancy> vacancyList;

    public Vacancies() {
    }

    public Vacancies(List<Vacancy> vacancyList) {
        this.vacancyList = vacancyList;
    }

    public List<Vacancy> getVacancyList() {
        return vacancyList;
    }

    public void setVacancyList(List<Vacancy> vacancyList) {
        this.vacancyList = vacancyList;
    }
}
