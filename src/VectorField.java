import javax.swing.*;
import java.awt.*;

public class VectorField extends Panel {
    public static final int FRAGMENT_SIZE = 50;
    public static double LENGTH_MULTIPLIER = 50;
    public static double LENGTH_MULTIPLIER_DIR_ONLY = 20;

    private Vector2[][] vectors;
    private DispMode mode = DispMode.FULL;

    public VectorField(int width, int height){
        this.setPreferredSize(new Dimension(width * FRAGMENT_SIZE + FRAGMENT_SIZE/2, height * FRAGMENT_SIZE + 10));
        vectors = new Vector2[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                vectors[i][j] = new Vector2();
            }
        }
        repaint();
    }

    public void setVect(int x, int y, Vector2 v){
        vectors[y][x].x = v.x;
        vectors[y][x].y = v.y;
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < vectors.length; i++) {
            for (int j = 0; j < vectors[0].length; j++) {
                int x = FRAGMENT_SIZE/2 + j * FRAGMENT_SIZE;
                int y = FRAGMENT_SIZE/2 + i * FRAGMENT_SIZE + 10; // offset of 10 to account for navbar
                g2.setStroke(new BasicStroke(2));
                g2.setColor(Color.GREEN);
                if(mode == DispMode.FULL)
                    g2.drawLine(x, y, x + (int)(vectors[i][j].x * LENGTH_MULTIPLIER), y + (int)(vectors[i][j].y * LENGTH_MULTIPLIER));
                else if(mode == DispMode.DIR_ONLY){
                    g2.drawLine(x, y, x + (int)(Vector2.normalize(vectors[i][j]).x * LENGTH_MULTIPLIER_DIR_ONLY), y + (int)(Vector2.normalize(vectors[i][j]).y * LENGTH_MULTIPLIER_DIR_ONLY));
                }

                g2.setColor(Color.RED);
                g2.drawLine(x, y, x, y);
            }
        }

    }

}
