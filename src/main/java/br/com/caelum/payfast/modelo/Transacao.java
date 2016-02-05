package br.com.caelum.payfast.modelo;

import java.math.BigDecimal;

public class Transacao {

	private String codigo;
	private String titular;
	private String data;
	private BigDecimal valor;

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setData(String data) {
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

	public String getData() {
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
