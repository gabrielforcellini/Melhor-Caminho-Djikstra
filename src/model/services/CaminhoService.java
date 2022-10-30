package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Caminho;

public class CaminhoService {
	public List<Caminho> findAll() {
		List<Caminho> list = new ArrayList<>();
		list.add(new Caminho("",1,"Morro da Fumaça", "Criciuma", 2, 25.00));
		list.add(new Caminho("",2,"Criciuma", "Tubarão", 3, 50.00));
		return list;
	}
}
