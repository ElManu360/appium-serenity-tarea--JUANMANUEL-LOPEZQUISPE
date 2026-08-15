package edu.pe.cibertuc.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ApiDemosScreen {

    private ApiDemosScreen() {
    }

    public static Target opcionMenu(String nombre) {

        return Target.the("opcion de menu '" + nombre + "'")
                .located(By.xpath("//android.widget.TextView[@text='" + nombre + "' or @content-desc='" + nombre + "']"));
    }

    public static Target campoDialogo() {

        return Target.the("campo de texto del dialogo")
                .located(By.xpath("//android.widget.EditText"));
    }

    public static Target botonAceptarDialogo() {

        return Target.the("boton aceptar del dialogo")
                .located(By.xpath("//android.widget.Button[@text='OK' or @text='Aceptar']"));
    }
}