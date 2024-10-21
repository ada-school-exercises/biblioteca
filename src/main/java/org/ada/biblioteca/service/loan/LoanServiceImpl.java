package org.ada.biblioteca.service.loan;

import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.postgres.LoanPostgres;
import org.ada.biblioteca.bo.postgres.LoanPostgresId;
import org.ada.biblioteca.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    @Override
    public LoanPostgres createLoan(LoanPostgres loan) {
        LoanPostgresId id = new LoanPostgresId();
        id.setIdAuthor(loan.getIdLoan().getIdAuthor());
        id.setIdBook(loan.getIdLoan().getIdBook());
        LoanPostgres loanPostgres = new LoanPostgres();
        loanPostgres.setIdLoan(id);
        loanPostgres.setLoanDate(loan.getLoanDate());
        loanPostgres.setReturnDate(loan.getReturnDate());
        return loanRepository.save(loanPostgres);
    }

    @Override
    public List<LoanPostgres> getLoans() {
        return loanRepository.findAll();
    }
}
