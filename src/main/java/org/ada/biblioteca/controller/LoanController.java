package org.ada.biblioteca.controller;

import lombok.RequiredArgsConstructor;
import org.ada.biblioteca.bo.postgres.LoanPostgres;
import org.ada.biblioteca.service.loan.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {
    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanPostgres> createLoan(@RequestBody LoanPostgres loan) {
        System.out.println(loan);
        LoanPostgres loanPostgres = loanService.createLoan(loan);
        System.out.println(loanPostgres);
        return new ResponseEntity<>(loanPostgres, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LoanPostgres>> getAllLoans() {
        List<LoanPostgres> loanPostgres = loanService.getLoans();
        return new ResponseEntity<>(loanPostgres, HttpStatus.OK);
    }
}
