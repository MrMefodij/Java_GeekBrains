package Quiz5;

import java.util.Random;
import java.util.Scanner;

public class Cat extends Animal {
    private static Random random = new Random();
    private double appetite;
    private boolean satiety;

    public Cat(){
        super("undefined",200.,2.,-1);
        this.appetite = 10.;
        this.satiety = false;
    }

    public Cat (String _name){
        super(_name,200.,2.,-1);
        this.appetite = 10.;
        this.satiety = false;
    }

    public Cat (String _name, double _runDistance, double _jumpHeight, double _swimDistance){
        this.name = _name;
        this.runDistance = _runDistance;
        this.jumpHeight = _jumpHeight;
        if (_swimDistance > 0 && checkSwimCat()){
            this.swimDistance = _swimDistance;
        } else {
            this.swimDistance = -1;
        }
        this.appetite = 10.;
        this.satiety = false;
    }

    public Cat (String _name, double _runDistance, double _jumpHeight, double _swimDistance, double _appetite ){
        this.name = _name;
        this.runDistance = _runDistance;
        this.jumpHeight = _jumpHeight;
        if (_swimDistance > 0 && checkSwimCat()){
            this.swimDistance = _swimDistance;
        } else {
            this.swimDistance = -1;
        }
        this.appetite = _appetite;
        this.satiety = false;
    }

    public Cat (String _name, boolean rand){
        this.name = _name;
        if (rand){
            double k = 1. + (random.nextInt(100) - 50.)/100.;
            //System.out.println(k);
            this.runDistance = 200. * k;
            this.jumpHeight = 2. * k;
            this.appetite = 10. * k;
        } else {
            this.runDistance = 200.;
            this.jumpHeight = 2.;
            this.appetite = 10.;
        }
        this.satiety = false;
        this.swimDistance = -1;
    }

    public void eat(Bowl bowl){
        System.out.println("Cat " + this.name + " trying to eat from the bowl. ");
        if (!this.satiety) {
            if (bowl.enoughFoodInBowl(this.appetite, this.name)) {
                bowl.getFood(this.appetite);
                this.satiety = true;
                this.getCatSatiety();
            } else {
                this.getCatSatiety();
            }
        } else {
            System.out.println(" But cat " + this.name + " is not hungry.");
        }
    }

    public void getCatSatiety(){
        System.out.println("Cat " + this.name + " satiety is " + this.satiety);
    }

    private static boolean checkSwimCat(){
        boolean result = false;
        System.out.println("Usually cats do not like to swim, but some of them is really good in swimming." +
                "\nCan that cat swim? (yes/no)");
        Scanner userInput = new Scanner(System.in);
        String answer  = userInput.nextLine();
        switch(answer){
            case "yes":
                result = true;
                break;
            case "no":
                result = false;
                break;
            default:
            System.out.println("Answer should be \"yes\" or \"no\"\n I will recognize it like \"no\" (default).");
        }
        return result;
    }
    @Override
    public void animalInfo(){
        System.out.println("Animal: " + this.name + " run distance: " + this.runDistance
                + " jump height: " + this.jumpHeight + " swim distance: "+ this.swimDistance + " appetite: " + this.appetite
                + " satiety: " + this.satiety);
    }

}
