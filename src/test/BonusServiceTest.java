package test;

import modelo.Funcionario;
import service.BonusService;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class BonusServiceTest {

    @Test
    public void bonusDeveSerZeroParaFuncionariosComSalarioAlto(){
        BonusService service = new BonusService();
//        assertThrows(IllegalArgumentException.class,()-> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),new BigDecimal("12000"))));
        try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),new BigDecimal("12000")));
            fail("Não deu a exception!");
        }catch (Exception e){
                assertEquals("Esse funcionário não pode receber bônus devido ao seu salário",e.getMessage() );
        }
    }
    @Test
    public void bonusDeveSerDezPorcentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"),bonus);
    }
    @Test
    public void bonusDeveSerDezPorcentoParaOValorLimite(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"),bonus);
    }
}
