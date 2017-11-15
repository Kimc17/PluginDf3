package Estructuras;

import org.eclipse.jdt.core.dom.MethodDeclaration;

public class ListaSimple <T> {
	
		
		private NodoSimple <T> inicio;
		private int size;
		public  String name;
		

		
		public ListaSimple() {
			super();
			this.inicio = null;
			this.size = 0;
		}
		
		
		
		public NodoSimple <T> getInicio() {
			return inicio;
		}
		public void setInicio(NodoSimple <T> inicio) {
			this.inicio = inicio;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		

		
		
		
		public boolean esVacia(){
			return inicio == null;
		}
		
		public void agregarAlFinal(Object object, String si, String no, String expression, String body, String tipo){

			NodoSimple  nuevo = new NodoSimple(object,si, no, expression, body, tipo);

			if (esVacia()) {

				inicio = nuevo;

			} else{
				NodoSimple <T> aux = inicio;

				while(aux.getSiguiente() != null){
					aux = aux.getSiguiente();
				}

				aux.setSiguiente(nuevo);
			}
			size++;
		}
		
		
		
	
		public boolean buscar(String referencia){
			NodoSimple <T> aux = inicio;
			boolean encontrado = false;
			while(aux != null && encontrado != true){
				if (referencia == aux.getName()){
					encontrado = true;
				}
				else{
					aux = aux.getSiguiente();
				}
			}
			return encontrado;
		}
		

		public Object Extraer(String i){
			NodoSimple <T> aux = inicio;
			boolean encontrado = false;
			while(aux != null && encontrado != true){
				if (i == aux.getName()){
					encontrado = true;
				}
				else{
					aux = aux.getSiguiente();
				}
			}
			return aux.getName();
		}

		
		public void Print(){
			NodoSimple <T> aux = inicio;
			while(aux != null){
					System.out.println("nombre  " + aux.getName());
					System.out.println("tipo   " + aux.tipo);
					System.out.println("expression   " + aux.getExpresion());
					System.out.println("si  " + aux.getSi());
					System.out.println("no  " + aux.getNo());
					System.out.println("body   " + aux.getBody());
					aux = aux.getSiguiente();
				}
		


	}
}



