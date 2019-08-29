package com.zi.sbprojects.model;

public class Shipment {

	private String shipmentId;
	private String atgName;
	private String receiverName;
	private String city;
	
	public Shipment() {
		/*
		 * Default Constructor, empty on purpose
		 */
	}
	
	public Shipment(String shipmentId, String atgName, String receiverName, String city) {
		this.shipmentId = shipmentId;
		this.atgName = atgName;
		this.receiverName = receiverName;
		this.city = city;
	}
    
	public String getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getAtgName() {
		return atgName;
	}

	public void setAtgName(String atgName) {
		this.atgName = atgName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
