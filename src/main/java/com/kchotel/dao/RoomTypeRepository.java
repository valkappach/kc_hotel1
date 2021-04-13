package com.kchotel.dao;

import com.kchotel.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}