package com.payment.thirdparty.services;

import com.payment.thirdparty.dto.PayerDto;
import com.payment.thirdparty.dto.PaymentStatus;
import com.payment.thirdparty.models.Payer;
import com.payment.thirdparty.repositories.PayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayerService {

    @Autowired
    private PayerRepository payerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PayerDto mapPayerToPayerDto(Payer payer){
        return modelMapper.map(payer, PayerDto.class);
    }

    public boolean isPayerValid(PayerDto payerDto){
        Payer payer = payerRepository.findByCardNumber(payerDto.getCardNumber());
        return payer.getFirstName().equals(payerDto.getFirstName()) &&
                payer.getLastName().equals(payerDto.getLastName()) &&
                payer.getCardNumber().equals(payerDto.getCardNumber()) &&
                payer.getCardExpiringDate().equals(payerDto.getCardExpiringDate()) &&
                payer.getCardCvv().equals(payerDto.getCardCvv());
    }
    public boolean hasEnoughBalance(PayerDto payerDto){
        Payer payer = payerRepository.findByCardNumber(payerDto.getCardNumber());
        return payer.getAccountBalance() > payerDto.getOrderValue();
    }

    public PaymentStatus paymentStatus(PayerDto payerDto){

        if (!isPayerValid(payerDto)) {
            return PaymentStatus.FAILED;
        }
        if(!hasEnoughBalance(payerDto)){
            return PaymentStatus.NOT_ENOUGH_BALANCE;
        }
        return PaymentStatus.SUCCESS;
    }
}
