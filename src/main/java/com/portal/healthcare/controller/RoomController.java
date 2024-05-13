package com.portal.healthcare.controller;

import com.portal.healthcare.interfaces.CrudController;
import com.portal.healthcare.model.Room;
import com.portal.healthcare.repository.RoomRepository;
import com.portal.healthcare.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController implements CrudController<Room> {
    @Autowired
    RoomService roomService;
    @Autowired
    RoomRepository roomRepository;
    @Override
    public ResponseEntity<?> getById(Integer id) {
        return roomService.getById(roomRepository,id);
    }

    @Override
    public ResponseEntity<?> getAll() {
        return roomService.getAll(roomRepository);
    }

    @Override
    public ResponseEntity<?> save(Room obj) {
        return roomService.save(roomRepository,obj);
    }

    @Override
    public ResponseEntity<?> update(Room obj) {
        return roomService.update(roomRepository,obj);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return roomService.delete(roomRepository,id);
    }

    @GetMapping("byDepartment/{id}")
    public ResponseEntity<List<Room>> getByDepartment(@PathVariable("id") Integer id){
    return roomService.getByDepartment(id);
    }
    @GetMapping("/byName/{name}")
    public ResponseEntity<List<Room>> getByName(@PathVariable("name") String name){
        return  roomService.getByName(name);
    }



}
