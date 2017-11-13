package Control;

import java.io.Serializable;


public interface Iterador<T> extends Serializable{


public boolean haySiguiente( );


public T darSiguiente( );


public boolean hayAnterior( );


public T darAnterior( );


public void reiniciar( );
}
 
