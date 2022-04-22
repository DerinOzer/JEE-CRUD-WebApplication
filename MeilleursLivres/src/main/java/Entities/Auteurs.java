package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Auteurs")
public class Auteurs implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAuteur;
	private String prenom;
	private String nom;
	private String bio;
	
	public Auteurs() {}
	
	/*@OneToMany(targetEntity = Livres.class, mappedBy="auteur")
	private List<Livres> livres = new ArrayList<>();*/
	
	public Auteurs(Long id, String prenom, String nom, String bio) {
		super();
		this.idAuteur = id;
		this.prenom = prenom;
		this.nom = nom;
		this.bio = bio;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public Long getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Long idAuteur) {
		this.idAuteur = idAuteur;
	}

	/*public List<Livres> getLivres() {
		return livres;
	}

	public void setLivres(List<Livres> livres) {
		this.livres = livres;
	}*/

	@Override
	public String toString() {
		return "Auteurs [id=" + idAuteur + ", prenom=" + prenom + ", nom=" + nom + ", bio=" + bio + "]";
	}
	
	
	

}
