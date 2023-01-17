public class Math {

    public static void main(String[] args) {
        int sideA = 50;
        int sideB = 40;
        int angle = 30;
        double sinDegree = java.lang.Math.sin(java.lang.Math.toRadians(angle));
        long areaTriangle = (int) java.lang.Math.round(0.5 * sideA * sideB * sinDegree);
        System.out.println("Площадь треугольника со сторонами " + sideA + " и " + sideB + " и углом " + angle + " равна " + areaTriangle);

        int radius = 3;
        double area = java.lang.Math.PI * (int) java.lang.Math.pow(radius, 2);
        long areaCircle = java.lang.Math.round(area);
        System.out.println("Площадь окружности с радиусом " + radius + " равна " + areaCircle);

        int number = 100;
        int randomInt = (int) (java.lang.Math.random() * number);
        System.out.println("Случайное целое число от 0 до 100: " + randomInt);

        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(java.lang.Math.random() * 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}