package com.portal.healthcare.repository;

import com.portal.healthcare.model.Admit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AdmitRepository extends JpaRepository<Admit,Integer> {
    @Query("SELECT e FROM Appointment e " +
            "WHERE FUNCTION('CONVERT', java.util.Date, e.admitDate) = :date and doctorId.id=:doctorId")
    List<Admit> findAllByDoctorIdAndDate(Integer doctorId, Date date);
}
