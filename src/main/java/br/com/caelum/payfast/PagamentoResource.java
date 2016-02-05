package br.com.caelum.payfast;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.caelum.payfast.modelo.Pagamento;
import br.com.caelum.payfast.modelo.Transacao;
import br.com.caelum.payfast.repository.RepositorioDePagamentos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@Api
@Path("/pagamentos")
public class PagamentoResource {

	@Inject
	private RepositorioDePagamentos repositorio;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pagamento buscaPagamento(@PathParam("id") Integer id) {
		return repositorio.busca(id);
	}

	@ApiOperation(
		value = "Cria novo pagamento", 
		consumes = MediaType.APPLICATION_JSON, 
		produces = MediaType.APPLICATION_JSON)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiResponses(
		@ApiResponse(
			code=201,
			message="Novo pagamento criado",
			response = Pagamento.class, 
			responseHeaders=
				@ResponseHeader(
					name="Location", 
					description="uri do novo pagamento",
					response=String.class)))
	public Response criarPagamento(
			@ApiParam(
				value="Transação", 
				name="transacao", 
				required=true)
			Transacao transacao) throws URISyntaxException {
		Pagamento pagamento = new Pagamento();
		pagamento.setValor(transacao.getValor());
		pagamento.comStatusCriado();
		repositorio.cria(pagamento);
		return Response.created(new URI("/pagamentos/" + pagamento.getId())).entity(pagamento)
				.type(MediaType.APPLICATION_JSON).build();
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response confirmarPagamento(@PathParam("id") Integer pagamentoId) {
		Pagamento pagamento = repositorio.busca(pagamentoId);
		pagamento.comStatusConfirmado();
		return Response.ok().entity(pagamento).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelarPagamento(@PathParam("id") Integer pagamentoId) {
		Pagamento pagamento = repositorio.busca(pagamentoId);
		pagamento.comStatusCancelado();
		return Response.ok().entity(pagamento).build();
	}

}
