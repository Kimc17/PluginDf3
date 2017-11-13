package Control;

import java.io.Serializable;


public class ColaEncadenada <K> implements Serializable
{

  private static final long serialVersionUID = 1L;
 
  
    protected NodoCola <K> primero;
 
  
    protected NodoCola <K> ultimo;
 
   
    protected int numElems;
 
 
    
    public ColaEncadenada( )
    {
        primero = null;
        ultimo = null;
        numElems = 0;
    }
 
    public int darLongitud( )
    {
        return numElems;
    }
 
   
    public <T> Object tomarElemento( ) throws ColaVaciaException
    {
        if( primero == null )
            throw new ColaVaciaException( "No hay elementos en la cola" );
        else
        {
            NodoCola <K> p = (NodoCola<K>) primero;
            primero = primero.desconectarPrimero( );
            if( primero == null )
                ultimo = null;
            numElems--;
            return p.darElemento( );
        }
    }
 
   
    public void insertar( K elemento )
    {
        NodoCola <K> nodo = new NodoCola<K>( elemento );
        if( primero == null )
        {
            primero = nodo;
            ultimo = nodo;
        }
        else
        {
            ultimo = ultimo.insertarDespues( nodo );
        }
        numElems++;
    }
 
  
    public NodoCola <K> darPrimero( )
    {
        return primero;
    }
 
       public NodoCola <K> darUltimo( )
    {
        return ultimo;
    }
 
   
    public boolean estaVacia( )
    {
        return primero == null;
    }
 
   
    @Override
    public String toString( )
    {
        String resp = "[" + numElems + "]:";
        for( NodoCola <K> p = primero; p != null; p = p.darSiguiente( ) )
        {
            resp += p.darElemento( ).toString( ) + "->";
        }
        return resp;
    }
}
