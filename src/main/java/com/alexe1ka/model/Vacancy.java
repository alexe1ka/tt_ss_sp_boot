package com.alexe1ka.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vacancies")
@JacksonXmlRootElement(localName = "vacancy")
public class Vacancy implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JacksonXmlProperty(isAttribute = true)
    @JacksonXmlProperty
    private Integer id;


    @JacksonXmlProperty
    @Column(name = "title")
    private String title;

    @JacksonXmlProperty
    @Column(name = "salary")
    private int salary;

    @JacksonXmlProperty
    @Column(name = "experience")
    private String experience;

    @JacksonXmlProperty
    @Column(name = "city")
    private String city;

    public Vacancy() {
    }

    public Vacancy(String title, int salary, String experience, String city) {
        this.title = title;
        this.salary = salary;
        this.experience = experience;
        this.city = city;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", salary=" + salary +
                ", experience='" + experience + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy = (Vacancy) o;

        if (!id.equals(vacancy.id)) return false;
        if (salary != vacancy.salary) return false;
        if (!title.equals(vacancy.title)) return false;
        if (!experience.equals(vacancy.experience)) return false;
        return city.equals(vacancy.city);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + salary;
        result = 31 * result + experience.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}
