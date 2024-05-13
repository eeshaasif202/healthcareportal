package com.portal.healthcare.repository;

import com.portal.healthcare.model.Prevention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreventionRepository extends JpaRepository<Prevention,Integer> {
    List<Prevention> findAllByPatientId(int patientId);
}
