package clube.model;

public class MeiaEntrada extends Clube{

	private float valor;
	
	public MeiaEntrada(int id, String time1, String time2, String estadio, int tipo, String data, String hora, float valor) {
		super(id, time1, time2, estadio, tipo, data, hora);
		this.valor = valor;
		}
	
	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Valor: " + this.valor);
	}

}