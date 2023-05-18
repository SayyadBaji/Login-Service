package com.ums.login.model;

import com.ums.login.dto.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USER_LOGIN")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/
    //private String username;
    @EmbeddedId
    private LoginId loginId;
    private String password;
    //private String userType;
    private Integer wrongLoginAttempts;
    private Boolean isNowLoggedIn;
    private Boolean isAccountLocked;
}
