public class CoffeeMaker {

    public static void main(String[] args) {

        Coffee tastyCoffee = new Coffee("tasty");
        Machine deLonghi = new Machine();
        deLonghi.makeCoffee(0.8f,200);
        deLonghi.fillWater(900);
        deLonghi.makeCoffee(0.8f,200);
        deLonghi.fillCoffee(60f,tastyCoffee);
        deLonghi.makeCoffee(0.8f,200);
        System.out.println(deLonghi.residueWater());
        System.out.println(deLonghi.residueCoffee());
    }

}
