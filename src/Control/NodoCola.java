package Control;

import java.io.Serializable;


public class NodoCola<T> implements Serializable
{

private static final long serialVersionUID = 1L;


private T elemento;


private NodoCola<T> sigNodo;


public NodoCola( T pElemento )
{
elemento = pElemento;
sigNodo = null;
}


public T darElemento( )
{
return elemento;
}


public NodoCola<T> desconectarPrimero( )
{
NodoCola<T> p = sigNodo;
sigNodo = null;
return p;
}




public NodoCola<T> insertarDespues( NodoCola<T> nodo )
{
sigNodo = nodo;
return nodo;
}


public NodoCola<T> darSiguiente( )
{
return sigNodo;
}


@Override
public String toString( )
{
return elemento.toString( );
}
}
 