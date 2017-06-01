/*
 *	===============================================================================
 *	Angelo Terminez (ater906)
 *	MovingSquare.java : A shape that is a Square.
 *	The square has 4 handles shown when it is selected (by clicking on it).
 *	Side lengths of square dependent which of width or height is set larger
 *	===============================================================================
 */
import java.awt.*;
public class MovingSquare extends MovingShape{
	
	public MovingSquare() {
		super();
	}

	/** constuctor to create a square shape
	 */
	public MovingSquare(int x, int y, int w, int h,  int mw, int mh, Color bc, int pathType, float pen) {
		super(x ,y ,w, h ,mw ,mh ,bc, pathType, pen);
	}
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaint(borderColor);
		g2d.setStroke(new BasicStroke(penWidth));
		if (width > height){
			height = width;
		}
		if (height > width){
			width = height;
		}
		g2d.drawRect(p.x, p.y, width, height);
		drawHandles(g);
	}

	/** Returns whether the point is in the square or not
	 * @return true if and only if the point is in the square, false otherwise.
	 */
	public boolean contains(Point mousePt) {
		return (p.x <= mousePt.x && mousePt.x <= (p.x + width + 1)	&&	p.y <= mousePt.y && mousePt.y <= (p.y + height + 1));
	}
}
