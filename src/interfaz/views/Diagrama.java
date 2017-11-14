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
				if(tipo.equals("If")) {
					//Dibujo rombo 
					e.gc.drawLine(x, y, x+90, y+30);
					e.gc.drawLine(x+90, y+30, x, y+60);
					e.gc.drawLine(x, y+60, x-90, y+30);
					e.gc.drawLine(x-90, y+30, x, y);
					e.gc.drawString("Condición", x-30, y+20);
					
					e.gc.drawLine(x-90, y+30, x-140, y+30);
					e.gc.drawLine(x-140, y+30, x-140, y+90);
					e.gc.drawRectangle(x-140-140/4, y+90, 70, 90);
					e.gc.drawString("Sí", x-140, y+30);
					e.gc.drawString("Acción", x-160, y+135);
					
					e.gc.drawLine(x+90, y+30, x+140, y+30);
					e.gc.drawLine(x+140, y+30, x+140, y+90);
					e.gc.drawRectangle(x+140-140/4, y+90, 70, 90);
					e.gc.drawString("Sí", x+140, y+30);
					e.gc.drawString("Acción", x+120, y+135);
					
				
				}else if(tipo.equals("For")) {
					
				}else if(tipo.equals("While")) {
					
				}
			}
		});
	}
	
	
}
	