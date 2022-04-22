package Entities;

import java.io.Serializable;

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
	
	
	
}
