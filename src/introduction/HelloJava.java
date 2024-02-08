package introduction;

import java.util.Arrays;

public class HelloJava {

    public void run() {

        variableTypes();

        flowControlConditionals();

        flowControlLoops();

        flowControlStreams();

        classesAndObjects();

        /**
         * Crear un algoritmo que te calcule los N primeros números
         * de la serie de Fibonacci.
         * fibonacci(4) -> int[] {0, 1, 1, 2}
         * fibonacci(8) -> int[] {0, 1, 1, 2, 3, 5, 8, 13}
         */
    }

    private void classesAndObjects() {
        System.out.println("");
        System.out.println("Clases y objetos");
        System.out.println("");

        try {
            Chair myChair = new Chair(
                    5,
                    "leather",
                    "black",
                    1.50,
                    true
            );

            System.out.println("My chair color is " + myChair.color());
            myChair.paint("white");
            System.out.println("My chair color is " + myChair.color());

            System.out.println("My chair has " + myChair.numberOfLegs() + " legs.");
            myChair.removeLeg();
            System.out.println("My chair has " + myChair.numberOfLegs() + " legs.");
            myChair.removeLeg();
            System.out.println("My chair has " + myChair.numberOfLegs() + " legs.");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void flowControlStreams() {
        System.out.println("");
        System.out.println("Control de flujo: Streams");
        System.out.println("");

        int[] fibonacci = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};

        int sumOfFibonacciNumbers = Arrays.stream(fibonacci)
                .map(fibonacciNumber -> fibonacciNumber + 1)
                .map(fibonacciNumber -> fibonacciNumber * 2)
                .sum();

        System.out.println(sumOfFibonacciNumbers);
    }

    private void flowControlLoops() {
        System.out.println("");
        System.out.println("Control de flujo: Bucles");
        System.out.println("");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i < 10);

        int[] fibonacci = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};

        for (int n = 0; n < 10; n++) {
            System.out.println(fibonacci[n]);
        }

        int sumOfFibonacciNumbers = 0;
        for (int fibonacciNumber : fibonacci) {
            fibonacciNumber += 1;
            fibonacciNumber *= 2;

            sumOfFibonacciNumbers += fibonacciNumber;
        }
        System.out.println(sumOfFibonacciNumbers);
    }

    private void flowControlConditionals() {
        System.out.println("");
        System.out.println("Control de flujo: Condicionales");
        System.out.println("");

        boolean isMonday = false;

        if (! isMonday) {
            System.out.println("¡Que empiece bien la semana!");
        }

        String weekDay = "Friday";

        if (weekDay == "Wednesday") {
            System.out.println("Bienvenidos al miércoles.");
        }

        switch (weekDay) {
            case "Monday" -> System.out.println("Lunes es complicado.");
            case "Tuesday" -> System.out.println("Martes se hace largo.");
            case "Wednesday" -> System.out.println("Ya vamos por la mitad.");
            case "Thursday" -> System.out.println("Juernes ha llegado.");
            case "Friday" -> System.out.println("Es viernes y el cuerpo lo sabe.");
            case "Saturday" -> System.out.println("Fiesta a tope.");
            case "Sunday" -> System.out.println("Que rápido pasa el fin de semana.");
            default -> System.out.println("Te has pasado la semana.");
        }
    }

    private void variableTypes() {
        System.out.println("");
        System.out.println("Tipos de variable");
        System.out.println("");

        String greet = "Hola";
        System.out.println(greet);

        String farewell = "Adios";
        System.out.println(farewell);

        int attendants = 14;
        System.out.println(attendants);

        double score = 91.8;
        System.out.println(score);

        float height = 15.82f;
        System.out.println(height);

        boolean isMonday = false;
        System.out.println(isMonday);

        char a = 'a';

        System.out.println(a);
    }
}
