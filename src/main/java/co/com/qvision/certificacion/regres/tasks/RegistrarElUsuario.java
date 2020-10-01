package co.com.qvision.certificacion.regres.tasks;

import co.com.qvision.certificacion.regres.interactions.Post;
import co.com.qvision.certificacion.regres.models.RegistrarUsuarioModel;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import static co.com.qvision.certificacion.regres.utils.Constantes.RECURSO_CREAR_USUARIO;

public class RegistrarElUsuario implements Task {

    public static final String APLICACION = "application/json; charset=utf-8";

    private final RegistrarUsuarioModel registrarUsuarioModel;

    public RegistrarElUsuario(RegistrarUsuarioModel registrarUsuarioModel) {
        this.registrarUsuarioModel = registrarUsuarioModel;
    }
    @Step("{0} crea un usuario en regres")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(RECURSO_CREAR_USUARIO)
                .with(request -> request.contentType(APLICACION)
                        .body(registrarUsuarioModel)
                        .relaxedHTTPSValidation()
                        .urlEncodingEnabled(true)
                ));
    }

   public static RegistrarElUsuario conLosDatos(RegistrarUsuarioModel registrarUsuarioModel){
        return Tasks.instrumented(RegistrarElUsuario.class, registrarUsuarioModel);

    }
}
