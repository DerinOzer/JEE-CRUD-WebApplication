package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/goodreads")
public class Service {
	private Repertoire dao = new Repertoire();
	
	@Path("/test")
	@GET 
	@Produces(MediaType.TEXT_PLAIN)
	public String testService()
	{	
		return "test";
	}
	
	@Path("/hello")
	@GET 
	@Produces(MediaType.TEXT_PLAIN)
	public String hello()
	{	
		return "Hello World ";
	}
	
	@Path("/livre/{id}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Livres getLivre(@PathParam("id") long id){
		return dao.readLivre(id);
	}
	
	@Path("/auteur/{id}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Auteurs getAuteur(@PathParam("id") long id){
		return dao.readAuteur(id);
	}
	
	@Path("/critique/{id}")
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Critiques getCritique(@PathParam("id") long id){
		return dao.readCritique(id);
	}
	
	
	// Return type problemi olabilir. İlerleyen adımlarda problem yaşarsam return Auteurs olarak değiştirilebilir.
	@Path("/newAuteur")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void createAuteur(Auteurs auteur) {
		dao.createAuteur(auteur);
	}
	
	@Path("/newCritique")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void createCritique(Critiques critique) {
		dao.createCritique(critique);
		List<Critiques> critiques = dao.ListAllCritiques();
		double somme = 0;
		int counter = 0;
		for (Critiques c:critiques) {
			if(c.getLivre().getIdLivre() == critique.getLivre().getIdLivre()) {
				somme = somme + c.getNote();
				counter = counter + 1;
			}	
		}
		Livres livreUpdated = dao.readLivre(critique.getLivre().getIdLivre());
		livreUpdated.setNote_moyenne(somme/counter);
		dao.updateLivre(livreUpdated);
	}
	
	@Path("/newLivre")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public void createLivre(Livres livre) {
		dao.createLivre(livre);
	}
	
	@Path("/updateAuteur")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAuteur(Auteurs auteur) {
		dao.updateAuteur(auteur);
	}
	
	@Path("/updateCritique")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCritique(Critiques critique) {
		dao.updateCritique(critique);
		List<Critiques> critiques = dao.ListAllCritiques();
		double somme = 0;
		int counter = 0;
		for (Critiques c:critiques) {
			if(c.getLivre().getIdLivre() == critique.getLivre().getIdLivre()) {
				somme = somme + c.getNote();
				counter = counter + 1;
			}	
		}
		Livres livreUpdated = dao.readLivre(critique.getLivre().getIdLivre());
		livreUpdated.setNote_moyenne(somme/counter);
		dao.updateLivre(livreUpdated);
	}
	
	@Path("/updateLivre")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateLivre(Livres livre) {
		dao.updateLivre(livre);
	}
	
	@Path("/deleteAuteur/{id}")
	@DELETE
	public void deleteAuteur(@PathParam("id") long id) {
		dao.deleteAuteur(id);
	}
	
	@Path("/deleteCritique/{id}")
	@DELETE
	public void deleteCritique(@PathParam("id") long id) {
		dao.deleteCritique(id);
	}
	
	@Path("/deleteLivre/{id}")
	@DELETE
	public void deleteLivre(@PathParam("id") long id) {
		dao.deleteLivre(id);
	}
	
	@Path("/tousAuteurs")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Auteurs> tousAuteurs(){
		return dao.ListAllAuteurs();
	}
	
	@Path("/tousCritiques")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Critiques> tousCritiques(){
		return dao.ListAllCritiques();
	}
	
	@Path("/tousLivres")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livres> tousLivres(){
		return dao.ListAllLivres();
	}
}
