package edu.pe.cibertec.tasks;

import edu.pe.cibertec.userinterface.ApiDemosScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class IngresarASeccion implements Task {
    private  final String seccion;

    public IngresarASeccion(String seccion) {
        this.seccion = seccion;
    }

    public static IngresarASeccion llamada(String seccion) {
        return new IngresarASeccion(seccion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ApiDemosScreen.opcionMenu(seccion))
        );
    }
}
