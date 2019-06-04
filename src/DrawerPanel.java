import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DrawerPanel extends JPanel {
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setDoubleBuffered(true);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public void addRectangle() {
        Rect rect = new Rect();
        rect.randomFill();
        shapes.add(rect);
    }

    public void addCircle() {
        Circle circle = new Circle();
        circle.randomFill();
        shapes.add(circle);
    }
    public void addTri(){
        Tri tri = new Tri();
        tri.randomFill();
        shapes.add(tri);
    }
}

class Shape {
    public int x, y;
    public int width, height;
    public int[] xpoints = new int[3];
    public int[] ypoints = new int[xpoints.length];
    public int speed = +2;
    public Color color = Color.RED;

    public int randint(int min, int max) {
        Random rnd = new Random();
        return min + rnd.nextInt(max - min);
    }

    public Color randomColor() {
        Color[] colors = new Color[]{new Color(0, 255, 0), new Color(0, 255, 255), new Color(0, 169, 255),
                new Color(106, 0, 255), new Color(200, 50, 255), new Color(255, 60, 200), new Color(255, 80, 80)};
        return colors[randint(0, colors.length)];
    }

    public void randomFill() {
        this.x = randint(20, 380);
        this.y = randint(20, 180);
        this.width = randint(10, 150);
        this.height = randint(10, 150);
        this.xpoints[0] = randint(10, 300);
        this.xpoints[1] = randint(50, 350);
        this.xpoints[2] = randint(25, 250);
        this.ypoints[0] = randint(10, 300);
        this.ypoints[1] = randint(50, 350);
        this.ypoints[2] = randint(25, 250);
        this.color = randomColor();
    }

    public void draw(Graphics g) {
    }
}


class Rect extends Shape {
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
class Tri extends Shape {
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(xpoints, ypoints, 3);
    }
}


class Circle extends Shape {
    @Override
    public void randomFill() {
        super.randomFill();
        this.width = this.height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
}