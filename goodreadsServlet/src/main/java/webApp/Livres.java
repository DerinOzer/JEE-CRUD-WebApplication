package webApp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Livres")
public class Livres implements Serializable {
	
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idLivre;
	private String isbn;
	private String titre;
	private int annee;
	private String description;
	private double note_moyenne;
	private int nombre_de_page;
	private String genre;

	@ManyToOne @JoinColumn(name="idAuteur", nullable=false)
	private Auteurs auteur;
	
	/*@OneToMany(targetEntity = Critiques.class, mappedBy="livre")
	private List<Critiques> critiques = new ArrayList<>();*/
	
	public Livres() {}

	public Livres(Long idLivre, String isbn, String titre, int annee, String description, double note_moyenne,
			int nombre_de_page, String genre, Auteurs auteur) {
		super();
		this.idLivre = idLivre;
		this.isbn = isbn;
		this.titre = titre;
		this.annee = annee;
		this.description = description;
		this.note_moyenne = note_moyenne;
		this.nombre_de_page = nombre_de_page;
		this.genre = genre;
		this.auteur = auteur;
	}
	
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Auteurs getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteurs auteur) {
		this.auteur = auteur;
	}

	public int getAnnee() {
		return annee;
	}
	
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getNote_moyenne() {
		return note_moyenne;
	}
	
	public void setNote_moyenne(double note_moyenne) {
		this.note_moyenne = note_moyenne;
	}

	
	public Long getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Long idLivre) {
		this.idLivre = idLivre;
	}

	public int getNombre_de_page() {
		return nombre_de_page;
	}

	public void setNombre_de_page(int nombre_de_page) {
		this.nombre_de_page = nombre_de_page;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	/*public List<Critiques> getCritiques() {
		return critiques;
	}

	public void setCritiques(List<Critiques> critiques) {
		this.critiques = critiques;
	}*/

	@Override
	public String toString() {
		return "Livres [idLivre=" + idLivre + ", isbn=" + isbn + ", titre=" + titre + ", annee=" + annee
				+ ", description=" + description + ", note_moyenne=" + note_moyenne + ", nombre_de_page="
				+ nombre_de_page + ", genre=" + genre + ", auteur=" + auteur + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(annee, auteur, description, genre, idLivre, isbn, nombre_de_page, note_moyenne, titre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livres other = (Livres) obj;
		return annee == other.annee && Objects.equals(auteur, other.auteur)
				&& Objects.equals(description, other.description) && Objects.equals(genre, other.genre)
				&& Objects.equals(idLivre, other.idLivre) && Objects.equals(isbn, other.isbn)
				&& nombre_de_page == other.nombre_de_page
				&& Double.doubleToLongBits(note_moyenne) == Double.doubleToLongBits(other.note_moyenne)
				&& Objects.equals(titre, other.titre);
	}
	
	
	
	

}
