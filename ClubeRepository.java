package clube.repository;

import clube.model.Clube;

public interface ClubeRepository {
	 
	public void procurarPorId(int id);
	
		public void listarTodas();

	    public void cadastrar(Clube cadastrar);

	    public void deletar(int id);

	    public void atualizar(Clube atualizar);

}
