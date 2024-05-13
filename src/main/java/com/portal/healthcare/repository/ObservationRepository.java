package com.portal.healthcare.repository;

import com.portal.healthcare.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservationRepository extends JpaRepository<Observation,Integer> {
    List<Observation> findByPatientId(int patientId);
}
