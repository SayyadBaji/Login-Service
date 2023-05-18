package com.ums.login.repository;

import com.ums.login.model.LoginId;
import com.ums.login.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserLogin, Long> {
    UserLogin findByLoginId(LoginId loginId);
    /*UserLogin findByUsername(String username);*/
    @Query(value = "SELECT COUNT(*) FROM LOGIN.USER_LOGIN WHERE USER_NAME LIKE :usernameSuffix% AND USER_TYPE = :userType", nativeQuery = true)
    Integer getCount(@Param("usernameSuffix") String usernameSuffix, @Param("userType") String userType);
}
