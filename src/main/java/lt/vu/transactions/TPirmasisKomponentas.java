package lt.vu.transactions;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import jakarta.inject.Named;
import jakarta.transaction.TransactionSynchronizationRegistry;

@Named
@RequestScoped
public class TPirmasisKomponentas {

    @Inject
    private TAntrasisKomponentas antrasis;

    @Resource
    private TransactionSynchronizationRegistry tx;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void vykdytiTransakcija() {
        antrasis.vykdytiTransakcija();
        System.out.println("Pirmasis komponentas, transakcijos ID: " + tx.getTransactionKey());
    }

}
