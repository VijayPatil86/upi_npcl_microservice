package com.online_milk_store.upi_npcl_microservice.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "UPI_NPCL_TRANSACTIONS")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor @ToString
public class UpiPaymentInfoEntity {
	@Column(name = "TRANSACTION_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int upiNpclTransactionId;

	@Column(name = "UPI_ID")
	private String upiId;

	@Column(name = "AMOUNT")
	private float amount;

	@Column(name = "PAYER_TRANSACTION_ID")
	private int payerTransactionId;

	@Column(name = "PAYER_TRANSACTION_TIMESTAMP")
	private Timestamp payerTransactionTimestamp;
}
