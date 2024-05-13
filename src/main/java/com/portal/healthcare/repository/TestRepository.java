package com.portal.healthcare.repository;

import com.portal.healthcare.model.Observation;
import com.portal.healthcare.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {
    List<Test> findByPatientId(int patientId);
}
