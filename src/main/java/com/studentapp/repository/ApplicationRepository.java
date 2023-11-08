package com.studentapp.repository;

import com.studentapp.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    @Query(value = "select * from student.application where user_id =:userId",nativeQuery = true)
    List<Application> findAllByUserId(@Param("userId") Integer userId);
}
