package lt.vu.transactions;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.transaction.TransactionSynchronizationRegistry;
import lombok.Getter;

import jakarta.transaction.Transactional;

@Named
@RequestScoped
@Transactional
public class TAntrasisKomponentas {

    @Resource
    private TransactionSynchronizationRegistry tx;

    @Getter
    private String transactionId; // For storing the transaction ID

    public void vykdytiTransakcija() {
        System.out.println("Antrasis komponentas, transakcijos ID: " + tx.getTransactionKey());
    }
}
