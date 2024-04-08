import java.util.ArrayList;

public class CryptoMarche{

	private ArrayList<Portefeuille> portefeuilles;
	private static CryptoMarche marche;

	private CryptoMarche(){
		portefeuilles = new ArrayList<Portefeuille>();
	}

	public static CryptoMarche getInstance(){
		if(marche == null){ marche = new CryptoMarche();}
		return marche;
	}

	public void ajouter(Portefeuille p){
		portefeuilles.add(p);
	}

	/**
	 * Cette fonction recherche sur le marchÃ© tous les portefeuilles 
	 * du propriÃ©taire et calcule son capital en euros. 
	 * @param proprietare
	 * @return capital en euros du propriÃ©tare.
	 */
	public double capitalEnEuros(String proprietaire){
		double somme = 0.0;

		for (int i=0; i<this.portefeuilles.size(); i++)
		{
			if (this.portefeuilles.get(i).getProprietaire().equals(proprietaire))
				somme += this.portefeuilles.get(i).getMontant();
		}

		return somme;
	}

	/**
	 * Cette fonction recherche sur le marchÃ© tous les portefeuilles 
	 * d'un type de devise et calcule le volume total de capital de 
	 * cette devise sur le marchÃ© 
	 * @param monnaie
	 * @return capital total en circulation de la cryptomonnaie (en euros).
	 */
	public double capitalMonneaie(Cryptomonnaie monnaie){
		double somme = 0.0;

		for (int i=0; i<this.portefeuilles.size(); i++)
		{
			if (this.portefeuilles.get(i).getMonnaie().equals(monnaie))
				somme += this.portefeuilles.get(i).getMontant();
		}

		return somme;

	}

	@Override
	public String toString() {
		String ret = "";
		for(Portefeuille p : this.portefeuilles){
			ret += p.toString() + "\n";
		}
		return ret;
	}

}