package com.online_milk_store.upi_npcl_microservice.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class UpiPaymentInfoBean {
	private int upiNpclTransactionId;
	private String upiId;
	private float amount;
	private int payerTransactionId;
	private String payerTransactionTimestamp;
}
