package Modelo;


public class Pruebas {
	
		    public static void comparar(int entero1, int entero2) {
		 if (entero1 > entero2)

			 System.out.println("El primer argumento es menor");
		 else
		     if(entero1 < entero2)
		System.out.println("El primer argumento es mayor."); 
		 else
		     System.out.println("Los dos argumentos son iguales");
		    }
		    
		    
		    public void numeroPar(int numero) {

		    int n;
		    do {
		    n = (int) (Math.random() * numero);
		    System.out.println(n);
		    } while (n % 2 != 0);
		    System.out.println("Y el numero par elegido es: " + n);
		    }
		    


		    public void contarHasta(int numero) {
		    System.out.println("Cuenta hasta: " + numero);
		    for (int i = 1; i <= numero; i++) {
		    System.out.println(i);
		    }
		    }
		    
		    
	
		    public int leerNumero(int sc) {
		    int numero = -1;
		     
		    while (numero <= 0) {
		    System.out.println("Introduce un numero positivo: ");
		    numero = sc;
		    }
		     
		    return numero;
		    }
}
