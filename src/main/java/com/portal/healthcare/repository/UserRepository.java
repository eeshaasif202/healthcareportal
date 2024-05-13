package com.portal.healthcare.repository;

import com.portal.healthcare.model.User;
import com.portal.healthcare.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    List<User> findAllByRoleId_Id(int roleId);
}
