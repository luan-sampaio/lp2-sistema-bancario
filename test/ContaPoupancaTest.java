import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ContaPoupancaTest {
    private ContaPoupanca conta;
    private ContaPoupanca contaDestino;

    @BeforeEach
    void setUp() {
        conta = new ContaPoupanca(001, "Luan");
        contaDestino = new ContaPoupanca(002, "Yara");
    }

    @Test
    void testSaqueComSaldoSuficiente() {
        conta.depositar(300.0);
        boolean resultado = conta.sacar(150.0);
        
        assertTrue(resultado); 
        assertEquals(150.0, conta.getSaldo());
    }

    @Test
    void testTransferenciaBemSucedida() {
        conta.depositar(400.0);
        conta.transferir(100.0, contaDestino);
        
        assertEquals(300.0, conta.getSaldo());
        assertEquals(100.0, contaDestino.getSaldo()); 
    }
    
    @Test
    void testTransferenciaSemSaldoSuficiente() {
        conta.depositar(50.0);
        conta.transferir(100.0, contaDestino);
        
        assertEquals(50.0, conta.getSaldo());
        assertEquals(0.0, contaDestino.getSaldo()); 
    }
}
