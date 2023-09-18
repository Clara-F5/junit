package test;

import modelo.Desempenho;
import modelo.Funcionario;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import service.ReajusteService;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService service ;
    private  Funcionario funcionario;

    @Before
    public void inicializar(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Junior", LocalDate.now(),new BigDecimal("1000"));
    }
    @Test
    public void reajusteDeveSerTresPorcentoParaDesempenhoADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }
    @Test
    public void reajusteDeveSerQuinzePorcentoParaDesempenhoBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveSerVintePorcentoParaDesempenhoOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
