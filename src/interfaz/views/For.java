package interfaz.views;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

import Estructuras.NodoSimple;

public class For {
	
	Canvas canvas;
	int x;
	int y;
	
	public For(Canvas canvas, int x, int y, NodoSimple statement) {
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.drawRectangle(x-50, y+100, 100, 80);
				e.gc.drawLine(x, y, x+90, y+30);
				e.gc.drawLine(x+90, y+30, x, y+60);
				e.gc.drawLine(x, y+60, x-90, y+30);
				e.gc.drawLine(x-90, y+30, x, y);
				e.gc.drawString(statement.getExpresion(), x-50, y+20);
				
				e.gc.drawLine(x, y+60, x, y+100);
				e.gc.drawLine(x-50, y+120, x-120, y+120);
				e.gc.drawLine(x-120, y+120, x-120, y+30);
				e.gc.drawLine(x-120, y+30, x-90, y+30);
				
				e.gc.drawString("Sí", x, y+80);
				e.gc.drawString(statement.getBody(), x-40, y+130);
				
				e.gc.drawLine(x+90, y+30, x+120, y+30);
				e.gc.drawString("No", x+120, y+30);
				e.gc.drawLine(x+120, y+30, x+120, y+200);
				e.gc.drawLine(x+120, y+200, x, y+200);
				e.gc.drawLine(x, y+200, x, y+275);
				
				
			}
		});
	}
	
}
