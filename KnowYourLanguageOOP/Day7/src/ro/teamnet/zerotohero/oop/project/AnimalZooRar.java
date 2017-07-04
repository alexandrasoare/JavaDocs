package ro.teamnet.zerotohero.oop.project;

import ro.teamnet.zerotohero.oop.project.exceptions.AnimalManancaOmException;
import ro.teamnet.zerotohero.oop.project.interfaces.AngajatZoo;

/**
 * Created by Alexandra.Soare on 7/4/2017.
 */
public class AnimalZooRar extends Animal {
    String nume;
    String numeleTariiDeOrigine;

    public AnimalZooRar() {}

    public AnimalZooRar(String nume) {
        this.nume = nume;
    }

    public AnimalZooRar(String nume, String numeleTariiDeOrigine) {
        this.nume = nume;
        this.numeleTariiDeOrigine = numeleTariiDeOrigine;
    }

    @Override
    public void faceBaie() {
        System.out.println("AnimalulZooRar face baie");
    }

    @Override
    public void seJoaca() {
        System.out.println("AnimalulZooRar se joaca");
        super.doarme();
    }

    @Override
    public void mananca(Object obj) {
        if(obj instanceof AngajatZoo)
            throw new AnimalManancaOmException();
        else
            System.out.println("AnimalZooRar mananca");
    }
}
