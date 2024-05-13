package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.User;
import com.portal.healthcare.model.UserInfo;
import com.portal.healthcare.repository.UserInfoRepository;
import com.portal.healthcare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService extends CrudService<UserInfo> {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    UserRepository userRepository;

    public UserInfo getByUserInfo (String username){
        User user = userRepository.findByUsername(username);
        UserInfo userInfo = userInfoRepository.findByUserId_Id(user.getId());
        return userInfo;
    }
    public UserInfo updateUserInfoDetails(int userInfoId, String address, int age, String fatherName) {
        UserInfo userInfo = userInfoRepository.findById(userInfoId)
                .orElseThrow(() -> new RuntimeException("UserInfo not found with ID: " + userInfoId));

        // Update the fields
        userInfo.setAddress(address);
        userInfo.setAge(age);
        userInfo.setFatherName(fatherName);

        // Save the updated UserInfo
        return userInfoRepository.save(userInfo);
    }
}
