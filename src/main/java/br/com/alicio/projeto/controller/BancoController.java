package br.com.alicio.projeto.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.alicio.projeto.dao.BancoDAO;
import br.com.alicio.projeto.model.Banco;


	@Path("bancos")
	public class BancoController {
	

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/")
		public List<Banco> listBanco() {
			try {
				BancoDAO BancoDAO = new BancoDAO();
				return BancoDAO.listar();
			} catch (Exception ex) {
				Logger.getLogger(BancoController.class.getName()).log(Level.SEVERE, null, ex);
				throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
			}
		}

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("{id}/")
		public Banco getBanco(@PathParam("id") int id) {
			try {
				BancoDAO BancoDAO = new BancoDAO();
				return BancoDAO.selecionar(id);
			} catch (Exception ex) {
				Logger.getLogger(BancoController.class.getName()).log(Level.SEVERE, null, ex);
				throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
			}
		}

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/")
		public Response create(Banco banco) {
			try {
				BancoDAO BancoDAO = new BancoDAO();
				BancoDAO.inserir(banco);

				return Response.status(Response.Status.CREATED).build();
			} catch (Exception ex) {
				Logger.getLogger(BancoController.class.getName()).log(Level.SEVERE, null, ex);
				throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
			}
		}

		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/")
		public Response update(Banco banco) {
			try {
		
				BancoDAO BancoDAO = new BancoDAO();
				BancoDAO.alterar(banco);
				return Response.status(Response.Status.NO_CONTENT).build();
			} catch (Exception ex) {
				Logger.getLogger(BancoController.class.getName()).log(Level.SEVERE, null, ex);
				throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
			}
		}

		@DELETE
		@Path("{id}/")
		public Response delete(@PathParam("id") long id) {
			try {
				BancoDAO BancoDAO = new BancoDAO();
				BancoDAO.excluir(id);
				return Response.status(Response.Status.OK).build();
			} catch (Exception ex) {
				Logger.getLogger(BancoController.class.getName()).log(Level.SEVERE, null, ex);
				throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
			}
		}

	/*	@PUT
		@Path("{id}/")
		public Response concluir(@PathParam("id") int id) {
			try {
				BancoDAO BancooDAO = new BancoDAO();

				Banco c = BancoDAO.selecionar(id);
				c.setStatus(Status.FECHADO);

				BancoDAO.alterar(c);
				return Response.status(Response.Status.ACCEPTED).build();
			} catch (Exception ex) {
				Logger.getLogger(BancoController.class.getName()).log(Level.SEVERE, null, ex);
				throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
			}*/
		}
	}

}
