package com.example.demo.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.objects.AppointmentsObject;
import com.example.demo.models.AppointmentsModel;
import com.example.demo.repository.AppointmentsRepository;

@Service
public class AppointmentService {
    @Autowired
    AppointmentsRepository appointmentsRepository;

    /**
     * @return
     */
    public ArrayList<AppointmentsModel> findAll() {
        return (ArrayList<AppointmentsModel>) appointmentsRepository.findAll();
    }

    /**
     * @param appointmentsModel
     * @return
     */
    public AppointmentsModel save(AppointmentsModel appointmentsModel) {
        return appointmentsRepository.save(appointmentsModel);
    }

    /**
     * function for create an appointment
     * 
     * @param appointmentsModel
     * @return
     */
    public boolean isValidCreateAppointment(AppointmentsModel appointmentsModel) {
        ArrayList<AppointmentsModel> data = this.findByDateAndTimeAndOfficeIdAndUserId(appointmentsModel.getDate(),
                appointmentsModel.getTime(),
                appointmentsModel.getOfficeId(), appointmentsModel.getUserId());
        int listSize = data.size();
        if (listSize == 0) {
            AppointmentsModel lastAppointment = this.getLastAppointment(appointmentsModel.getUserId(),
                    appointmentsModel.getDate());
            if (!this.isModelEmpty(lastAppointment)) {
                // CHECK THE DIFERENCE between LAST APPOINTMENT AND NEW APPOINTMENT, THAT IN
                // HOURS
                LocalDateTime startDate = appointmentsModel.getDateAndTime();
                LocalDateTime endDate = lastAppointment.getDateAndTime();
                Duration duration = Duration.between(startDate, endDate);
                int hours = (int) duration.toHours();

                return (hours * -1) > AppointmentsObject.validAfterHour;
            }
        }

        return listSize == 0;
    }

    /**
     * @param userId
     * @param date
     * @return
     */
    public AppointmentsModel getLastAppointment(int userId, String date) {
        return appointmentsRepository.findByUserIdAndDate(userId, date);
    }

    /**
     * Get Appointment by date, time, office_id and user_id
     * 
     * @param String date
     * @param String time
     * @param int    officeId
     * @param int    officeId
     * @return
     */
    public ArrayList<AppointmentsModel> findByDateAndTimeAndOfficeIdAndUserId(String date, String time, int officeId,
            int userId) {
        return (ArrayList<AppointmentsModel>) appointmentsRepository.findByDateAndTimeAndOfficeIdAndUserId(date, time,
                officeId,
                userId);
    }

    /**
     * @param date
     * @param officeId
     * @param userId
     * @return
     */
    public ArrayList<AppointmentsModel> findByDateAndOfficeIdAndUserId(String date, int officeId, int userId) {
        return (ArrayList<AppointmentsModel>) appointmentsRepository.findByDateAndOfficeIdAndUserId(date,
                officeId,
                userId);
    }

    /**
     * @param appointmentsModel
     * @return
     */
    public boolean isModelEmpty(AppointmentsModel appointmentsModel) {
        return appointmentsModel == null;
    }
}
