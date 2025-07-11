package exceptions;

public class Intro {
    public static void main(String[] args) {


        int coffeeAmount = 0;

        if (coffeeAmount < 1) {
            throw new OutOfCoffeeException("Out of coffee brotha");
        }


    }
}
