package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Department;
import com.portal.healthcare.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService extends CrudService<Department> {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getByHospital(Integer id) {
        return departmentRepository.findAllByHospitalId(id);
    }
}
