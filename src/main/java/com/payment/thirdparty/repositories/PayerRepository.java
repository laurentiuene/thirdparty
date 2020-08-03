package com.payment.thirdparty.repositories;

import com.payment.thirdparty.models.Payer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayerRepository extends JpaRepository<Payer, Integer> {
    Payer findByCardNumber(String cardNumber);
}
