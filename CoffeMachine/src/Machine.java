public class Machine {

    private int currentWater;
    private static final float MAX_WATER = 1000.00F;
    private float currentCoffee;
    private static final float MAX_COFFEE = 60.00F;
    private static final float NORM_STRONG_COFFEE = 20.00F;
    private Coffee coffee;
    public String residueCoffee() {
        return "Кофе осталось " + currentCoffee + " г ";
    }
    public String residueWater() {
        return "Воды осталось " + currentWater + " мл ";
    }
    public void fillWater(int addWater) {
        if (addWater + currentWater > MAX_WATER) {
            System.out.println("Нельзя залить столько воды");
        }
        else {
            currentWater += addWater;
        }
    }
    public void fillCoffee(float addCoffee, Coffee coffee) {
        if (addCoffee + currentCoffee > MAX_COFFEE) {
            System.out.println("Нельзя засыпать столько кофе");
        }
        else {
            currentCoffee += addCoffee;
            this.coffee = coffee;
        }
    }
    public void makeCoffee(float strength, int volCup) {
        if(strength > 0 && strength <= 1) {
            if (volCup > currentWater) {
                System.out.println("Долейте воды");
            }
            else {
                if (NORM_STRONG_COFFEE * strength <= currentCoffee) {
                    currentWater -= volCup;
                    currentCoffee -= NORM_STRONG_COFFEE*strength;
                    System.out.println("Готовлю " + coffee.getCoffeeName() + " объемом " + volCup + " мл, крепость " + strength);
                }
                else {
                    System.out.println("Досыпьте кофе");
                }
            }
        }
        else {
            System.out.println("Крепость напитка задается от 0 до 1");
        }
    }
}

