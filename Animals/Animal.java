package Quiz5;

public class Animal implements AnimalTemplate {
    protected String name;
    protected double runDistance;
    protected double jumpHeight;
    protected double swimDistance;


    public Animal(){ this.name ="undefined"; }

    public Animal(String _name , double _runDistance, double _jumpHeight, double _swimDistance){
        this.name = _name;
        this.runDistance = _runDistance;
        this.jumpHeight = _jumpHeight;
        this.swimDistance = _swimDistance;
    }

    public void animalInfo() {
        System.out.println("Animal: " + this.name + " run distance: " + this.runDistance
        + " jump height: " + this.jumpHeight + " swim distance: "+ this.swimDistance);
    }

    public void run(double _distance){
        boolean result = false;
        if (this.runDistance >= _distance && _distance>=0) {
            result = true;
        }
        System.out.println(this.name + " run result: " + result);
    }

    public void swim(double _distance ){
        boolean result = false;
        if (this.swimDistance >= _distance && _distance>=0){
            result = true;
        }
        System.out.println(this.name + " swim result: " + result);
    }

    public void jump(double _height){
        boolean result = false;
        if (this.jumpHeight >= _height && _height>0){
            result = true;
        }
        System.out.println(this.name + " jump result: " + result);
    }
}
