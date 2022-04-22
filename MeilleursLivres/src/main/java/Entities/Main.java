package Entities;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Repertoire dao = new Repertoire();
		// TODO Auto-generated method stub
		List<Livres> tous = dao.ListAllLivres();
		
		Livres CeluiQuOnVeut = new Livres();
		
		for(Livres l:tous) {
			if(l.getIdLivre()==2)
				CeluiQuOnVeut = l;
		}
		
		Critiques c = new Critiques();
		c.setCommentaire("testjhkjhkjnj");
		c.setLivre(CeluiQuOnVeut);
		c.setNote(3);
		dao.createCritique(c);
		System.out.println(c);

	}

}
