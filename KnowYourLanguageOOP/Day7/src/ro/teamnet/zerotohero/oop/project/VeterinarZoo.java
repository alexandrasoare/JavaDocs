package ro.teamnet.zerotohero.oop.project;

import ro.teamnet.zerotohero.oop.project.interfaces.AngajatZoo;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {
    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal");
        if(animal instanceof AnimalZooFeroce)
            animal.faceBaie();
    }
}
