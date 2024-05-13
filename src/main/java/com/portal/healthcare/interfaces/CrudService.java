package com.portal.healthcare.interfaces;

import com.portal.healthcare.exceptions.CustomException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public abstract class CrudService<T> {
    public ResponseEntity<?> save(JpaRepository repository, T obj){
        try {
            repository.save(obj);
        }catch (DataIntegrityViolationException e){
            throw new CustomException("Data Already Exist",e.getMessage(), HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<?> update(JpaRepository repository, T obj){
        try {
            repository.save(obj);
        }catch (DataIntegrityViolationException e){
            throw new CustomException("Data Already Exist",e.getMessage(),HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(obj);
    }
    public ResponseEntity<?> delete(JpaRepository repository, Integer id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new CustomException("Id Not Available",e.getMessage(),HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Deleted");
    }
    public static ResponseEntity<?> getById(JpaRepository repository, Integer id){
        Object o=repository.findById(id);
        if (o!= Optional.empty())
            return ResponseEntity.ok(o);
        else {
            throw new CustomException("Item Not Found", "null", HttpStatus.NOT_FOUND);
        }
    }

    public static ResponseEntity<?> getAll(JpaRepository repository){
        return ResponseEntity.ok(repository.findAll());
    }



}
