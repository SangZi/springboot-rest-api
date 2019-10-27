package com.zi.sbprojects.repository;

import com.zi.sbprojects.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Component;

@Component()
@ConditionalOnMissingClass("org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager")
public class ExampleDataProvider implements ApplicationRunner {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        shipmentRepository.save(new Shipment("39483498347384a","Bon Prix","Zi Sang", "Hamurg"));
    }
}
