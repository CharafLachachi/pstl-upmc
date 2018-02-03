package arrows;

import org.piccolo2d.PNode;
import org.piccolo2d.nodes.PPath;

import java.awt.*;
import java.awt.geom.Point2D;

public class ParrowUses extends Parrow{
    public ParrowUses(Point2D from, Point2D to){
        super(from,to);
        TriangleHollow head = new TriangleHollow();

        PPath line=PPath.createLine(from.getX(),from.getY(),to.getX(),to.getY());
        line.setStrokePaint(Color.red);
        double theta=Math.atan2(to.getY()-from.getY(),to.getX()-from.getX())+Math.toRadians(90);
        head.translate(to.getX(),to.getY());
        head.rotate(theta);

        addChild(line);
        addChild(head);

    }

    public ParrowUses(PNode from, PNode to){
        this(from.getBounds().getCenter2D(),to.getBounds().getCenter2D());
        this.from=from;
        this.to=to;
    }

    @Override
    public Parrow redraw() {
        removeAllChildren();
        return new ParrowUses(from,to);
    }

}
