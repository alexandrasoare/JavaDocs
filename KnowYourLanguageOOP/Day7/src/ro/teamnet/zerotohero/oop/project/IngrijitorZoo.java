package ro.teamnet.zerotohero.oop.project;

import ro.teamnet.zerotohero.oop.project.exceptions.AnimalPeCaleDeDisparitieException;
import ro.teamnet.zerotohero.oop.project.interfaces.AngajatZoo;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {
    @Override
    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului");
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException {
        if(animal != null) {
            this.lucreaza(animal);
            animal.faceBaie();
            animal.mananca(mancare);
            animal.seJoaca();
            animal.doarme();
        }

        if(animal instanceof AnimalZooRar){
            if(mancare == null)
                throw new AnimalPeCaleDeDisparitieException();
        }
    }
}
