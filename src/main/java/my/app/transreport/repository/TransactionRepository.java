/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created by Aziz SM on 1/13/19 12:49 AM.
 * Copyright (c) 2019.  All rights reserved.
 *
 */

package my.app.transreport.repository;

import java.util.Optional;

import my.app.transreport.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findById(Long id);
    int deleteById(Long id);
}
