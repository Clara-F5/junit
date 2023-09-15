package test;

import modelo.Desempenho;
import modelo.Funcionario;
import org.junit.Test;
import service.ReajusteService;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {
    @Test
    public void reajusteDeveSerTresPorcentoParaDesempenhoADesejar(){

        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Junior", LocalDate.now(),new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
    @Test
    public void reajusteDeveSerQuinzePorcentoParaDesempenhoBom(){

        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Junior", LocalDate.now(),new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerVintePorcentoParaDesempenhoOtimo(){

        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Junior", LocalDate.now(),new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
