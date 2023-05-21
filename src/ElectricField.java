import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElectricField {
    //private static final double EPSILON = 8.854187812813e-12;
    private static final double EPSILON = 1; // 1 for testing

    private VectorField vectorField;
    private List<Charge> charges;

    public ElectricField(int width, int height, Charge... charges){
        this.charges = new ArrayList<>();
        this.charges.addAll(Arrays.asList(charges));

        vectorField = new VectorField(width, height);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(chargeAt(j, i)) {
                    vectorField.setVect(j, i, new Vector2());
                } else {
                    Vector2 vect = new Vector2(0, 0);
                    for (Charge q : charges) {
                        double mag = magnitude(q.getCharge(), Vector2.distance(q.getPos(), new Vector2(j, i)));
                        Vector2 e = Vector2.scale(Vector2.direction(q.getPos(), new Vector2(j, i)), mag);
                        vect = Vector2.add(vect, e);
                    }

                    vectorField.setVect(j, i, vect);
                }

            }
        }
    }

    private double magnitude(double charge, double distance){
        return charge/(4 * Math.PI * EPSILON * distance * distance);
    }

    public VectorField getVectorField(){
        return vectorField;
    }

    public boolean chargeAt(int x, int y){
        for (Charge q : charges){
            if(Vector2.equal(q.getPos(), new Vector2(x, y))) return true;
        }

        return false;
    }


}
