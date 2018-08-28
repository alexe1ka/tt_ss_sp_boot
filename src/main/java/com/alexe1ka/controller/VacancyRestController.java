package com.alexe1ka.controller;

import com.alexe1ka.model.Vacancies;
import com.alexe1ka.model.Vacancy;
import com.alexe1ka.service.VacanciesRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/")
public class VacancyRestController {

    private final VacanciesRestService service;

    @Autowired
    public VacancyRestController(VacanciesRestService service) {
        this.service = service;
    }


    //put /vacancy
    //TODO  - а если пытаются добавить уже существующую вакансию?
    @RequestMapping(value = "/vacancy", method = RequestMethod.PUT, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ResponseEntity<Vacancy> newVacancy(@RequestBody @Valid Vacancy vacancy) {
        if (vacancy == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.service.newVacancy(vacancy);
        return new ResponseEntity<>(vacancy, HttpStatus.CREATED);
    }


    //get /vacancy
//    @ResponseBody
//    @RequestMapping(value = "/vacancy", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
//    public ResponseEntity<List<Vacancy>> getVacancyList() {
//        List<Vacancy> vacancies = this.service.getVacancyList();
//        if (0 == vacancies.size()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(vacancies, HttpStatus.OK);
//    }

    @ResponseBody
    @RequestMapping(value = "/vacancy", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Vacancies> getVacancies() {
        Vacancies vacancies = new Vacancies();
        vacancies.setVacancyList(this.service.getVacancies());
        if (0 == vacancies.getVacancyList().size()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vacancies, HttpStatus.OK);
    }


    //get /vacancy/{id}
    @ResponseBody
    @RequestMapping(value = "/vacancy/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Vacancy> getVacancyById(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Vacancy vacancy = this.service.getVacancyById(id);
        log.info("get vac by id = " + id, vacancy);
        if (vacancy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(vacancy, HttpStatus.OK);
    }

    //delete /vacancy/{id}
    @ResponseBody
    @RequestMapping(value = "/vacancy/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Vacancy> deleteVacancyById(@PathVariable("id") Integer id) {
        Vacancy vacancy = this.service.getVacancyById(id);
        if (null == vacancy) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.service.deleteVacancyById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
