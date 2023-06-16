package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.AppointmentsModel;

@Repository
public interface AppointmentsRepository extends JpaRepository<AppointmentsModel, Long> {

    /**
     * @return
     */
    List<AppointmentsModel> findByDateAndTimeAndOfficeIdAndUserId(String date, String time, int officeId, int userId); // TODO:
                                                                                                                       // CHANGE
                                                                                                                       // BY
                                                                                                                       // VALID
                                                                                                                       // DATE
                                                                                                                       // FORMAT

    /**
     * @param userId
     * @param date
     * @return
     */
    AppointmentsModel findByUserIdAndDate(int userId, String date);

    /**
     * @param date
     * @param officeId
     * @param userId
     * @return
     */
    List<AppointmentsModel> findByDateAndOfficeIdAndUserId(String date, int officeId, int userId);
}
