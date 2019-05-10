public class position{

    public vector2d position;
    public int width;
    public int height;

    public position() {
        this(new vector2d(0, 0), 1, 1);
    }

    public position(double x, double y, int width, int height) {
        this(new vector2d(x, y), width, height);
    }

    public position(vector2d position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }


    public boolean intersects(position other) {
        // TODO: 1. remove default return statement and fill logic check intersects 'this' and 'other'
        int a = (int) ((this.position.x + this.width/2)-(other.position.x + other.width/2));
        int b = (int) ((this.position.y + this.height/2)-(other.position.y + other.height/2));
        if (a < 0)
            a = a*(-1);
        if (b < 0)
            b = b*(-1);
        if (a <= (this.width + other.width)/2 && b <= (this.height+ other.height)/2){
            return true;
        }
        return false;
    }
    }