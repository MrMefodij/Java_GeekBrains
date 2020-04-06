package Quiz5;

import java.util.Random;

public class Dog extends Animal {
    //бег: кот – 200 м., собака – 500 м.;
    // прыжок: кот – 2 м., собака – 0.5 м.;
    // плавание: кот не умеет плавать, собака – 10 м.
    private static Random random = new Random();

    public Dog (){
        super("undefined",500.,0.5,10);
    }
    public Dog (String _name){
        super(_name,500.,0.5,10);
    }

    public Dog (String _name, double _runDistance, double _jumpHeight, double _swimDistance){
        super(_name, _runDistance, _jumpHeight, _swimDistance);
    }

    public Dog (String _name, boolean rand){
        this.name = _name;
        if (rand){
            double k = 1. + (random.nextInt(100) - 50.)/100.;
            System.out.println(k);
            this.runDistance = 500. * k;
            this.jumpHeight = 0.5 * k;
            this.swimDistance = 10 * k;
        } else {
            this.runDistance = 200.;
            this.jumpHeight = 2.;
            this.swimDistance = 10;
        }

    }

}
