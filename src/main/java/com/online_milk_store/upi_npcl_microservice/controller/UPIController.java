package com.online_milk_store.upi_npcl_microservice.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online_milk_store.upi_npcl_microservice.bean.UpiPaymentInfoBean;
import com.online_milk_store.upi_npcl_microservice.service.UPIService;

@RestController
@RequestMapping(path = "/upi")
public class UPIController {
	final static private Logger LOGGER = LogManager.getLogger(UPIController.class);

	@Autowired
	private UPIService upiService;

	@PostMapping(path = "/payment-request")
	public ResponseEntity<Void> handlePaymentRequest(@RequestBody UpiPaymentInfoBean upiPaymentInfoBean) {
		LOGGER.debug("UPIController.handlePaymentRequest() --- START");
		LOGGER.info("UPIController.handlePaymentRequest() --- upiPaymentInfoBean: " + upiPaymentInfoBean);
		upiService.savePaymentRequest(upiPaymentInfoBean);
		LOGGER.debug("UPIController.handlePaymentRequest() --- END");
		return null;
	}
}
