package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Observation;
import com.portal.healthcare.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservationService extends CrudService<Observation> {
    @Autowired
    ObservationRepository observationRepository;









}
