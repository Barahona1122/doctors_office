package com.example.demo.models;

import java.time.LocalDateTime;

import com.example.demo.domain.helpers.ParseToDateAndTime;
import com.example.demo.domain.objects.AppointmentsObject;
import com.example.demo.domain.objects.OfficesObject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class AppointmentsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_id")
    private int officeId;
    @Column(name = "consultation_date") // TOOD: CHANGE TO DATE AN TIME FOR CHOOSE ONE DATE IN TIME FOR CONSULTATION
    private String date;

    @Column(name = "consultation_hour") // TOOD: CHANGE TO DATE AN TIME FOR CHOOSE ONE DATE IN TIME FOR CONSULTATION
    private String time;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "status", columnDefinition = "int default " + AppointmentsObject.statusActive)
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getDateAndTime() {
        LocalDateTime localTime = ParseToDateAndTime
                .parseToDateAndTime(this.getDate() + " " + this.getTime());

        return localTime;
    }

}
