package org.ada.biblioteca.util.caster;

import org.ada.biblioteca.bo.Loan;
import org.ada.biblioteca.bo.mongo.LoanMongo;
import org.ada.biblioteca.bo.mongo.LoanMongoId;
import org.ada.biblioteca.bo.postgres.LoanPostgres;
import org.ada.biblioteca.bo.postgres.LoanPostgresId;
import org.springframework.stereotype.Component;

@Component
public class LoanCaster {
    public LoanPostgres loanToLoanPostgres(Loan loan) {
        LoanPostgres loanPostgres = new LoanPostgres();
        LoanPostgresId loanPostgresId = new LoanPostgresId();
        loanPostgresId.setIdUser((loan.getIdUser() != null && !loan.getIdUser().isEmpty()) ? Long.parseLong(loan.getIdUser()) : null);
        loanPostgresId.setIdBook((loan.getIdBook() != null && !loan.getIdBook().isEmpty()) ? Long.parseLong(loan.getIdBook()) : null);
        loanPostgres.setIdLoan(loanPostgresId);
        loanPostgres.setLoanDate(loan.getLoanDate());
        loanPostgres.setReturnDate(loan.getReturnDate());
        return loanPostgres;
    }

    public Loan loanPostgresToLoan(LoanPostgres loanPostgres) {
        Loan loan = new Loan();
        loan.setIdUser(String.valueOf(loanPostgres.getIdLoan().getIdUser()));
        loan.setIdBook(String.valueOf(loanPostgres.getIdLoan().getIdBook()));
        loan.setLoanDate(loanPostgres.getLoanDate());
        loan.setReturnDate(loanPostgres.getReturnDate());
        return loan;
    }

    public LoanMongo loanToLoanMongo(Loan loan){
        LoanMongo loanMongo = new LoanMongo();
        LoanMongoId loanMongoId = new LoanMongoId();
        loanMongoId.setIdBook(loan.getIdBook());
        loanMongoId.setIdUser(loan.getIdUser());
        loanMongo.setIdLoan(loanMongoId);
        loanMongo.setLoanDate(loan.getLoanDate());
        loanMongo.setReturnDate(loan.getReturnDate());
        return loanMongo;
    }

    public Loan loanMongoToLoan(LoanMongo loanMongo){
        Loan loan = new Loan();
        loan.setIdUser(loanMongo.getIdLoan().getIdUser());
        loan.setIdBook(loanMongo.getIdLoan().getIdBook());
        loan.setLoanDate(loanMongo.getLoanDate());
        loan.setReturnDate(loanMongo.getReturnDate());
        return loan;
    }
}
