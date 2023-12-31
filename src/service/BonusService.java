package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Esse funcionário não pode receber bônus devido ao seu salário");
		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
