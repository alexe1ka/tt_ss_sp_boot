package com.alexe1ka.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "VACANCIES")
@JacksonXmlRootElement(localName = "Vacancy:",namespace = "Vacancy:") //TODO xml?
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JacksonXmlProperty(isAttribute = true)
    @JacksonXmlProperty
    private Integer id;

    @JacksonXmlProperty
    @Column(name = "name")
    private String name;

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

    public Vacancy(String name, int salary, String experience, String city) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
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
        if (!name.equals(vacancy.name)) return false;
        if (!experience.equals(vacancy.experience)) return false;
        return city.equals(vacancy.city);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + salary;
        result = 31 * result + experience.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }
}
