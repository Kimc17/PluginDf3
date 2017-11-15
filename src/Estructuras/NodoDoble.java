package Estructuras;

public class NodoDoble  {

	ListaSimple valor;
	String name;
	

	private NodoDoble  siguiente;
	private NodoDoble  anterior;
	
	

	public NodoDoble(ListaSimple valor) {
		this.valor = valor;
		this.siguiente = null;
		this.anterior = null;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	public NodoDoble getSiguiente() {
		return siguiente;
	}



	public void setSiguiente(NodoDoble siguiente) {
		this.siguiente = siguiente;
	}



	public NodoDoble getAnterior() {
		return anterior;
	}



	public void setAnterior(NodoDoble anterior) {
		this.anterior = anterior;
	}


	public ListaSimple getValor() {
		return valor;
	}
	
	public void setValor(ListaSimple valor) {
		this.valor = valor;
	}
	
	
	


}

