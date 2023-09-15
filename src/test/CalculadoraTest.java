import org.junit.Test;
import org.junit.Assert;
public class CalculadoraTest {

    @Test
    public void deveSomarNumerosInteiros(){
        Calculadora calc = new Calculadora();
        int soma = calc.somar(2,3);
        Assert.assertEquals(5, soma);
    }
}
