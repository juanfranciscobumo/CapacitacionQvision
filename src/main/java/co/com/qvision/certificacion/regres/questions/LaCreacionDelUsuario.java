package co.com.qvision.certificacion.regres.questions;
import static co.com.qvision.certificacion.regres.utils.ObtieneLaFecha.getFechaDelServicio;
import co.com.qvision.certificacion.regres.models.RespuestaCreacionDeUsuario;

import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;


public class LaCreacionDelUsuario {
    private static RespuestaCreacionDeUsuario creacionDeUsuario;

    private LaCreacionDelUsuario() {

    }

    public static Question<String> conNombre() {
        creacionDeUsuario = lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class);
        return actor -> creacionDeUsuario.getNombre();
    }

    public static Question<String> conTrabajo() {
        creacionDeUsuario = lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class);
        return actor -> creacionDeUsuario.getTrabajo();
    }

    public static Question<String> enLaFecha() {
        creacionDeUsuario = lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class);
        return actor -> getFechaDelServicio(creacionDeUsuario.getCreatedAt());
    }
}
