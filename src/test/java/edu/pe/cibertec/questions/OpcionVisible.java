package edu.pe.cibertec.questions;

import edu.pe.cibertec.userinterface.ApiDemosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class OpcionVisible implements Question<Boolean> {

    private final String nombre;

    public OpcionVisible(String nombre) {
        this.nombre = nombre;
    }

    public static OpcionVisible llamada(String nombre) {
        return new OpcionVisible(nombre);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Visibility.of(ApiDemosScreen.opcionMenu(nombre))
                .answeredBy(actor);
    }
}
