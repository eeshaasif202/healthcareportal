package com.portal.healthcare.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CrudController<U>{
    @GetMapping( "/{id}")
    ResponseEntity<?> getById(@PathVariable("id") Integer id);

    @GetMapping( )
    default ResponseEntity<?> getAll(){return ResponseEntity.ok("Need to be Implemented");}

    @PostMapping()
    ResponseEntity<?> save(@RequestBody U obj);

    @PutMapping()
    default ResponseEntity<?> update(@RequestBody U obj){
        return ResponseEntity.ok("Need to be Implemented");
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Integer id);

}
