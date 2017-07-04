package ro.teamnet.zerotohero.oop.project;

import ro.teamnet.zerotohero.oop.project.exceptions.AnimalManancaOmException;
import ro.teamnet.zerotohero.oop.project.interfaces.AngajatZoo;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {
    @Override
    public void mananca(Object obj) {
        if(obj instanceof AngajatZoo)
            throw new AnimalManancaOmException();
        else
            System.out.println("Animalul Feroce mananca");
    }

    @Override
    public void seJoaca() {
        System.out.println("Animalul feroce se joaca");
    }

    @Override
    public void faceBaie() {
        System.out.println("Animalul feroce face baie");
    }

    @Override
    public void doarme() {
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }
}
