package javaSemester_Projects.lab07;

import java.util.ArrayList;

/**
 * Interface Animal. with feed methode
 */
   interface Animal {
    void feed();
}

/**
 * This class represents a Tiger, implementing animal
 */
class Tiger implements Animal {
    /**
     * Feeds the tiger.
     */

    public void feed() {
        System.out.println(" Crunch crunch, roaaaar!");
    }
}

/**
 * This class represents a Pig, a type of Animal.
 */
class Pig implements Animal {
    /**
     * Feeds the pig.
     */

    public void feed() {
        System.out.println(" Munch munch, oink!");
    }
}
public class AnimalZoo {
    /**
     * @param animals
     * @param <T> extends Animal sodass T nur für animals beschränkt ist, bzw nur klass
     *           die animals implemtieren
     */
    public static < T extends Animal > void feed(ArrayList<T> animals){

        for (T animal: animals ){
            animal.feed();

        }
    }

    public static void main(String[] args) {
        ArrayList<Tiger> tigers = new ArrayList<>();
        tigers.add(new Tiger());
        tigers.add(new Tiger());

        ArrayList<Pig> pigs = new ArrayList<>();
        pigs.add(new Pig());
        pigs.add(new Pig());



        feed(tigers);
        feed(pigs);


    }
}
