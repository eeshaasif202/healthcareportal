package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.User;
import com.portal.healthcare.model.UserDTO;
import com.portal.healthcare.model.UserInfo;
import com.portal.healthcare.repository.UserRepository;
import com.portal.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController implements CrudController<User> {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid User user, @Param(value = "roleId") int roleId){
        return ResponseEntity.ok(userService.register(user, roleId));
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        return userService.getById(userRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return userService.getAll(userRepository);
    }

    @Override
    public ResponseEntity<?> save(User obj) {
        return userService.save(userRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(User obj) {
        return userService.update(userRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return userService.delete(userRepository,id);
    }
    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam("userName") String userName){

        return ResponseEntity.ok(userService.logOut(userName));
    }

    @GetMapping("/getPatients")
    public ResponseEntity<List<UserDTO>> getUsersWithRoleIdOne() {
        List<User> users = userRepository.findAllByRoleId_Id(3); // Patient roleId 3

        // Map User entities to UserDTO objects
        List<UserDTO> userDTOs = users.stream()
                .map(user -> new UserDTO(user.getId(), user.getName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(userDTOs);
    }
    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getCount() {
        List<User> doctorList = userRepository.findAllByRoleId_Id(2);
        List<User> patientList = userRepository.findAllByRoleId_Id(3); // Patient roleId 3

        long doctorCount = doctorList.size();
        long patientCount = patientList.size();

        Map<String, Long> countMap = new HashMap<>();
        countMap.put("doctor", doctorCount);
        countMap.put("patient", patientCount);

        return ResponseEntity.ok(countMap);
    }

}
