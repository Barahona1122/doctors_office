package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.network.ApiResponse;
import com.example.demo.domain.network.ApiRoutes;
import com.example.demo.domain.objects.ApiResponseObject;
import com.example.demo.models.UsersModel;
import com.example.demo.services.UsersService;

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;

    /**
     * @return
     */
    @GetMapping()
    @RequestMapping(ApiRoutes.users)
    public ApiResponseObject findAll() {
        return ApiResponse.success(true, "Success", usersService.findAll());
    }

    /**
     * @param usersModel
     * @return
     */
    @RequestMapping(value = ApiRoutes.users + ApiRoutes.usersSave, method = RequestMethod.POST, produces = {
            MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
    public ApiResponseObject store(@RequestBody UsersModel usersModel) {
        return ApiResponse.success(true, "Success", usersService.save(usersModel));
    }


    
}
