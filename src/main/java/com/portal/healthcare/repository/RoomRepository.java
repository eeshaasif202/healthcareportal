package com.portal.healthcare.repository;

import com.portal.healthcare.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    @Query ("select room from Room room where room.departmentId.id=:id ")
    List<Room> findAllByDepartmentId(Integer id);

    @Query("select room from Room room where room.name=:name")
    List<Room> findAllByName(String name);
}
