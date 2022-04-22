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

/**
 * Servlet implementation class ServletCritique
 */
@WebServlet("/ServletCritique")
public class ServletCritique extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Principale principale = new Principale();
	boolean dejaAffiche = false;
	Livres livrePartage = new Livres();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCritique() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/informationsLivres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if(request.getParameter("btnCritique")!="" && dejaAffiche==false ) {			
			String id = request.getParameter("btnCritique");
			long idReal = Long.parseLong(id);
			System.out.println(idReal);
			session.setAttribute("titreLivre", principale.getLivreById(idReal).getTitre());
			//List<Livres> tousLivres = principale.getAllLivres();
			List<Critiques> tousCritiques = principale.getAllCritiques();
			List<Critiques> rechercheCritique = new ArrayList<>(); 
			
			for(Critiques critique:tousCritiques) {
				if(critique.getLivre().getIdLivre() == idReal) {
					rechercheCritique.add(critique);
				}
			}
			
			livrePartage.setIdLivre(idReal);
			livrePartage.setAnnee(principale.getLivreById(idReal).getAnnee());
			livrePartage.setAuteur(principale.getLivreById(idReal).getAuteur());
			livrePartage.setDescription(principale.getLivreById(idReal).getDescription());
			livrePartage.setGenre(principale.getLivreById(idReal).getGenre());
			livrePartage.setIsbn(principale.getLivreById(idReal).getIsbn());
			livrePartage.setNombre_de_page(principale.getLivreById(idReal).getNombre_de_page());
			livrePartage.setNote_moyenne(principale.getLivreById(idReal).getNote_moyenne());
			livrePartage.setTitre(principale.getLivreById(idReal).getTitre());
			
			request.setAttribute("listeCritiques", rechercheCritique);
			request.setAttribute("livre", principale.getLivreById(idReal));
			request.getRequestDispatcher("/pageCritique.jsp").forward(request, response);
			dejaAffiche=true;
			
		}

	
		
		else{
			String comment = request.getParameter("comment");
			double note = Double.parseDouble(request.getParameter("note"));
			session.setAttribute("comment", comment);
			Critiques critique = new Critiques();
			critique.setIdCritique(1L);
			critique.setCommentaire(comment);
			critique.setNote(note);

			System.out.println(livrePartage);
			critique.setLivre(livrePartage);
			
			
			Principale.createCritique(critique);
			dejaAffiche = false;
			request.getRequestDispatcher("/Success.jsp").forward(request, response);
			
		}
		
		
		//session.setAttribute("note", note);
		
		
	}

}
