package com.kchotel.dao;

import com.kchotel.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource

public interface AddressRepository extends JpaRepository<Address,Long> {
}
