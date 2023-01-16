package com.example.LiveProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.LiveProject.Model.SignUpRequest;

@Repository
public interface SigninRepository extends JpaRepository<SignUpRequest,Long> {
    @Query("SELECT DISTINCT u FROM SignUpRequest u WHERE u.userName = :userName")
	SignUpRequest finduserName(
	  @Param("userName") String uname);
}
