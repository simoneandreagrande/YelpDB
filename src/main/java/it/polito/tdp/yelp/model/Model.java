package it.polito.tdp.yelp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.yelp.db.YelpDAO;

public class Model {

	List<Business> businesses ;
	Map<String,Business> businessIdMap ;
	
// meglio inserire la mappa nel model, che potrebbe averne bisogno
	
	public Model() {
		YelpDAO dao = new YelpDAO() ;
		this.businessIdMap = new HashMap<>() ;
		this.businesses = dao.readBusinesses(businessIdMap) ;
		
		/* se il DAO non crea la IdMap, la posso creare nel model
		for(Busi ness b: this.businesses)
			businessIdMap.put(b.getBusinessId(), b) ;
			*/
	}
	
}

//  A cosa serve l'identity map?
//  3 casi:
//	- dentro il modello mi accorgo di dover passar più volte da ID ad oggetti
//	- Risparmio memoria, creo meno oggetti
//	- Se ho oggetti che possono essere modificabili, importanti non duplicare oggetti
//	  che sembrano equals ma in realtà se cambio dei parametri con lo stesso id
//	  allora vi è confusione, importante con i grafi.