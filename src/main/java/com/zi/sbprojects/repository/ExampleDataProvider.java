package com.zi.sbprojects.repository;

import com.zi.sbprojects.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
//import java.util.UUID;

public class ExampleDataProvider implements ApplicationRunner {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //shipmentRepository.save(new Shipment(UUID.randomUUID().toString(),"Bon Prix","Zi Sang", "Hamurg"));
        shipmentRepository.save(new Shipment("39483498347384a","Bon Prix","Zi Sang", "Hamurg"));
    }
}
