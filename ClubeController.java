package clube.controller;

import java.util.ArrayList;

import clube.model.Clube;
import clube.repository.ClubeRepository;

public class ClubeController implements ClubeRepository {

	private ArrayList<Clube> listaIngressos = new ArrayList<Clube>();
	int id = 0;


	@Override
	public void procurarPorId(int id) {
		var ingresso = buscarPorId(id);
		if (ingresso != null)
			ingresso.visualizar();
		else
			System.out.println("\nO Ingresso: " + id + " não foi encontrado!\"");

	}

	@Override
	public void listarTodas() {
		for (var ingresso : listaIngressos) {
			ingresso.visualizar();
		}

	}

	@Override
	public void cadastrar(Clube clube) {
		listaIngressos.add(clube);
		System.out.println("\nO Ingresso número: " + clube.getId() + " foi cadastrado com sucesso!");

	}

	@Override
	public void deletar(int id) {
		var ingresso = buscarPorId(id);

		if (ingresso != null) {
			if(listaIngressos.remove(ingresso) == true)
				System.out.println("\nO Ingresso de Número: " + id + " foi deletado com sucesso!");
		}else
			System.out.println("\nO Ingresso de Número: " + id + " não foi encontrado!");

	}

	@Override
	public void atualizar(Clube clube) {
		var buscaIngresso = buscarPorId(clube.getId());

		if (buscaIngresso != null) {
			listaIngressos.set(listaIngressos.indexOf(buscaIngresso), clube);
			System.out.println("\nO Ingresso numero: " + clube.getId() + " foi atualizado com sucesso!");
		}else
			System.out.println("\nO Ingresso numero: " + clube.getId() + " não foi encontrado!");
	}



	public int incrementoId() {
		return ++id;
	}

	public Clube buscarPorId(int id) {
		for (var ingresso : listaIngressos) {
			if (ingresso.getId() == id) {
				return ingresso;
			}
		}
		return null;
	}
	public int retornatipo(int id) {
		for (var ingresso: listaIngressos) {
			if (ingresso.getId()==id){
				return ingresso.getTipo();
			}
		} return 0;
	}


 
}
