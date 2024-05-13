package com.portal.healthcare.repository;

import com.portal.healthcare.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    @Query("select h from Hospital h where h.cityId.id =:cityId")
   List<Hospital> findByCityId(Integer cityId);
}
