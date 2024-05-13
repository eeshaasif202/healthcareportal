package com.portal.healthcare.service;

import com.portal.healthcare.interfaces.CrudService;
import com.portal.healthcare.model.Room;
import com.portal.healthcare.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService extends CrudService<Room> {
    @Autowired
    RoomRepository roomRepository;

    public ResponseEntity<List<Room>> getByDepartment(Integer id) {
    return ResponseEntity.ok(roomRepository.findAllByDepartmentId(id));
    }


    public ResponseEntity<List<Room>> getByName(String name) {
        return ResponseEntity.ok(roomRepository.findAllByName(name));
    }
}
