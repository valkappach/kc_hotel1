package com.kchotel.dao;

import com.kchotel.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface RoomRepository extends JpaRepository<Room, Long> {
    @RestResource(path = "/selectedRooms")
    public List<Room> findBySelectedIsTrue();

    @RestResource(path = "/roomsByKeyword")
    public List<Room> findByBedContains(@Param("mc") String mc);

    @RestResource(path = "/promoRooms")
    public List<Room> findByPromotionIsTrue();

    @RestResource(path = "/dispoRooms")
    public List<Room> findByAvailableIsTrue();

    @RestResource(path = "/bed")
    //Page<Room> findByBed(String bed,Pageable pageable);
    public List<Room> findByBed(String bed);

    @RestResource(path = "/roomNumber;")
    //Page<Book> findByRoom_number;(String room_number;,Pageable pageable);
    public List<Room> findByRoomNumber(String roomNumber);

    @RestResource(path = "/availablePage")
    Page<Room> findByAvailable(Boolean available, Pageable pageable);

}
