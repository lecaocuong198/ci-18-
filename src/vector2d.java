public class vector2d {
    public double x;
    public double y;
    public vector2d(){
        this(0,0);
    }
    public vector2d(double x,double y){
        this.x=x;
        this.y=y;
    }

    public  void add(double x,double y){
        this.x +=x;
        this.y +=y;
    }

    public void substract(double x,double y){
        this.x -=x;
        this.y -=y;
    }

    public void scale(double rate){
        this.x*=rate;
        this.y*=rate;
    }
    public void set(double x,double y){
        this.x = x;
        this.y = y;

    }
    public vector2d clone(){
        return new vector2d(this.x,this.y);
    }

    public double getLength (){
        return Math.sqrt(x*x+y*y);
    }
    public  void  setLength(double length){
        double oldLength = this.getLength();
        if (oldLength!=0){
            this.x = this.x*length/oldLength;
            this.y = this.y*length/oldLength;
        }
    }
    public double getAngle(){
        return Math.atan(y/x);

    }
    public void setAngle(double angle){
        double length = this.getLength();
        if (length!=0){
            this.x = length*Math.cos(angle);
            this.y = length*Math.sin(angle);
        }
    }

}
