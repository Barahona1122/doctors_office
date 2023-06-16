package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.network.ApiResponse;
import com.example.demo.domain.network.ApiRoutes;
import com.example.demo.domain.objects.ApiResponseObject;
import com.example.demo.models.AppointmentsModel;
import com.example.demo.services.AppointmentService;

@RestController
public class AppointmentsController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping(ApiRoutes.appointments + ApiRoutes.appointmentFindByParms)
    public ApiResponseObject findByDateAndOfficeIdAndUserId(@RequestParam("consultation_date") String date,
            @RequestParam("office_id") int officeId, @RequestParam("user_id") int userId) {
        return ApiResponse.success(true, "Success",
                appointmentService.findByDateAndOfficeIdAndUserId(date, officeId, userId));
    }

    /**
     * @param appointmentsModel
     * @return
     */
    @RequestMapping(value = ApiRoutes.appointments
            + ApiRoutes.appointmentsSave, method = RequestMethod.POST, produces = {
                    MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
    public ApiResponseObject store(@RequestBody AppointmentsModel appointmentsModel) {
        if (appointmentService.isValidCreateAppointment(appointmentsModel)) {
            return ApiResponse.success(true, "Success",
                    appointmentService.save(appointmentsModel));
        }

        return ApiResponse.error("No se puede crear la cita en este horario", "");
    }
}
