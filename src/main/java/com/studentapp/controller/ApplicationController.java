package com.studentapp.controller;

import com.studentapp.customException.ApplicationNotFound;
import com.studentapp.entity.Application;
import com.studentapp.model.ApplicationDto;
import com.studentapp.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ApplicationController {

    Logger logger = LoggerFactory.getLogger(ApplicationController.class);
    @Autowired
    ApplicationService applicationService;

    @PostMapping("application/create")
    public ResponseEntity<Application> createApplication (@RequestBody ApplicationDto applicationDto){
        try {
            Application application = applicationService.createApplication(applicationDto);
            return new ResponseEntity<>(application,HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException("Invalid Input Exception !");
        }
    }

    @GetMapping("application/list")
    public ResponseEntity<List<Application>> getApplicationList() throws Exception{
        try {
            List<Application> applicationList = applicationService.getApplicationList();
            return new ResponseEntity<>(applicationList,HttpStatus.OK);
        }catch (Exception e){
            throw new ApplicationNotFound();
        }
    }

    @GetMapping("application/{applicationId}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("applicationId") Integer applicationId) throws Exception{
        try {
            Application application = applicationService.getApplicationById(applicationId);
            return new ResponseEntity<>(application,HttpStatus.OK);
        }catch (Exception e){
            logger.error("ApplicationNot Found ",e);
            throw new ApplicationNotFound(e.getMessage());
        }
    }
}
