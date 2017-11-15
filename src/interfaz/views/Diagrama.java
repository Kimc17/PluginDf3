package interfaz.views;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

import Estructuras.ListaSimple;
import Estructuras.NodoSimple;

public class Diagrama{
	int x;
	int y;
	Canvas canvas;
	ListaSimple<String> datos;
	
	public Diagrama(Canvas canvas1, ListaSimple<String> data) {
		this.x = 220;
		this.y = 20;
		this.canvas = canvas1;
		this.datos = data;
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				LimpiarCanvas delete = new LimpiarCanvas(canvas1);
				
				NodoSimple pivote = data.getInicio();
				if(pivote.getTipo().equals("if")) {
					If nuevo = new If(canvas, x, y, pivote);
				}else if(pivote.getTipo().equals("while")) {
					While nuevo = new While(canvas, x, y, pivote);
				}else if(pivote.getTipo().equals("for")) {
					For nuevo = new For(canvas, x , y, pivote);
				}else if(pivote.getTipo().equals("do")) {
					doWhile nuevo = new doWhile(canvas, x, y, pivote);
				}
				
				
			}
		});
	}
	
	
}
	