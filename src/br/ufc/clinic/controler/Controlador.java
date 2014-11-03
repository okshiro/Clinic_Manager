package br.ufc.clinic.controler;

import br.ufc.clinic.repository.RepositoryManage;

public class Controlador {

	public Controlador() {
		RepositoryManage<Object> r = new RepositoryManage<Object>();
		r.load();
	}

}
