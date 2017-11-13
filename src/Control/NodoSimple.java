package Control;



public class NodoSimple  <T> {

	

		private T valor;
	    private String name;
	    private NodoSimple <T> siguiente;
	    
	    public NodoSimple(T valor) {
			this.valor = valor;
				siguiente=null;
			
		}
		public NodoSimple <T> getSiguiente() {
			return siguiente;
		}
		
		
		public void setSiguiente(NodoSimple <T> siguiente) {
			this.siguiente = siguiente;
		}
	
		
		public T getValor() {
			return valor;
		}
		
		public void setValor(T valor) {
			this.valor=valor;
		}
		
		
		public String getName() {
			return name;
		}
	    
		public void setName(String name) {
			this.name= name;
		}
	    

	  
	}
	  





          
        
  
