package com.portal.healthcare.repository;

import com.portal.healthcare.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    @Query("select dep from Department dep where dep.id=:id")
    List<Department> findAllByHospitalId(Integer id);
}
