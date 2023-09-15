package service;

import modelo.Funcionario;
import service.BonusService;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class BonusServiceTest {

    @Test
    public void bonusDeveSerZeroParaFuncionariosComSalarioAlto(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(),new BigDecimal("12000")));

        assertEquals(new BigDecimal("0.00"),bonus);
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
