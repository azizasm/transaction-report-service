
=========

## Sample App - Transaction report inquiry service

Implementation uisng Spring framework  includes following features :

1. HTTP Basic Autentication
1. Pagination -Offset based pagination pattern
1. JSON response based on client side field request GraphQL


http://localhost:8080/graphiql
User name/pass : user/pass



```json

query AllAccounts {
  accounts {
    id
    accountnum
    acctype
  }
}


query allLinks {
  allLinks(skip: 1, first: 10) {
    accountnum
    acctype
  }
}


query AllTransactions {
  transactions {
    id
    trxdate
    amount
    accnt {
      id
      accountnum
      acctype
    }
  }
}




query AllRemarks {
  remarks {
    id
    text
    
    accnt {
      id
      accountnum
      acctype
    }
  }
}


query Transaction($transactionId: Int!) {
  transaction(id: $transactionId) {
    id
    trxdate
    amount
    accnt {
      id
      accountnum
      acctype
    }
    remarks {
      id
      text
    }
  }
}


{"transactionId":  2}
```
