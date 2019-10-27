package com.zi.sbprojects.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.zi.sbprojects.model.Shipment;

@RunWith(SpringRunner.class)
@WebMvcTest(ControllerShipments.class)
public class ControllerShipmentTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ControllerShipments controllerShipments;
	
	@Test
	public void getAllShipmentsTest() throws Exception {
		Shipment shipment = new Shipment("395894854","Otto","Max Mustermann","Berlin");
		
		List<Shipment> allShipments = new ArrayList<>(Arrays.asList(shipment));

		given(controllerShipments.getAllShipments()).willReturn(allShipments);
		
		mockMvc.perform(get("/shipments"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].shipmentId", is(shipment.getShipmentId())));
		
		mockMvc.perform(get("/shipments"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].city", is(shipment.getCity())));
	}
	
}
