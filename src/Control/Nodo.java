package Control;


	public class Nodo
	{
	public ListaSimple nodosHijos= new ListaSimple();
	private String info="";
	private int preorden=0;
	private int postOrden=0;

	public Nodo(String theInfo)
	{
	this.setInfo(theInfo);
	}

	public String getInfo()
	{
	return this.info;
	}

	public void setInfo(String theInfo)
	{
	this.info=theInfo;
	}

	public int getPostOrden() {
	return postOrden;
	}

	public void setPostOrden(int postOrden) {
	this.postOrden = postOrden;
	}

	public int getPreorden() {
	return preorden;
	}

	public void setPreorden(int preorden) {
	this.preorden = preorden;
	}
	}


