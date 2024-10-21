package org.ada.biblioteca.bo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Loan {
    private String idUser;
    private String idBook;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;
}
