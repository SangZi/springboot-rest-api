package com.zi.sbprojects.controller;

import java.util.List;

import com.zi.sbprojects.repository.ExampleDataProvider;
import com.zi.sbprojects.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zi.sbprojects.model.Shipment;
import com.zi.sbprojects.service.ShipmentService;

/* In browser enter this url:
 * http://localhost:8080/shipments
 * JSON object should be shown.
 */

@RestController
public class ControllerShipments {
		
	//Dependency Injection, Spring creates an instance. Because Shipment service only have 1 constructor, we don't need to write @Autowired
	@Autowired
	private ShipmentService shipmentService;

	private final ShipmentRepository shipmentRepository;

	@Autowired
	public ControllerShipments(ShipmentRepository shipmentRepository){
		this.shipmentRepository = shipmentRepository;
	}

	/*Both ways are correct as annotation for HTTP-Request-Method
	 * @RequestMapping(method=RequestMethod.POST, value="/shipments")
	 */

	@PostMapping("/shipment")
	public void addShipment(@RequestBody Shipment shipment) {
		shipmentRepository.save(shipment);
	}

	@GetMapping("/shipments")
	public List<Shipment> getAllShipments(){
		return shipmentRepository.findAll();
	}

	@RequestMapping("/shipment/{shipmentId}")
	public Shipment getShipmentByShipmentId(@PathVariable String shipmentId) {
		return shipmentRepository.findByShipmentId(shipmentId);
	}

	/* To Do

	//Find an existing item object by shipmentId, and than replace it with new shipment object. 
	@RequestMapping(method=RequestMethod.PUT, value="/shipments/{shipmentId}")
	public void updateShipment(@RequestBody Shipment shipment, @PathVariable String shipmentId) {
		shipmentService.updateShipment(shipment,shipmentId);
	}
	
	//@RequestMapping(method=RequestMethod.DELETE, value="/shipments/{shipmentId}")
	@DeleteMapping("/shipments/{shipmentId}")
	public void deleteShipment(@PathVariable String shipmentId) {
		shipmentService.deleteShipment(shipmentId);
	}

	 */
}
	
	
