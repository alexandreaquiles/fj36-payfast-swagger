package br.com.caelum.payfast.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.payfast.modelo.Pagamento;

@ApplicationScoped
public class RepositorioDePagamentos {
	private Map<Integer, Pagamento> repositorio = new HashMap<>();
	private Integer idPagamento = 1;
	
	public RepositorioDePagamentos() {
		Pagamento pagamento = new Pagamento();
		pagamento.setId(idPagamento++);
		pagamento.setValor(BigDecimal.TEN);
		pagamento.comStatusCriado();
		repositorio.put(pagamento.getId(), pagamento);
	}

	public Pagamento busca(Integer id) {
		return repositorio.get(id);
	}

	public void cria(Pagamento pagamento) {
		pagamento.setId(idPagamento++);
		repositorio.put(pagamento.getId(), pagamento);
	}


}
