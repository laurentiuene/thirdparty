package com.payment.thirdparty.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@Entity
public class Payer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payer")
    private Integer payerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_expiring_date")
    private LocalDate cardExpiringDate;

    @Column(name = "card_cvv")
    private String cardCvv;

    @Column(name = "account_balance")
    private Float accountBalance;
}
