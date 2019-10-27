package com.zi.sbprojects.repository;

import com.zi.sbprojects.model.Shipment;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ShipmentRepository extends CrudRepository<Shipment, String> {

    List<Shipment> findAll();

}
