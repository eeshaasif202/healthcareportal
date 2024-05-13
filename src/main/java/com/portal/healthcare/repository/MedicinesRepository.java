package com.portal.healthcare.repository;

import com.portal.healthcare.model.Medicines;
import com.portal.healthcare.model.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinesRepository extends JpaRepository<Medicines,Integer> {
    List<Medicines> findAllByPatientId(int patientId);
}
