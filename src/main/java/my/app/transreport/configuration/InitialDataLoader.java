/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created by Aziz SM on 1/13/19 12:49 AM.
 * Copyright (c) 2019.  All rights reserved.
 *
 */

package my.app.transreport.configuration;

import my.app.transreport.model.Transaction;
import my.app.transreport.repository.TransactionRepository;
import my.app.transreport.model.Remark;
import my.app.transreport.repository.RemarkRepository;
import my.app.transreport.model.Account;
import my.app.transreport.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class InitialDataLoader implements CommandLineRunner {
    private RemarkRepository remarkRepository;
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;

    /**
     * Intit loader with sample data
     * <p>
     *    To load account, trannsaction and remark entity
     * </p>
     * @param strings
     */
    @Override
    @Transactional
    public void run(String... strings) {
        Account accnt1 =  accountRepository.save(new Account(null, "564838406011", "WADIAH CURRENT AC"));
        Account accnt2 = accountRepository.save(new Account(null, "311140415000", "M2U SAVERS"));

        for (int i = 1; i <= 20 ; i++) {
            String padded = String.format("%03d" , i);
            Account user001 = accountRepository.save(new Account(null, "311140415" +  padded , "M2U SAVERS" ));
        }

        Transaction transaction1 = transactionRepository.save(new Transaction(null, "2019-01-01 13:01", 110.80, accnt1.getId()));
        Transaction transaction2 = transactionRepository.save(new Transaction(null, "2019-01-02 14:01", -201.00   ,  accnt2.getId()));

        remarkRepository.save(new Remark(null, "CDM DEPOSIT", transaction1.getId(), accnt1.getId()));
        remarkRepository.save(new Remark(null, "ATM WITHDRAWAL",         transaction2.getId(), accnt2.getId()));
        remarkRepository.save(new Remark(null,  "SERVICE CHG RM 1.00",    transaction2.getId(), accnt2.getId()));

    }
}
