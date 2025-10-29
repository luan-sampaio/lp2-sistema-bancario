import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


class ContaCorrenteTest {
    private ContaCorrente conta;
    
    @BeforeEach // antes de cada teste
    void setUp() {
        conta = new ContaCorrente(001, "Joao");
    }

    @Test
    void testCriacaoContaCorrente() {
        assertNotNull(conta);
        assertEquals(001, conta.getId());
        assertEquals("Joao", conta.getNome());
        assertEquals(0.0, conta.getSaldo()); //saldo inicial = 0
    }

    @Test
    void testDepositoValorNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            conta.depositar(-100.0);
        });
    }

    @Test
    void testSaqueSemSaldoSuficiente() {
        conta.depositar(100.0);
        boolean resultado = conta.sacar(200.0);        
        assertFalse(resultado);
        assertEquals(100.0, conta.getSaldo());
    }

    @Test
    void testTransferenciaSemSaldoSuficiente() {
        ContaCorrente contaDestino = new ContaCorrente(002, "Maria");
        conta.depositar(100.0);
        conta.transferir (200, contaDestino);
        assertEquals(100.0, conta.getSaldo());
        assertEquals(0.0, contaDestino.getSaldo());
    }
}
