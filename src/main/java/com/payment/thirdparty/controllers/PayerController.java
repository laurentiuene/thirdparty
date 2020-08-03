package com.payment.thirdparty.controllers;

import com.payment.thirdparty.dto.PayerDto;
import com.payment.thirdparty.dto.ResponseStatus;
import com.payment.thirdparty.services.PayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/payment")
@Validated
public class PayerController {

    @Autowired
    private PayerService payerService;

    @PostMapping
    public ResponseStatus validatePayment(@RequestBody @Valid PayerDto payerDto) {
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setStatus(payerService.paymentStatus(payerDto));
        return responseStatus;
    }
}