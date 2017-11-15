package Estructuras;



public class NodoSimple  <T> {
	
	
	String si;
	String no;
	String expresion;
	String  body;
	String name;
	Object valor;
	String tipo;

	private NodoSimple <T> siguiente;

		public NodoSimple(Object object, String si, String no, String expression, String body, String tipo){
			this.si= si;
			this.no=no;
			this.expresion=expression;
			this.body=body;
			this.valor = object;
			this.tipo= tipo;
		}
	
		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}


		public NodoSimple <T> getSiguiente() {
			return siguiente;
		}
		
		
		public void setSiguiente(NodoSimple <T> siguiente) {
			this.siguiente = siguiente;
		}



		public String getSi() {
			return si;
		}



		public void setSi(String si) {
			this.si = si;
		}



		public String getNo() {
			return no;
		}



		public void setNo(String no) {
			this.no = no;
		}



		public String getExpresion() {
			return expresion;
		}



		public void setExpresion(String expresion) {
			this.expresion = expresion;
		}



		public String getBody() {
			return body;
		}



		public void setBody(String body) {
			this.body = body;
		}

	}
	  





          
        
  
