package br.com.caelum.payfast.modelo;

import java.math.BigDecimal;

public class Pagamento {

	private static final String STATUS_CRIADO = "CRIADO";
	private static final String STATUS_CONFIRMADO = "CONFIRMADO";
	private static final String STATUS_CANCELADO = "CANCELADO";
	
	private Integer id;
	private String status;
	private BigDecimal valor;

	public void comStatusCriado() {
		if (this.id == null) {
			throw new IllegalArgumentException("id do pagamento deve existir");
		}

		this.status = STATUS_CRIADO;
	}

	public void comStatusConfirmado() {

		if (this.id == null) {
			throw new IllegalArgumentException("id do pagamento deve existir");
		}
		
		if(this.status == null || !this.status.equals(STATUS_CRIADO)) {
			throw new IllegalStateException("status deve ser " + STATUS_CRIADO);
		}

		this.status = STATUS_CONFIRMADO;
	}

	public void comStatusCancelado() {

		if (this.id == null) {
			throw new IllegalArgumentException("id do pagamento deve existir");
		}
		
		if(this.status == null || !this.status.equals(STATUS_CRIADO)) {
			throw new IllegalStateException("status deve ser " + STATUS_CRIADO);
		}

		this.status = STATUS_CANCELADO;
	}

	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Integer getId() {
		return id;
	}

	public boolean ehCriado() {
		return STATUS_CRIADO.equals(this.status);
	}
	
	public boolean ehConfirmado() {
		return STATUS_CONFIRMADO.equals(this.status);
	}
	
	public boolean ehCancelado() {
		return STATUS_CANCELADO.equals(this.status);
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", status=" + status + ", valor=" + valor + "]";
	}

}
