package Control;



public class IteradorSimple<T> implements Iterador<T>
{

private static final long serialVersionUID = 1L; 

private final static int NADA = -1;


private T[] elems;


private int posActual;


private int sigPosLibre;


@SuppressWarnings("unchecked")
public IteradorSimple( int tamanio )
{
elems = ( T[] )new Object[tamanio];
sigPosLibre = 0;
posActual = NADA;
}


public boolean haySiguiente( )
{
return elems.length > 0 && ( posActual + 1 ) < sigPosLibre;
}

public T darSiguiente( )
{
return haySiguiente( ) ? elems[ ++posActual ] : null;
}


public T darAnterior( )
{
return hayAnterior( ) ? elems[ --posActual ] : null;
}


public boolean hayAnterior( )
{
return elems.length > 0 && posActual > 0;
}


public void reiniciar( )
{
posActual = NADA;
}


public void agregar( T elem ) throws IteradorException
{
if( sigPosLibre <= elems.length - 1 )
{
elems[ sigPosLibre++ ] = elem;
}
else
throw new IteradorException( "Límite del iterador alcanzado" );
}


public void insertar( T elem ) throws IteradorException
{
if( sigPosLibre >= elems.length )
throw new IteradorException( "Límite del iterador alcanzado" );

for( int i = sigPosLibre; i > 0; i-- )
{
elems[ i ] = elems[ i - 1 ];
}
sigPosLibre++;
elems[ 0 ] = elem;
}


@Override
public String toString( )
{
String resp = "[" + sigPosLibre + "]:";
for( int i = 0; i < sigPosLibre; i++ )
{
resp += elems[ i ] + "-";
}
return resp;
}


public int darSigPosLibre( )
{
return sigPosLibre;
}


public int darPosActual( )
{
return posActual;
}
public int darLongitud( )
{
return elems.length;
}
}