/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created by Aziz SM on 1/13/19 12:49 AM.
 * Copyright (c) 2019.  All rights reserved.
 *
 */

package my.app.transreport.graphql;

import my.app.transreport.model.Account;
import my.app.transreport.model.Transaction;
import my.app.transreport.exception.TransactionNotFoundException;
import my.app.transreport.repository.TransactionRepository;
import my.app.transreport.util.transaction.CreateTransactionInput;
import my.app.transreport.util.transaction.UpdateTransactionInput;
import my.app.transreport.model.Remark;
import my.app.transreport.repository.RemarkRepository;
import my.app.transreport.util.remark.CreateRemarkInput;
import my.app.transreport.util.account.CreateAccountInput;
import my.app.transreport.exception.AccountNotFoundException;
import my.app.transreport.repository.AccountRepository;
import my.app.transreport.util.account.UpdateAccountInput;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class MutationResolver implements GraphQLMutationResolver {
    private TransactionRepository transactionRepository;
    private RemarkRepository remarkRepository;
    private AccountRepository accountRepository;

    /**
     * Mutation resolcver for createTransaction
     * @param input
     * @return
     */
    @Transactional
    public Transaction createTransaction(CreateTransactionInput input) {
        return transactionRepository.saveAndFlush(new Transaction(null, input.getTrxdate(), input.getAmount(), input.getAccntId()));
    }

    /**
     * Mutation resolcver for Update Transaction
     * @param input
     * @return
     */
    @Transactional
    public Transaction updateTransaction(UpdateTransactionInput input) {
        Transaction transaction = transactionRepository
            .findById(input.getId())
            .orElseThrow(() -> new TransactionNotFoundException(input.getId()));
        transaction.setAmount(input.getAmount());
        transaction.setTrxdate(input.getTrxdate());
        return transaction;
    }

    /**
     * Mutation resolcver for DeleteTransaction
     * @param id
     * @return
     */
    @Transactional
    public int deleteTransaction(Long id) {
        return transactionRepository.deleteById(id);
    }

    /**
     *  Mutation resolcver for Account
     * @param input
     * @return
     */
    @Transactional
    public Account createAccount(CreateAccountInput input) {
        return accountRepository.saveAndFlush(new Account(null, input.getAccountnum(), input.getAcctype()));
    }

    /**
     * Mutation resolcver for Account
     * @param input
     * @return
     */
    @Transactional
    public Account updateAccount(UpdateAccountInput input) {
        Account account = accountRepository
            .findById(input.getId())
            .orElseThrow(() -> new AccountNotFoundException(input.getId()));
        account.setAcctype(input.getAcctype());
        return account;
    }

    /**
     * Mutation resolcver for Account
     * @param id
     * @return
     */
    @Transactional
    public int deleteAccount(Long id) {
        return accountRepository.deleteById(id);
    }

    /**
     * Mutation resolcver for Remark
     * @param input
     * @return
     */
    @Transactional
    public Remark createRemark(CreateRemarkInput input) {
        return remarkRepository.saveAndFlush(new Remark(null, input.getText(), input.getTransactionId(), input.getAccntId()));
    }

    /**
     * Mutation resolcver for Remark
     * @param id
     * @return
     */
    @Transactional
    public int deleteRemark(Long id) {
        return remarkRepository.deleteById(id);
    }
}
