package it.softwareInside.MagazzinoStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public boolean addToDatabase(Item item) {
		if (item == null)
			return false;

		try {
			itemRepository.save(item);

			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public boolean aggiorna(Item item) {
		return addToDatabase(item);

	}

	public Item cancellaItem(int id) {
		Item item = itemRepository.findById(id).get();

		itemRepository.deleteById(id);
		return item;

	}

	public Iterable<Item> getAllData() {

		return itemRepository.findAll();
	}

	public double calcolaTotMag() {
		double tot = 0;

		for (Item item : itemRepository.findAll())
			tot += item.getCosto();
		return tot;
	}

}
