package com.innovect.springproject.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "timesheet")
public class Timesheet  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private Integer id;

    @Column(name = "week")
    private Integer week;

    @Column(name = "hours")
    private Integer hours;


    public Timesheet( Integer week, Integer hours) {
        this.week = week;
        this.hours = hours;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
