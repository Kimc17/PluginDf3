package Control;



public class IndiceFueraDeRangoException extends RuntimeException
{

private static final long serialVersionUID = 1L;

public IndiceFueraDeRangoException( int valor )
{
super( "Índice: " + valor );
}
}
