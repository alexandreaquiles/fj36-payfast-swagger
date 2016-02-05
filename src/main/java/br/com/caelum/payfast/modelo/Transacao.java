package br.com.caelum.payfast.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transacao {

	private String codigo;
	private String titular;
	private LocalDate data;
	private BigDecimal valor;

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTitular() {
		return titular;
	}

	public LocalDate getData() {
		return data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Transacao [codigo=" + codigo + ", titular=" + titular + ", data=" + data + ", valor=" + valor + "]";
	}

}
