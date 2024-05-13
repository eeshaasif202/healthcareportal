package com.portal.healthcare.repository;

import com.portal.healthcare.model.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptoms,Integer> {
    List<Symptoms> findAllByPatientId(int patientId);
}
