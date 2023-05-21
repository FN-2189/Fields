public class Vector2 {
    public double x, y;
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2(){
        this.x = 0;
        this.y = 0;
    }

    public static Vector2 add(Vector2 a, Vector2 b){
        return new Vector2(a.x + b.x, a.y + b.y);
    }

    public static Vector2 scale(Vector2 v, double scalar){
        return new Vector2(v.x * scalar, v.y * scalar);
    }

    public static Vector2 direction(Vector2 from, Vector2 to){
        return normalize(add(to, negate(from)));
    }

    public static Vector2 negate(Vector2 v){
        return scale(v, -1);
    }

    public static Vector2 normalize(Vector2 v){
        return scale(v, 1/magnitude(v));
    }

    public static double magnitude(Vector2 v){
        return Math.sqrt(v.x * v.x + v.y * v.y);
    }

    public static double distance(Vector2 a, Vector2 b){
        return magnitude(add(a, negate(b)));
    }

    public static boolean equal(Vector2 a, Vector2 b){
        return a.x == b.x && a.y == b.y;
    }
}
