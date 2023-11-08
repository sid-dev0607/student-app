package com.studentapp.repository;

import com.studentapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from student  where signin.email_id =:emailId AND signin.password=:password" , nativeQuery = true)
    public Optional<User> findSignInByEmailId(String emailId, String password);

    boolean existsByEmailIdAndPassword(String emailId,String password);

    User findByEmailId(String emailId);
}
