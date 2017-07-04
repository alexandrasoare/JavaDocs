package ro.teamnet.zerotohero.oop.project;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
abstract public class Animal {
    abstract public void mananca(Object obj);
    abstract public void seJoaca();
    abstract public void faceBaie();

    public Animal() {
        System.out.println("Animal nou");
    }

    public void doarme() {
        System.out.println("Animalul doarme");
    }
}
