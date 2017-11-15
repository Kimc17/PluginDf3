package interfaz.views;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;

public class Diagrama{
	int x;
	int y;
	Canvas canvas;
	public Diagrama(Canvas canvas, String tipo) {
		this.x = 220;
		this.y = 20;
		this.canvas = canvas;
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				LimpiarCanvas limpiar = new LimpiarCanvas(canvas);
				if(tipo.equals("If")) {
					//Dibujo rombo 
					If dale = new If(canvas, x, y);
					
				
				}else if(tipo.equals("For")) {
					For wiii = new For(canvas, x, y);
					
				}else if(tipo.equals("While")) {
					While While1 = new While(canvas, x, y);
				}else if(tipo.equals("doWhile")){
					doWhile crearDoWhile = new doWhile(canvas, x, y);
				}
			}
		});
	}
	
	
}
	