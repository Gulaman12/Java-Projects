/*
 *	===============================================================================
 *	Angelo Terminez (ater906)
 *	RotatingSquare.java : A shape that is a list of squares(3), it also rotates clockwise.
 *	The Square has 4 handles shown when it is selected (by clicking on it).
 *	Side lengths of square dependent which of width or height is set larger
 *	===============================================================================
 */
import java.awt.*;
public class RotatingSquare extends MovingShape{
	
	public RotatingSquare() {
		super();
	}

	/** constuctor to create a square shape
	 */
	public RotatingSquare(int x, int y, int w, int h,  int mw, int mh, Color bc, int pathType, float pen) {
		super(x ,y ,w, h ,mw ,mh ,bc, pathType, pen);
	}
	int degrees = 0;
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(borderColor);
		g2d.setStroke(new BasicStroke(penWidth));
		if (width > height) {
			height = width;
		}	
		if (height > width) {
			width = height;
		}
		
		degrees = (degrees+10)%360;
		g2d.rotate(Math.toRadians(degrees), p.x+width/2, p.y+height/2);
		g2d.drawRect(p.x, p.y, width, height);
		g2d.rotate(Math.toRadians(-degrees), p.x+width/2, p.y+height/2);
		degrees = (degrees+20)%360;
		g2d.rotate(Math.toRadians(degrees), p.x+width/2, p.y+height/2);
		g2d.drawRect(p.x, p.y, width, height);
		g2d.rotate(Math.toRadians(-degrees), p.x+width/2, p.y+height/2);
		degrees = (degrees+30)%360;
		g2d.rotate(Math.toRadians(degrees), p.x+width/2, p.y+height/2);
		g2d.drawRect(p.x, p.y, width, height);
		g2d.rotate(Math.toRadians(-degrees), p.x+width/2, p.y+height/2);
		drawHandles(g);
	}

	/** Returns whether the point is in the square or not
	 * @return true if and only if the point is in the square, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		return (p.x <= mousePt.x && mousePt.x <= (p.x + width + 1)	&&	p.y <= mousePt.y && mousePt.y <= (p.y + height + 1));
	}
}