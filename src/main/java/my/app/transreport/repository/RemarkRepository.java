/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created by Aziz SM on 1/13/19 12:49 AM.
 * Copyright (c) 2019.  All rights reserved.
 *
 */

package my.app.transreport.repository;

import java.util.List;

import my.app.transreport.model.Remark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemarkRepository extends JpaRepository<Remark, Long> {
    List<Remark> findByTransactionId(Long transactionId);
    int deleteById(Long id);
}
