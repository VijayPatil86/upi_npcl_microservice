package com.online_milk_store.upi_npcl_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online_milk_store.upi_npcl_microservice.entity.UpiPaymentInfoEntity;

public interface UPINPCLTransactionRepository extends JpaRepository<UpiPaymentInfoEntity, Integer> {

}
