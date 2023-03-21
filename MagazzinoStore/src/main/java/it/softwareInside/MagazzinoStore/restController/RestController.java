package it.softwareInside.MagazzinoStore.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.services.ItemService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	ItemService itemService;

	/*
	 * Questo metodo serve per effettuare le richieste 
	 * DELETE per eliminare oggetti dal database
	 */
	@DeleteMapping("/elimina")
	public Item delete(@RequestParam("id") int id) {
		return itemService.cancellaItem(id);
	}
	/*
	 * con questo metodo gestisco le richieste 
	 * per ottenere tutti gli oggetti presenti nel DB
	 */
	@GetMapping("/getall")
	public Iterable<Item> getAll() {
		return itemService.getAllData();
	}

	/*
	 * creo un metodo che mi permette di aggiungere
	 *  nuovi oggetti al database
	 */
	@PostMapping("/aggiungi")
	public String aggiungi(@RequestBody() Item item) {
		if (itemService.addToDatabase(item))
			return "articolo aggiunto";

		return "non posso aggiungere l'elemento" + item;
	}
	/*
	 * e infine creo un metodo che mi permette di
	 *  modificare un oggetto già presente nel DB
	 */
	@PostMapping("/aggiorna")
	public String AggiornaItem(@RequestBody Item item) {
		if (itemService.addToDatabase(item))
			return "ok modificato";

		return "errore, non e possibile Modificare " + item + " nella lista";
	}

}// ENDCODE
