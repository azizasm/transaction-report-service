

# Sample App - Transaction Report Inquiry Services

Implementation using Spring framework  includes following features :

1. HTTP Basic Authentication
1. Pagination -Offset based pagination pattern
1. JSON response based on client side field request GraphQL

###### Documentation
[Class  Diagram and sequence diagram for Transaction Report Inquiry Services](docs/README.md)

### Run in local environments 
```
$ git clone https://github.com/azizasm/transaction-report-service.git
$ mvn clean package
$ java -jar target/transaction-report-services-0.0.1-SNAPSHOT.jar
```
Open http://localhost:8080/graphiql 

### Run as Dockers images

1. Automated run <http://play-with-docker.com/?stack=https://raw.githubusercontent.com/azizasm/transaction-report-service/master/docker-compose.yml>

2. Or manual run :  
```
$ docker run -p 8080:8080 -t azizasm/image-trs:part1
```


User name/pass : user/pass


Sample GraphQL query : 

```

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
