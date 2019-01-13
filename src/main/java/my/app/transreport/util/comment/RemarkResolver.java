/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created by Aziz SM on 1/13/19 12:49 AM.
 * Copyright (c) 2019.  All rights reserved.
 *
 */

package my.app.transreport.util.remark;

import my.app.transreport.model.Remark;
import my.app.transreport.model.Account;
import my.app.transreport.repository.AccountRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RemarkResolver implements GraphQLResolver<Remark> {
    private AccountRepository accountRepository;

    public Account getAccnt(Remark remark) {
        return accountRepository.findOne(remark.getAccntId());
    }
}
