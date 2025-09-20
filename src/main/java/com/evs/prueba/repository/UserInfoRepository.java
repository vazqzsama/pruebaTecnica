package com.evs.prueba.repository;

import com.evs.prueba.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {

    Optional<UserInfo> findByEmail(String email);
    Optional<UserInfo> findByEmailAndRoles(String email, String role);

}
