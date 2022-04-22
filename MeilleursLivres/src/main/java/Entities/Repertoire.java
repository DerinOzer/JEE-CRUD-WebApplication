package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

public class Repertoire {
	@PersistenceContext(unitName="goodreads")
	private EntityManagerFactory emf; 
	
	public Repertoire() {
		emf = Persistence.createEntityManagerFactory("goodreads");
	}
	
	public List<Auteurs> ListAllAuteurs(){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("From Auteurs",Auteurs.class).getResultList();
	}
	
	public List<Critiques> ListAllCritiques(){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("From Critiques",Critiques.class).getResultList();
	}
	
	public List<Livres> ListAllLivres(){
		EntityManager em = emf.createEntityManager();
		return em.createQuery("From Livres",Livres.class).getResultList();
	}
	
	// Méthodes CREATE pour chaque entité :
	public void createAuteur(Auteurs auteur) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Auteurs temp = new Auteurs();
		temp.setPrenom(auteur.getPrenom());
		temp.setNom(auteur.getNom());
		temp.setBio(auteur.getBio());
		//temp.setLivres(auteur.getLivres());
		em.persist(temp);
		em.getTransaction().commit();
		em.close();
	}
	
	public void createCritique(Critiques critique) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Critiques temp = new Critiques();
		temp.setCommentaire(critique.getCommentaire());
		temp.setNote(critique.getNote());
		temp.setLivre(critique.getLivre());
		/*List<Critiques> critiques = ListAllCritiques();
		double somme = 0;
		int counter = 0;
		for (Critiques c:critiques) {
			if(c.getLivre().getIdLivre() == critique.getLivre().getIdLivre()) {
				somme = somme + c.getNote();
				counter ++;
			}	
		}
		somme = somme + temp.getNote();
		Livres livreUpdated = new Livres();
		livreUpdated.setTitre(critique.getLivre().getTitre());
		livreUpdated.setAuteur(critique.getLivre().getAuteur());
		livreUpdated.setAnnee(critique.getLivre().getAnnee());
		livreUpdated.setDescription(critique.getLivre().getDescription());
		livreUpdated.setGenre(critique.getLivre().getGenre());
		livreUpdated.setCritiques(critique.getLivre().getCritiques());
		livreUpdated.setIsbn(critique.getLivre().getIsbn());
		livreUpdated.setNombre_de_page(critique.getLivre().getNombre_de_page());
		livreUpdated.setNote_moyenne(somme/(counter + 1));
		em.persist(temp);
		//updateLivre(livreUpdated);*/
		em.persist(temp);
		em.getTransaction().commit();
		em.close();
	}
	
	public void createLivre(Livres livre) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Livres temp = new Livres();
		temp.setTitre(livre.getTitre());
		temp.setAuteur(livre.getAuteur());
		temp.setAnnee(livre.getAnnee());
		temp.setDescription(livre.getDescription());
		temp.setGenre(livre.getGenre());
		//temp.setCritiques(livre.getCritiques());
		temp.setIsbn(livre.getIsbn());
		temp.setNombre_de_page(livre.getNombre_de_page());
		temp.setNote_moyenne(livre.getNote_moyenne());
		em.persist(temp);
		em.getTransaction().commit();
		em.close();
	}
	
	
	// Méthodes READ pour chaque entité :
	public Auteurs readAuteur(Long id){
		EntityManager em = emf.createEntityManager();
        return em.find(Auteurs.class,id);
    }
	
	public Critiques readCritique(Long id){
		EntityManager em = emf.createEntityManager();
        return em.find(Critiques.class,id);
    }
	
	public Livres readLivre(Long id){
		EntityManager em = emf.createEntityManager();
        return em.find(Livres.class,id);
    }
	
	// Méthodes UPDATE pour chaque entité :
	public void updateAuteur(Auteurs auteur) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Auteurs temp = em.find(Auteurs.class, auteur.getIdAuteur());
		temp.setPrenom(auteur.getPrenom());
		temp.setNom(auteur.getNom());
		temp.setBio(auteur.getBio());
		//temp.setLivres(auteur.getLivres());
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateLivre(Livres livre) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Livres temp = em.find(Livres.class, livre.getIdLivre());
		temp.setTitre(livre.getTitre());
		temp.setAuteur(livre.getAuteur());
		temp.setAnnee(livre.getAnnee());
		temp.setDescription(livre.getDescription());
		temp.setGenre(livre.getGenre());
		//temp.setCritiques(livre.getCritiques());
		temp.setIsbn(livre.getIsbn());
		temp.setNombre_de_page(livre.getNombre_de_page());
		temp.setNote_moyenne(livre.getNote_moyenne());
		em.getTransaction().commit();
		em.close();
	}

	public void updateCritique(Critiques critique) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Critiques temp = em.find(Critiques.class, critique.getIdCritique());
		temp.setCommentaire(critique.getCommentaire());
		temp.setLivre(critique.getLivre());
		temp.setNote(critique.getNote());
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteAuteur(Long id){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Auteurs.class,id));
		em.getTransaction().commit();
    }
	
	public void deleteCritique(Long id){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Critiques.class,id));
		em.getTransaction().commit();
    }
	
	public void deleteLivre(Long id){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Livres.class,id));
		em.getTransaction().commit();
    }
	
	
	
	
	
	
	
	
	// her post critique işleminden sonra bunun yapılması gerekiyor
	/*public void updateNote(Long idLivre)
	{	
		EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
		List<Critiques> critiques = new ArrayList<>();
		critiques = ListAllCritiques();
		double somme = 0;
		int nombreCommentaire = 0;
		for (Critiques critique:critiques) {
			if(critique.getLivre().getIdLivre()==idLivre) {
				somme = somme + critique.getNote();
				nombreCommentaire++;
			}
		}
		
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<Livres> updateCriteria = cb.createCriteriaUpdate(Livres.class);
		Root<Livres> root = updateCriteria.from(Livres.class);
		showLivres(idLivre).setNote_moyenne(somme/nombreCommentaire);
		updateCriteria.set(root.get("note_moyenne"), somme/nombreCommentaire);
		updateCriteria.where(cb.equal(root.get("idLivre"), idLivre));
		em.getTransaction().commit();
		em.close();
	}*/
	
/*
	public List<Auteurs> getAuteurs(Long id)
	{
		EntityManager em = emf.createEntityManager();
		TypedQuery<Auteurs> query;
		String reqJPQL = "SELECT nom FROM Auteurs WHERE id >= :value";
		query = em.createQuery(reqJPQL,Auteurs.class);
		query.setParameter("value",id);
		List<Auteurs> auteurs= query.getResultList();
        return auteurs;
	}
	
	public void saveAuteur(Auteurs auteur){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        if (auteur.getId()==null){
            em.persist(auteur);
        }

        tx.begin();
        tx.commit();
    }
	
	public void updateAuteur(Auteurs auteur){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        if (auteur.getId()!=null)
            em.merge(auteur);

        tx.begin();
        tx.commit();
    }

    public Auteurs showAuteur(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(Auteurs.class,id);
    }

    public void deleteAuteur(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(em.find(Auteurs.class,id));
        tx.commit();
    }
    
    public void saveLivre(Livres livre){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        if (livre.getIsbn()==null){
            em.persist(livre);
        }

        tx.begin();
        tx.commit();
    }
	
	public void updateLivre(Livres livre){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        if (livre.getIsbn()!=null)
            em.merge(livre);

        tx.begin();
        tx.commit();
    }

    public Livres showLivre(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(Livres.class,id);
    }

    public void deleteLivre(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(em.find(Livres.class,id));
        tx.commit();
    }
    
    public void saveCritique(Critiques critique){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        if (critique.getId()==null){
            em.persist(critique);
        }

        tx.begin();
        tx.commit();
    }
	
	public void updateCritique(Critiques critique){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        if (critique.getId()!=null)
            em.merge(critique);

        tx.begin();
        tx.commit();
    }

    public Critiques showCritique(Long id){
        EntityManager em = emf.createEntityManager();
        return em.find(Critiques.class,id);
    }

    public void deleteCritique(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.remove(em.find(Critiques.class,id));
        tx.commit();
    }*/

}
