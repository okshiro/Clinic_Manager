package br.ufc.clinic;
import br.ufc.clinic.classes.Conta;
import br.ufc.clinic.repository.GenericRepository;


public class App {

	public static void main(String[] args) {
		GenericRepository<Conta> rep = new GenericRepository<Conta>("contas");
		rep.load();
		rep.pull();
		rep.add(new Conta("aasdad", "sdasda"));
		for (Conta c : rep.get()) {
			System.out.println(c.getUsuario());
		}
	}

}
