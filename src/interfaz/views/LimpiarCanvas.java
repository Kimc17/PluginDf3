package interfaz.views;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;

public class LimpiarCanvas {
	Canvas canvas;
	public LimpiarCanvas(Canvas canvas) {
		this.canvas = canvas;
		canvas.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.fillRectangle(0, 0, 2000, 2000);
				
			}
		});
	}
}
