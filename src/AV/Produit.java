package AV;

public class Produit {
	public String auto_type;/* Mini-Citadine Citadine Moyenne-Berline Berline Grande-Berline 4x4-SUV Cabriolet-Coupé Break/Familiale Commerciale Pickup Fourgonnette Camionnette */
	public String marque;/* BMW Renault Peugeot Mercedes Ferrari Hyundai Ford Toyota KIA Seat Porsche*/
	public String modele;
	public String color;/*Noir Blanc Gris Vert Rouge Beige Marron Doré Argent Bleu*/
	public String option;
	public String boiteV;
	public int nbPlaces;
	public int nbPortes;
	public String carburant/*Diesel Essence GPL*/;
	public int prix;
	public boolean disponible;
	
	public Produit(){
		auto_type = "Mini-Citadine";
		marque = "Renault";
		modele = "Twingo";
		color = "Blanc";
		option = "Toute-Option";
		carburant = "Diesel";
		prix = 1000000;	
	}
	
	public Produit(String a, String ma, String mo, String co, String o, String ca, int p, String bv, int nbPl, int nbPo, boolean dispo){
		auto_type = a;
		marque = ma;
		modele = mo;
		color = co;
		option = o;
		carburant = ca;
		prix = p;
		boiteV = bv;
		nbPlaces = nbPl;
		nbPortes = nbPo;
		disponible =  dispo;
		
	}
	
	//on constitue un objet Produit avec les critères insérés par l'utilisateur  
		boolean disponible(Produit liste[], int n){
			int i;
			for(i = 0 ; i < n ; i++){
				if( (liste[i].auto_type == auto_type || auto_type ==  "") && (liste[i].marque == marque || marque ==  "") && (liste[i].modele == modele || modele ==  "") && (liste[i].color == color || color ==  "") && (liste[i].option == option || option ==  "") && (liste[i].carburant == carburant || carburant ==  "") && (liste[i].prix == prix || prix == 0) && (liste[i].boiteV == boiteV || boiteV ==  "") && (liste[i].nbPlaces == nbPlaces || nbPlaces ==  0) && (liste[i].nbPortes == nbPortes || nbPortes ==  0))//&& ( || ) && ( || ) 
					if(liste[i].disponible == true)
						return true;
			}
			return false;
		}
	
	
	

}
