public class Charge {
    private double charge;
    private Vector2 pos;

    public Charge(double charge, int x, int y){
        this.charge = charge;
        this.pos = new Vector2();
        this.pos.x = x;
        this.pos.y = y;
    }

    public double getCharge() {
        return charge;
    }

    public Vector2 getPos() {
        return pos;
    }
}
