/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created by Aziz SM on 1/13/19 12:49 AM.
 * Copyright (c) 2019.  All rights reserved.
 *
 */

package my.app.transreport.util.transaction;

import java.util.List;

import my.app.transreport.model.Account;
import my.app.transreport.model.Remark;
import my.app.transreport.repository.RemarkRepository;
import my.app.transreport.model.Transaction;
import my.app.transreport.repository.AccountRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionResolver implements GraphQLResolver<Transaction> {
    private RemarkRepository remarkRepository;
    private AccountRepository accountRepository;

    public Account getAccnt(Transaction transaction) {
        return accountRepository.findOne(transaction.getAccntId());
    }

    public List<Remark> getRemarks(Transaction transaction) {
        return remarkRepository.findByTransactionId(transaction.getId());
    }
}
