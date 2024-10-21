package org.ada.biblioteca.service.loan;

import org.ada.biblioteca.bo.postgres.LoanPostgres;

import java.util.List;

public interface LoanService {
    LoanPostgres createLoan(LoanPostgres loan);
    List<LoanPostgres> getLoans();
}
