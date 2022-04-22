package webApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Principale principale = new Principale();
	boolean livresAlreadyShown = false;
	
	//String resp = target.request().accept(MediaType.TEXT_PLAIN).get(String.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String titre = request.getParameter("titre");
		String auteur = request.getParameter("auteur");
		String noteMoyenne = request.getParameter("noteMoyenne");
		String genre = request.getParameter("genre");
		String isbn = request.getParameter("isbn");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("titre", titre);
		session.setAttribute("auteur", auteur);
		session.setAttribute("noteMoyenne", noteMoyenne);
		session.setAttribute("genre", genre);
		session.setAttribute("isbn", isbn);*/
		
		/*HttpSession session = request.getSession(true);
		session.setAttribute("titre", titre);*/
		
		request.getRequestDispatcher("/showLivre.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String titre = request.getParameter("titre");
		String auteur = request.getParameter("auteur");
		String genre = request.getParameter("genre");

		
		HttpSession session = request.getSession(true);
		session.setAttribute("titre", titre);
		session.setAttribute("auteur", auteur);
		session.setAttribute("genre", genre);

	
		List<Livres> tousLivres = principale.getAllLivres();
		List<Livres> rechercheLivres = new ArrayList<>();
		
		if((titre!="") && (auteur=="") && (genre=="")) {
			for(Livres livre:tousLivres) {
				if(titre.equals(livre.getTitre())) {
					rechercheLivres.add(livre);
				}
			}
		}
		
		if((titre!="") && (auteur!="") && (genre=="")) {
			for(Livres livre:tousLivres) {
				if(titre.equals(livre.getTitre()) && (auteur.equals(livre.getAuteur().getPrenom()+" "+livre.getAuteur().getNom()) || auteur.equals(livre.getAuteur().getNom()) || auteur.equals(livre.getAuteur().getPrenom()))) {
					rechercheLivres.add(livre);
				}
			}
		}
		
		if((titre=="") && (auteur!="") && (genre!="")) {
			for(Livres livre:tousLivres) {
				if(genre.equals(livre.getGenre()) && (auteur.equals(livre.getAuteur().getPrenom()+" "+livre.getAuteur().getNom()) || auteur.equals(livre.getAuteur().getNom()) || auteur.equals(livre.getAuteur().getPrenom()))) {
					rechercheLivres.add(livre);
				}
			}
		}
		
		if((titre!="") && (auteur=="") && (genre!="")) {
			for(Livres livre:tousLivres) {
				if(titre.equals(livre.getTitre()) && genre.equals(livre.getGenre())) {
					rechercheLivres.add(livre);
				}
			}
		}
		
		if((titre!="") && (auteur!="") && (genre!="")) {
			for(Livres livre:tousLivres) {
				if(titre.equals(livre.getTitre()) && genre.equals(livre.getGenre()) && (auteur.equals(livre.getAuteur().getPrenom()+" "+livre.getAuteur().getNom()) || auteur.equals(livre.getAuteur().getNom()) || auteur.equals(livre.getAuteur().getPrenom()))) {
					rechercheLivres.add(livre);
				}
			}
		}
		
		if((titre=="") && (auteur!="") && (genre=="")) {
			for(Livres livre:tousLivres) {
				if(auteur.equals(livre.getAuteur().getPrenom()+" "+livre.getAuteur().getNom()) || auteur.equals(livre.getAuteur().getNom()) || auteur.equals(livre.getAuteur().getPrenom()))
					rechercheLivres.add(livre);
			}
		}
		
		if((titre=="") && (auteur=="") && (genre!="")) {
			for(Livres livre:tousLivres) {
				if(genre.equals(livre.getGenre())) 
					rechercheLivres.add(livre);
			}
		}
		
		
		session.setAttribute("listeLivres", rechercheLivres);
		System.out.println(rechercheLivres);
		request.getRequestDispatcher("/informationsLivres.jsp").forward(request, response);
		
		/*	//request.getAttribute("ListeLivres");
			System.out.println(request.getAttribute("ListeLivres"));
			request.getRequestDispatcher("/pageCritique.jsp").forward(request, response);
			livresAlreadyShown = false;
		}*/
		
	}

}
