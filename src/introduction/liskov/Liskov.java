package introduction.liskov;

public class Liskov {

    public void example() {
        Shelter shelter = new Shelter();

        Animal animal = new Animal();
        Bird bird = new Bird();

        shelter.protect(animal);
        shelter.protect(bird);
    }
}
