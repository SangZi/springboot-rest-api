package com.zi.sbprojects.repository;

import com.zi.sbprojects.model.Shipment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Component;

@Component()
public class ExampleDataProvider implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(ExampleDataProvider.class);

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        shipmentRepository.save(new Shipment("98476950912a","Bon Prix","Zi Sang", "Hamburg"));
        shipmentRepository.save(new Shipment("98476950913","OTTO","Max Mustermann", "Berlin"));
        shipmentRepository.save(new Shipment("98476950914","H&M","Dennis Heinrich", "Hamburg"));
    }
}
