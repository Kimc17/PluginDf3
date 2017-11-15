package interfaz.views;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

import Estructuras.NodoSimple;

public class If {
	Canvas canvas;
	int x;
	int y;
	
	public If(Canvas canvas, int x, int y, NodoSimple statement) {
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.drawLine(x, y, x+90, y+30);
				e.gc.drawLine(x+90, y+30, x, y+60);
				e.gc.drawLine(x, y+60, x-90, y+30);
				e.gc.drawLine(x-90, y+30, x, y);
				e.gc.drawString(statement.getExpresion(), x-30, y+20);
				
				e.gc.drawLine(x-90, y+30, x-140, y+30);
				e.gc.drawLine(x-140, y+30, x-140, y+90);
				e.gc.drawRectangle(x-175, y+90, 80, 90);
				e.gc.drawString("Sí", x-140, y+30);
				e.gc.drawString(statement.getSi(), x-170, y+135);
				
				e.gc.drawLine(x+90, y+30, x+140, y+30);
				e.gc.drawLine(x+140, y+30, x+140, y+90);
				e.gc.drawRectangle(x+105, y+90, 80, 90);
				e.gc.drawString("No", x+140, y+30);
				e.gc.drawString(statement.getNo(), x+110, y+135);
				
				e.gc.drawLine(x-140, y+180, x-140, y+250);
				e.gc.drawLine(x-140, y+250, x, y+250);
				
				e.gc.drawLine(x+140, y+180, x+140, y+250);
				e.gc.drawLine(x+140, y+250, x, y+250);
				
				e.gc.drawLine(x, y+250, x, y+310);
				
								
			}
		});
	}
}
