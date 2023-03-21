package it.softwareInside.MagazzinoStore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Item {

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Id
	private int id;

	private String marca;
	private String tipologia;
	private double costo;

	public Item(String marca, String tipologia, Double costo) {
		super();
		this.marca = marca;
		this.tipologia = tipologia;
		this.costo = costo;

	}
}