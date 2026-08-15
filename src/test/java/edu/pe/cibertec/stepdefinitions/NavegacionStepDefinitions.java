package edu.pe.cibertuc.stepdefinitions;

import edu.pe.cibertuc.questions.OpcionVisible;
import edu.pe.cibertuc.tasks.IngresarASeccion;
import edu.pe.cibertuc.userinterface.ApiDemosScreen;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.appium.AndroidDriverActions;
import net.serenitybdd.screenplay.questions.Visibility;

import static net.serenitybdd.screenplay.GivenThat.seeThat;
import static org.hamcrest.CoreMatchers.is;

public class NavegacionStepDefinitions {

    @Before
    public void preparaEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que {word} abre la aplicacion ApiDemos")
    public void que_abre_la_aplicacion_apidemos(String actor) {
        OnStage.theActorCalled(actor);
    }

    @Cuando("ingresa a la seccion {string}")
    public void ingresa_a_la_seccion(String seccion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarASeccion.llamada(seccion)
        );
    }

    @Y("ingresa a la seccion {string}")
    public void y_ingresa_a_la_seccion(String seccion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                IngresarASeccion.llamada(seccion)
        );
    }

    @Entonces("deberia visualizar la opcion {string}")
    public void deberia_visualizar_la_opcion(String opcion) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(OpcionVisible.llamada(opcion), is(true))
        );
    }

    @Cuando("regresa a la pantalla anterior")
    public void regresa_a_la_pantalla_anterior() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AndroidDriverActions.pressBack()
        );
    }

    @Entonces("la opcion {string} deberia estar deshabilitada")
    public void la_opcion_deberia_estar_deshabilitada(String opcion) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Visibility.of(ApiDemosScreen.opcionMenu(opcion)), is(false))
        );
    }

    @Cuando("activa la casilla {string}")
    public void activa_la_casilla(String opcion) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ApiDemosScreen.opcionMenu(opcion))
        );
    }

    @Entonces("la opcion {string} deberia estar habilitada")
    public void la_opcion_deberia_estar_habilitada(String opcion) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Visibility.of(ApiDemosScreen.opcionMenu(opcion)), is(true))
        );
    }

    @Y("escribe {string} en el campo del dialogo")
    public void escribe_en_el_campo_del_dialogo(String texto) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Enter.theValue(texto).into(ApiDemosScreen.campoDialogo())
        );
    }

    @Y("confirma el dialogo")
    public void confirma_el_dialogo() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(ApiDemosScreen.botonAceptarDialogo())
        );
    }

    @Entonces("el campo del dialogo deberia contener {string}")
    public void el_campo_del_dialogo_deberia_contener(String textoEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(net.serenitybdd.screenplay.questions.Text.of(ApiDemosScreen.campoDialogo()), org.hamcrest.CoreMatchers.equalTo(textoEsperado))
        );
    }
}