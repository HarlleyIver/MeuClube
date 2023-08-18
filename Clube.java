package clube.model;

public abstract class Clube {

	private int id;
	private String time1;
	private String time2;
	private String estadio;
	private int tipo;
	private String data;
	private String hora;

	public Clube(int id, String time1, String time2, String estadio, int tipo, String data, String hora) {
		this.id = id;
		this.time1 = time1;
		this.time2 = time2;
		this.estadio = estadio;
		this.tipo = tipo;
		this.data = data;
		this.hora = hora;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public void visualizar() {

		String tipo = "";
		
		switch(this.tipo) {
		case 1:
			tipo = "Inteira";
		break;
		case 2:
			tipo = "Meia-Entrada";
		break;
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do Ingresso:");
		System.out.println("***********************************************************");
		System.out.println("Número do Ingresso: "+ this.id);
		System.out.println("Time: " + this.time1);
		System.out.println("Visitante: " + this.time2);
		System.out.println("Estádio: " + this.estadio);
		System.out.println("Data: " + this.data);
		System.out.println("Horário: " + this.hora);
		System.out.println("Entrada: " + tipo);
		


	}
  
}
