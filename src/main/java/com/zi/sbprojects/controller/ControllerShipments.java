package com.zi.sbprojects.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zi.sbprojects.model.Shipment;
import com.zi.sbprojects.service.ShipmentService;

/* In browser enter this url:
 * http://localhost:8080/shipments
 * JSON object should be shown
 */

@RestController
public class ControllerShipments {
		
	//Dependency Injection, Spring creates an instance
	@Autowired
	private ShipmentService shipmentService;
	
	//If Request Method not specified, default is GET
	@RequestMapping("/shipments")
	public List<Shipment> getAllShipments(){
		return shipmentService.getAllShipments();
	}
	
	@RequestMapping("/shipments/{shipmentId}")
	public Shipment getShipmentByShipmentId(@PathVariable String shipmentId) {
		return shipmentService.getShipmentByShipmentId(shipmentId);
	}

	@RequestMapping(method=RequestMethod.POST, value="/shipments")
	public void addShipment(@RequestBody Shipment shipment) {
		shipmentService.addShipment(shipment);
	}
	
	//Find an existing item object by shipmentId, and than replace it with new shipment object
	@RequestMapping(method=RequestMethod.PUT, value="/shipments/{shipmentId}")
	public void updateShipment(@RequestBody Shipment shipment, @PathVariable String shipmentId) {
		shipmentService.updateShipment(shipment,shipmentId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/shipments/{shipmentId}")
	public void deleteShipment(@PathVariable String shipmentId) {
		shipmentService.deleteShipment(shipmentId);
	}
	
}
	
	
