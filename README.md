# JDBC
## Demonstração de transação com JDBC

**Transação** é uma operação que deve manter a consistência do banco de dados.  

Ela deve possuir 4 propriedades:
* Atomicity(Atômica) -> ou acontece tudo, ou não acontece nada;
* Consistency(Consistência);
* Isolation(Isolada);
* Durability(Durável)

### API:
* setAutoCommit(false)  
* commit()  
* rollback()  

**Referências:** https://www.ibm.com/support/knowledgecenter/en/SSGMCP_5.4.0/product-overview/acid.html
