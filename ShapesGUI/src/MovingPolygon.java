/*
 *	===============================================================================
 *	Angelo Terminez (ater906)
 *	MovingPolygon.java : A shape that is a triangle.
 *	The triangle has 3 handles shown when it is selected (by clicking on it).
 *	===============================================================================
 */
import java.awt.*;
public class MovingPolygon extends MovingShape{
	
	public MovingPolygon() {
		super();
	}

	/** constuctor to create a triangle shape
	 */
	public MovingPolygon(int x, int y, int w, int h,  int mw, int mh, Color bc, int pathType, float pen) {
		super(x ,y ,w, h ,mw ,mh ,bc, pathType, pen);
	}
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(borderColor);
		g2d.setStroke(new BasicStroke(penWidth));
		
		int[] xCoord= {p.x+width/2, p.x, p.x + width};
		int[] yCoord ={p.y, p.y + height, p.y + height} ;
		int n = 3;
		
		g2d.drawPolygon(xCoord,yCoord,n);
		drawHandles(g);
	}
	public void drawHandles(Graphics g) {
		// if the shape is selected, then draw the handles
		if (isSelected()) {
			g.setColor(Color.black);
			g.fillRect(p.x + width -2, p.y + height -2, 4, 4);
			g.fillRect(p.x -2, p.y + height -2, 4, 4);
			g.fillRect((p.x + width/2) -2, p.y-2, 4, 4);
		}
	}
	public boolean contains(Point mousePt) {
		return (p.x <= mousePt.x && mousePt.x <= (p.x + width + 1)	&&	p.y <= mousePt.y && mousePt.y <= (p.y + height + 1));
	}
}

