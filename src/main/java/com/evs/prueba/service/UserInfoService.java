package com.evs.prueba.service;

import com.evs.prueba.entity.UserInfo;
import com.evs.prueba.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = repository.findByEmail(username);
        if (userInfo.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontado con el email: " + username);
        }

        UserInfo user = userInfo.get();
        return User.builder().username(user.getEmail()).password(user.getPassword()).authorities(user.getRoles()).build();
    }

    public String addUser(UserInfo userInfo) {
        Optional<UserInfo> exist = repository.findByEmailAndRoles(userInfo.getEmail(),"ROLE_USER");
        if (exist.isEmpty()) {
            userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
            userInfo.setRoles("ROLE_USER");
            repository.save(userInfo);
            return "Usuario agregado correctamente";
        } else {
            return "Usuario existente";
        }
    }

    public String addAdmin(UserInfo userInfo) {
        Optional<UserInfo> exist = repository.findByEmailAndRoles(userInfo.getEmail(),"ROLE_ADMIN");
        if (exist.isEmpty()) {
            userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
            userInfo.setRoles("ROLE_ADMIN");
            repository.save(userInfo);
            return "Administrador agregado correctamente";
        } else {
            return "Administrador existente";
        }
    }


}
