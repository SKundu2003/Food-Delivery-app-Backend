package com.UserInfoMicroservice.Repository;

import com.UserInfoMicroservice.Module.UserInfoModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoModule, Integer> {

    public UserInfoModule findByUserId(int userId);
}
