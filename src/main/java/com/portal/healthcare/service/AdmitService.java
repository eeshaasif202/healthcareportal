package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Admit;
import com.portal.healthcare.repository.AdmitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdmitService extends CrudService<Admit> {
    @Autowired
    AdmitRepository admitRepository;

    public List<Admit> getAllByDoctorIdAndDate(Integer doctorId, Date date) {
        return admitRepository.findAllByDoctorIdAndDate(doctorId,date);
    }
}
