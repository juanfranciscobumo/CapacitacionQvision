package co.com.qvision.certificacion.regres.builders;

import co.com.qvision.certificacion.regres.intefaces.IRespuestaRegistrarUsuario;
import co.com.qvision.certificacion.regres.models.RegistrarUsuarioModel;
import co.com.qvision.certificacion.regres.models.RespuestaCreacionDeUsuario;

import static co.com.qvision.certificacion.regres.utils.ObtenerFecha.getFechaDelServicio;
import static co.com.qvision.certificacion.regres.utils.ObtenerFecha.getFechaDelSistema;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class RespuestaRegistrarUsuarioBuilder implements IRespuestaRegistrarUsuario {
    private String nombre;
    private String trabajo;

    public RespuestaRegistrarUsuarioBuilder(String nombre) {
        this.nombre = nombre;
    }

    public static RespuestaRegistrarUsuarioBuilder laComparacionDelNombre(String nombre) {
        return new RespuestaRegistrarUsuarioBuilder(nombre);
    }

    public Boolean yElTrabajoSonLosEsperados(String trabajo) {
        this.trabajo = trabajo;
        return this.build();
    }

    @Override
    public Boolean build() {
        RegistrarUsuarioModel model = new RegistrarUsuarioModel();
        model.setTrabajo(this.trabajo);
        model.setNombre(this.nombre);

        return lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class).getNombre().equals(this.nombre) &&
                lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class).getTrabajo().equals(this.trabajo)
                && getFechaDelServicio(lastResponse().jsonPath().getObject("", RespuestaCreacionDeUsuario.class).getCreatedAt()).contains(getFechaDelSistema());

    }
}
