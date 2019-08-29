package com.zi.sbprojects.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* In browser enter this url:
 * http://localhost:8080/hellodenis
 * String "Hello Denis!" shoudl be shown
 */

@RestController
public class ControllerHelloWorld {

	@RequestMapping("/hellodenis")
	public String sayHelloWorld() {
		return "Hello Denis!";
	}
		
}
