package com.zi.sbprojects.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zi.sbprojects.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zi.sbprojects.model.Shipment;

/*
 * This is a Spring Business Service
 */

@Service
public class ShipmentService {

	/*
	Shipment myShipment1 = new Shipment("395894854","Otto","Max Mustermann","Berlin");
	Shipment myShipment2 = new Shipment("498543976","Bon Prix","Zi Sang","Hamburg");
	Shipment myShipment3 = new Shipment("34959486","HM","Thomas Müller","München");
	*/

	private ShipmentRepository shipmentRepository;

	@Autowired
	public ShipmentService(ShipmentRepository shipmentRepository) {
		this.shipmentRepository = shipmentRepository;
	}

	private List<Shipment> shipmentList = new ArrayList<>();

	/* The following is wrong, because this shipmentList is not mutable, no extra shipment can be added to it.
	private List<Shipment> shipmentList = Arrays.asList(myShipment1,myShipment2,myShipment3);
    */

	public List<Shipment> getAllShipments(){
		return shipmentRepository.findAll();
	}
	
	public Shipment getShipmentByShipmentId(String shipmentId) {
		return shipmentList.stream()
				.filter(i -> i.getShipmentId().equals(shipmentId))
				.findFirst()
				.get();
	}
	
	public void addShipment(Shipment shipment) {
		shipmentRepository.save(shipment);
	}

	public void updateShipment(Shipment newShipment, String shipmentId) {
		for(Shipment oldShipment : shipmentList) {
			if (oldShipment.getShipmentId().equals(newShipment.getShipmentId())) {
				shipmentList.set(shipmentList.indexOf(oldShipment),newShipment);
			}
		}
	}
	
	public void deleteShipment(String shipmentId) {
		for(Shipment myShipment : shipmentList) {
			if (myShipment.getShipmentId().equals(shipmentId)) {
				shipmentList.remove(shipmentList.indexOf(myShipment));
			}
		}
	}
		
}


