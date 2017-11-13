package Control;

import java.io.Serializable;



public class Lista<T> implements Serializable
{

	private static final long serialVersionUID = 1L; 


	private final static int INIT = 20;


	private final static int DELTA = 20;


	protected T[] elems;


	protected int numElems;


	public Lista( )
	{
		this( INIT );
	}

	@SuppressWarnings("unchecked")
	public Lista( int capacidad )
	{
		elems = ( T[] )new Object[capacidad];
		numElems = 0;
	}


	public T darElemento( int pos )
	{
		if( pos < 0 || pos > numElems )
			throw new IndiceFueraDeRangoException( pos );
		return elems[ pos ];
	}


	@SuppressWarnings("unchecked")
	public void agregar( T elem )
	{

		if( numElems == elems.length )
		{
			T viejo[] = elems;
			elems = ( T[] )new Object[elems.length + DELTA];
			System.arraycopy( viejo, 0, elems, 0, viejo.length );
		}
		elems[ numElems++ ] = elem;
	}


	@SuppressWarnings("unchecked")
	public void insertar( T elem, int pos )
	{
		if( pos < 0 || pos > numElems )
		{
			throw new IndiceFueraDeRangoException( pos );
		}

		if( numElems == elems.length )
		{
			T viejo[] = elems;
			elems = ( T[] )new Object[elems.length + DELTA];
			System.arraycopy( viejo, 0, elems, 0, viejo.length );
		}

		for( int i = numElems - 1; i >= pos; i-- )
		{
			elems[ i + 1 ] = elems[ i ];
		}

		numElems++;

		elems[ pos ] = elem;
	}

	public T eliminar( int pos )
	{
		if( pos < 0 || pos >= numElems )
		{
			throw new IndiceFueraDeRangoException( pos );
		}

		T resp = elems[ pos ];

		for( int i = pos; i < numElems - 1; i++ )
		{
			elems[ i ] = elems[ i + 1 ];
		}

		elems[ numElems - 1 ] = null;

		numElems--;

		return resp;
	}


	public T eliminar( T elem )
	{
		int pos = 0;

		for( ; pos < numElems && !elem.equals( elems[ pos ] ); pos++ )
			;

		T eliminado = null;

		if( pos < numElems )
			eliminado = eliminar( pos );

		return eliminado;
	}


	public int buscar( T elem )
	{
		int pos = 0;
		for( ; pos < numElems && !elem.equals( elems[ pos ] ); pos++ )
			;
		return pos == numElems ? -1 : pos;
	}


	public int darLongitud( )
	{
		return numElems;
	}


	public void asignar( T elem, int pos )
	{
		if( pos < 0 || pos > numElems || numElems == 0 )
			throw new IndiceFueraDeRangoException( pos );
		elems[ pos ] = elem;
	}





	public void vaciar( )
	{

		for( int i = 0; i < numElems; i++ )
			elems[ i ] = null;
		numElems = 0;
	}


	public boolean contiene( T elem )
	{
		return buscar( elem ) != -1;
	}


	public boolean esVacio( )
	{
		return darLongitud( ) == 0;
	}


	@Override
	public String toString( )
	{
		String resp = "[" + numElems + "]:";
		for( int i = 0; i < numElems; i++ )
		{
			resp += elems[ i ] + "-";
		}
		return resp;
	}
}