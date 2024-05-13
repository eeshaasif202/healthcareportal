package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Department;
import com.portal.healthcare.repository.DepartmentRepository;
import com.portal.healthcare.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController implements CrudController<Department> {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return departmentService.getById(departmentRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return departmentService.getAll(departmentRepository);
    }

    @Override
    public ResponseEntity<?> save(Department obj) {
        return departmentService.save(departmentRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Department obj) {
        return departmentService.update(departmentRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return departmentService.delete(departmentRepository,id);
    }

    @GetMapping("byHospital/{id}")
    public ResponseEntity<List<Department>> getByHospitalId(@PathVariable("id") Integer id){
        return ResponseEntity.ok(departmentService.getByHospital(id));
    }


}
