package com.studentapp.service;

import com.studentapp.customException.ApplicationNotFound;
import com.studentapp.entity.Application;
import com.studentapp.entity.User;
import com.studentapp.helper.AuthHelper;
import com.studentapp.model.ApplicationDto;
import com.studentapp.repository.ApplicationRepository;
import com.studentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    AuthHelper authHelper;

    public Application createApplication(ApplicationDto applicationDto) throws Exception {
        Application application = new Application();
        application.setStudentName(applicationDto.getStudentName());
        application.setUniversityName(applicationDto.getUniversityName());
        application.setUniversityCourse(applicationDto.getUniversityCourse());
        application.setUser(authHelper.getLogdinUser());
        return applicationRepository.save(application);
    }

    public List<Application> getApplicationList() throws Exception {
        try {
            User logdinUser = authHelper.getLogdinUser();
            return applicationRepository.findAllByUserId(logdinUser.getUserId());
        }catch (Exception e){
            throw new RuntimeException();
        }

    }

    public Application getApplicationById(Integer id) throws Exception{
        Optional<Application> applicationOpt = applicationRepository.findById(id);
        if (applicationOpt.isPresent()){
            return applicationOpt.get();
        }else {
            throw new ApplicationNotFound(String.format("Application Not Found For Id %s",id));
        }
    }
}
