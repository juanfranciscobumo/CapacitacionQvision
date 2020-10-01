package co.com.qvision.certificacion.regres.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.qvision.certificacion.regres.builders.RespuestaRegistrarUsuarioBuilder.laComparacionDelNombre;

@Subject("Se compara la respuesta del servicio con los datos esperados")
public class LaCreacionDelUsuario {
    private LaCreacionDelUsuario() {

    }

    public static Question<Boolean> fueCorrecta(String nombre, String trabajo) {
        return actor -> laComparacionDelNombre(nombre).yElTrabajoSonLosEsperados(trabajo);
    }
}
