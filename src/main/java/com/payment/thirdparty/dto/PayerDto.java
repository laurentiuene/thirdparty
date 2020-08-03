package com.payment.thirdparty.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class PayerDto {

    @NotNull(message = "'firstName' must not be null!")
    @Size(min = 1, max = 30)
    private String firstName;

    @NotNull(message = "'lastName' must not be null!")
    @Size(min = 1, max = 30)
    private String lastName;

    @NotNull(message = "'cardNumber' must not be null!")
    @Size(min = 16, max = 16)
    private String cardNumber;

    @NotNull(message = "'cardExpiringDate' must not be null!")
    private LocalDate cardExpiringDate;

    @NotNull(message = "'cardCvv' must not be null!")
    @Size(min = 3, max = 3)
    private String cardCvv;

    @NotNull(message = "'orderValue' must not be null!")
    private Float orderValue;
}
