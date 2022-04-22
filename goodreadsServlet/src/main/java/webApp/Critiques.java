package webApp;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Critiques")
public class Critiques implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCritique;
	private double note;
	private String commentaire;
	
	@ManyToOne @JoinColumn(name="idLivre", nullable=false)
	private Livres livre;
	
	public Critiques() {}
	
	public Critiques(Long idCritique, double note, String commentaire, Livres livre) {
		super();
		this.idCritique = idCritique;
		this.note = note;
		this.commentaire = commentaire;
		this.livre = livre;
	}

	

	public Long getIdCritique() {
		return idCritique;
	}

	public void setIdCritique(Long idCritique) {
		this.idCritique = idCritique;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Livres getLivre() {
		return livre;
	}

	public void setLivre(Livres livre) {
		this.livre = livre;
	}

	@Override
	public String toString() {
		return "Critiques [idCritique=" + idCritique + ", note=" + note + ", commentaire=" + commentaire + ", livre="
				+ livre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentaire, idCritique, livre, note);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Critiques other = (Critiques) obj;
		return Objects.equals(commentaire, other.commentaire) && Objects.equals(idCritique, other.idCritique)
				&& Objects.equals(livre, other.livre)
				&& Double.doubleToLongBits(note) == Double.doubleToLongBits(other.note);
	}	
	
	
	
	
}
