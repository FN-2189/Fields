import javax.swing.*;

public class Frame extends JFrame {
    public Frame(String title){
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ElectricField field = new ElectricField(20, 15,
                new Charge(30, 3, 3),
                new Charge(30, 3, 11),
                new Charge(-50, 15, 7));
        this.add(field.getVectorField());
        this.pack();

        this.setVisible(true);

        field.getVectorField().repaint();
    }
}
