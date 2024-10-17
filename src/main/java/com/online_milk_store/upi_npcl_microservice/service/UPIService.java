package com.online_milk_store.upi_npcl_microservice.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online_milk_store.upi_npcl_microservice.bean.UpiPaymentInfoBean;
import com.online_milk_store.upi_npcl_microservice.entity.UpiPaymentInfoEntity;
import com.online_milk_store.upi_npcl_microservice.repository.UPINPCLTransactionRepository;

@Service
@Transactional
public class UPIService {
	final static private Logger LOGGER = LogManager.getLogger(UPIService.class);

	private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

	@Autowired
	private UPINPCLTransactionRepository upinpclTransactionRepository;

	public void savePaymentRequest(UpiPaymentInfoBean upiPaymentInfoBean) {
		LOGGER.debug("UPIService.savePaymentRequest() --- START");
		LOGGER.info("UPIService.savePaymentRequest() --- upiPaymentInfoBean: " + upiPaymentInfoBean);
		UpiPaymentInfoEntity upiPaymentInfoEntityToSave = UpiPaymentInfoEntity.builder()
				.upiAddress(upiPaymentInfoBean.getUpiAddress())
				.amount(upiPaymentInfoBean.getAmount())
				.payerTransactionId(upiPaymentInfoBean.getPayerTransactionId())
				.payerTransactionTimestamp(Timestamp.valueOf(LocalDateTime.parse(upiPaymentInfoBean.getPayerTransactionTimestamp(), formatter)))
				.build();
		LOGGER.info("UPIService.savePaymentRequest() --- upiPaymentInfoEntityToSave: " + upiPaymentInfoEntityToSave);
		UpiPaymentInfoEntity upiPaymentInfoEntitySaved = upinpclTransactionRepository.save(upiPaymentInfoEntityToSave);
		LOGGER.info("UPIService.savePaymentRequest() --- upiPaymentInfoEntitySaved: " + upiPaymentInfoEntitySaved);
		LOGGER.debug("UPIService.savePaymentRequest() --- END");
	}
}
