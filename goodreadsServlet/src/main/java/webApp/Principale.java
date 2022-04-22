package webApp;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class Principale {
	private static String baseURL = "http://localhost:8080/MeilleursLivres/rest/goodreads";

	//public static void main(String[] args) {
		//getAllAuteurs();
		// TODO Auto-generated method stub
		/*Critiques critique = getCritiqueById(1);
		System.out.println(critique);*/
		
		/*Auteurs auteur = new Auteurs();
		auteur.setNom("Ozer");
		auteur.setPrenom("Derin Derinallez elle Derin");
		auteur.setBio("Maxime Maxou");
		auteur.setIdAuteur(18L);
		//updateAuteur(auteur);
		//createAuteur(auteur);
		
		Livres livre = new Livres();
		livre.setIdLivre(11L);
		livre.setAnnee(1698);
		livre.setAuteur(auteur);
		livre.setDescription("test UPDATE");
		livre.setGenre("test");
		livre.setIsbn("79u89");
		livre.setNombre_de_page(789);
		livre.setNote_moyenne(4);
		livre.setTitre("Hadi BAKALIM UPDATE");
		//updateLivre(livre);
		createLivre(livre);*/
		
		/*Critiques critique = new Critiques();
		critique.setCommentaire("TEST COPOURQUOI NNECTION UPDATE UPDATE");
		critique.setLivre(livre);
		critique.setNote(5);
		critique.setIdCritique(18L);
		//updateCritique(critique);*/
		
		//createCritique(critique);
		
		/*List<Auteurs> auteurs = getAllAuteurs();
		System.out.println(auteurs);*/
		
		/*List<Livres> livres = getAllLivres();
		System.out.println(livres);*/
		
		/*List<Critiques> critiques = getAllCritiques();
		System.out.println(critiques);*/
		
		//deleteCritique(5L);
		//deleteLivre(11L);

	//}
	
	/*for(Critiques critique : getAllCritiques()) {
	if(critique.getLivre() == livre)
		deleteCritique(critique.getIdCritique());
}*/
	static void deleteAuteur(long id) {
		Auteurs auteur = getAuteurById(id);
		for (Livres livre : getAllLivres()) {
			if(livre.getAuteur() == auteur)
				deleteLivre(livre.getIdLivre());
		}
		WebTarget target = getWebTarget();
		String URL = "/deleteAuteur/" + id;
		Response reponse = target.path(URL).request().delete(Response.class);
		System.out.println(reponse);
	}
	
	static void deleteLivre(long id) {
		Livres livre = getLivreById(id);
		for(Critiques critique : getAllCritiques()) {
			if(critique.getLivre() == livre)
				deleteCritique(critique.getIdCritique());
		}
		WebTarget target = getWebTarget();
		String URL = "/deleteLivre/" + id;
		Response reponse = target.path(URL).request().delete(Response.class);
		System.out.println(reponse);
	}
	
	static void deleteCritique(long id) {
		WebTarget target = getWebTarget();
		String URL = "/deleteCritique/" + id;
		Response reponse = target.path(URL).request().delete(Response.class);
		System.out.println(reponse);
	}
	
	static List<Auteurs> getAllAuteurs(){
		List<Auteurs> auteurs = new ArrayList<>();
		WebTarget target = getWebTarget();
		auteurs = target.path("/tousAuteurs").request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Auteurs>>() {});
		return auteurs;
	}
	
	static List<Livres> getAllLivres(){
		List<Livres> livres = new ArrayList<>();
		WebTarget target = getWebTarget();
		livres = target.path("/tousLivres").request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Livres>>() {});
		return livres;
	}
	
	static List<Critiques> getAllCritiques(){
		List<Critiques> critiques = new ArrayList<>();
		WebTarget target = getWebTarget();
		critiques = target.path("/tousCritiques").request().accept(MediaType.APPLICATION_JSON).get(new GenericType<List<Critiques>>() {});
		return critiques;
	}
	
	static void updateAuteur(Auteurs auteur) {
		WebTarget target = getWebTarget();
		Response reponse = target.path("/updateAuteur").request().post(Entity.entity(auteur, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(reponse);
	}
	
	static void updateLivre(Livres livre) {
		WebTarget target = getWebTarget();
		Response reponse = target.path("/updateLivre").request().post(Entity.entity(livre, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(reponse);
	}
	
	static void updateCritique(Critiques critique) {
		WebTarget target = getWebTarget();
		Response reponse = target.path("/updateCritique").request().post(Entity.entity(critique, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(reponse);
	}
	
	static void createAuteur(Auteurs auteur) {
		WebTarget target = getWebTarget();
		Response reponse = target.path("/newAuteur").request().post(Entity.entity(auteur, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(reponse);
	}
	
	static void createLivre(Livres livre) {
		WebTarget target = getWebTarget();
		Response reponse = target.path("/newLivre").request().post(Entity.entity(livre, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(reponse);
	}
	
	static void createCritique(Critiques critique) {
		WebTarget target = getWebTarget();
		Response reponse = target.path("/newCritique").request().post(Entity.entity(critique, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(reponse);
	}
	
	static Auteurs getAuteurById(long id) {
		WebTarget target = getWebTarget();
		String URL = "/auteur/" + id;
		System.out.println(URL);
		Auteurs auteur = target.path(URL).request().accept(MediaType.APPLICATION_JSON).get(Auteurs.class);
		return auteur;
	}
	
	static Livres getLivreById(long id) {
		WebTarget target = getWebTarget();
		String URL = "/livre/" + id;
		System.out.println(URL);
		Livres livre = target.path(URL).request().accept(MediaType.APPLICATION_JSON).get(Livres.class);
		return livre;
	}
	
	static Critiques getCritiqueById(long id) {
		WebTarget target = getWebTarget();
		String URL = "/critique/" + id;
		System.out.println(URL);
		Critiques critique = target.path(URL).request().accept(MediaType.APPLICATION_JSON).get(Critiques.class);
		return critique;
	}
	
	static WebTarget getWebTarget() {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		return client.target(baseURL);
	}
	
	

}
