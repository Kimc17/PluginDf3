package Control;

import org.eclipse.jdt.core.dom.MethodDeclaration;

public class ListaSimple <T> {
	
		
		private NodoSimple <T> inicio;
		private int size;
		public  T name;
		

		
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
		public T getName() {
			return name;
		}
		public void setName(T name) {
			this.name = name;
		}
		

		
		
		
		public boolean esVacia(){
			return inicio == null;
		}
		
		public void agregarAlFinal(T method){

			NodoSimple <T> nuevo = new NodoSimple <T>(method);

			nuevo.setValor(method);

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
		

		public Object Extraer(String referencia){
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
			return aux.getValor();
		}

		
		public void Print(){
			NodoSimple <T> aux = inicio;
			while(aux != null){
					System.out.println(aux.getValor());
					aux = aux.getSiguiente();
				}
		


	}
}



