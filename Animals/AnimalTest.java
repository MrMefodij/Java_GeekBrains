package Java_GeekBrains.Animals;

public class AnimalTest {
    public static void main(String[] args) {
        // swim distance: -1.0  mean "cats can't swim"
        Bowl bowl1 = new Bowl(50, 100);
        bowl1.replenishBowl(7);

        Cat[] cats = new Cat[10];
        for (int i =0 ; i<cats.length; i++){
            cats[i] = new Cat("Cat"+(i+1),true); //создаем массив котов с рандомизироваными парраметрами
            //cats[i].animalInfo();
        }

        for (int i =0 ; i<cats.length; i++){
            cats[i].eat(bowl1);
            bowl1.getBowlFullness();
        }
        bowl1.replenishBowl(70);

        for (int i =0 ; i<cats.length; i++){
            cats[i].eat(bowl1);
            bowl1.getBowlFullness();
        }


    }
}
