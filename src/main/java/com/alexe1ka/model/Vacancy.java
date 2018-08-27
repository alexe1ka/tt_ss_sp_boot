package com.alexe1ka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vacancy {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int salary;
    private String experience;
    private String city;

    public Vacancy() {
    }

    public Vacancy(String name, int salary, String experience, String city) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

        if (id != vacancy.id) return false;
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