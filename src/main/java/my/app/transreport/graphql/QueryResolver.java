/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created by Aziz SM on 1/13/19 12:49 AM.
 * Copyright (c) 2019.  All rights reserved.
 *
 */

package my.app.transreport.graphql;

import java.util.List;

import my.app.transreport.model.Account;
import my.app.transreport.model.Transaction;
import my.app.transreport.repository.TransactionRepository;
import my.app.transreport.model.Remark;
import my.app.transreport.repository.RemarkRepository;
import my.app.transreport.repository.AccountRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class QueryResolver implements GraphQLQueryResolver {
    private TransactionRepository transactionRepository;
    private RemarkRepository remarkRepository;
    private AccountRepository accountRepository;

    /**
     * To set pagination to PageRequest
     * @param skip
     * @param first
     * @return Pageable createPageRequest
     */
    private Pageable createPageRequest(Number skip, Number first) {
        return new PageRequest(skip.intValue(), first.intValue());
    }

    /**
     * Getter for Transactions
     * @return List<Transaction>
     */
    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public List<Remark> getRemarks() {
        return remarkRepository.findAll();
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> getAllLinks() {
        return accountRepository.findAll();
    }



    /**
     * Offset based pagination pattern
     * @param skip
     * @param first
     * @return Page<Account>
     */
    public Page<Account> allLinks(Number skip, Number first) {
        Pageable pageRequest = createPageRequest(skip,first);
        return accountRepository.findAll(pageRequest);
    }

    /**
     * transaction getter
     * @param id
     * @return  Transaction getTransaction
     */
    public Transaction getTransaction(Long id) {
        return transactionRepository.findOne(id);
    }
}
