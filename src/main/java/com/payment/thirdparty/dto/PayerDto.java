package com.payment.thirdparty.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class PayerDto {

    @NotNull
    @Size(min = 1, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 30)
    private String lastName;

    @NotNull
    @Size(min = 16, max = 16)
    private String cardNumber;

    @NotNull
    private LocalDate cardExpiringDate;

    @NotNull
    @Size(min = 3, max = 3)
    private String cardCvv;

    @NotNull
    private Float orderValue;
}
