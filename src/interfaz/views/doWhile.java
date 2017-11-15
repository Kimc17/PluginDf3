package interfaz.views;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

public class doWhile {
	Canvas canvas;
	int x;
	int y;
	
	public doWhile(Canvas canvas, int x1, int y1) {
		this.canvas = canvas;
		this.x = x1;
		this.y = y1;
		
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.drawLine(x, y, x, y+30);
				e.gc.drawRectangle(x-60, y+30, 120, 40);
				e.gc.drawLine(x, y+70, x, y+140);
				e.gc.drawString("Acción", x-20, y+45);
				
				int y = y1+140;
				e.gc.drawLine(x, y, x+90, y+30);
				e.gc.drawLine(x+90, y+30, x, y+60);
				e.gc.drawLine(x, y+60, x-90, y+30);
				e.gc.drawLine(x-90, y+30, x, y);
				
				e.gc.drawLine(x, y+60, x, y+120);
				
				e.gc.drawLine(x-90, y+30, x-130, y+30);
				e.gc.drawLine(x-130, y+30, x-130, y1+50);
				e.gc.drawString("Sí", x-130, y1+110);
				e.gc.drawLine(x-130, y1+50, x-60, y1+50);
				e.gc.drawString("Condición", x-30, y+25);
				
				
				
			}
		});
	}
}
