package com.portal.healthcare.controller;

import com.portal.healthcare.config.JwtUtil;
import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Appointment;
import com.portal.healthcare.model.AppointmentsDTO;
import com.portal.healthcare.model.UserInfo;
import com.portal.healthcare.repository.UserInfoRepository;
import com.portal.healthcare.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("userInfo")
public class UserInfoController implements CrudController<UserInfo> {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return userInfoService.getById(userInfoRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return userInfoService.getAll(userInfoRepository);
    }

    @Override
    public ResponseEntity<?> save(UserInfo obj) {
        return userInfoService.save(userInfoRepository, obj);
    }

    @Override
    public ResponseEntity<?> update(UserInfo obj) {
        return userInfoService.update(userInfoRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return userInfoService.delete(userInfoRepository,id);
    }
    @GetMapping("/get")
    public ResponseEntity<UserInfo> getByUser(@RequestHeader("Authorization") String token){

        String username = JwtUtil.extractDoctorIdFromToken(token);
        UserInfo userInfo = userInfoService.getByUserInfo(username);
        return ResponseEntity.ok(userInfo);
    }
    @PutMapping("/edit/{id}")
    public UserInfo updateUserInfo(@PathVariable("id") int userInfoId,
                                   @RequestParam("address") String address,
                                   @RequestParam("age") int age,
                                   @RequestParam("fatherName") String fatherName) {
        return userInfoService.updateUserInfoDetails(userInfoId, address, age, fatherName);
    }

}
