package com.portal.healthcare.repository;

import com.portal.healthcare.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findByUserId_Id(int id);
}
