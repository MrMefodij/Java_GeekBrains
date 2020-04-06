package Quiz5;

public class Bowl {
    double capacity;
    double fullness;


    public Bowl(){
        this.capacity = 10;
        this.fullness = 0;
    }

    public Bowl(double _capacity){
        this.capacity = _capacity;
        this.fullness = 0;
    }

    public Bowl(double _capacity, double _fullness){
        this.capacity = _capacity;
        if (_capacity > fullness) {
            this.fullness = _fullness;
        } else {
            this.fullness = _capacity;
        }
    }

    public void getBowlFullness(){
        System.out.println("Bows capacity is: " + this.capacity + " fullness is: " + this.fullness);
    }

    public void replenishBowl(){
        this.fullness = this.capacity;
    }

    public void replenishBowl(double _food){
        if ((_food  + this.fullness)> this.capacity ){
            System.out.println("Capacity of this bowl is " + this.capacity +". Bowl fullness was: " + this.fullness + ", you can't overfill it.");
            this.fullness = this.capacity;
            System.out.println("Bowl status is:");
            this.getBowlFullness();
        } else {
            this.fullness += _food;
            System.out.println("The bowl was replenish. Bowl status is:");
            this.getBowlFullness();
        }
    }

    public boolean enoughFoodInBowl(double food, String cat){
        boolean result = false;
        if (this.fullness > food){
            result = true;
        } else {
            System.out.println("Cat " + cat + "is hungry. It's not enough food itn the bowl, please refill it." );
        }
        return result;
    }

    public void getFood(double food){
        this.fullness -= food;
    }

}
