package co.com.qvision.certificacion.regres.tasks;

import co.com.qvision.certificacion.regres.interactions.Post;
import co.com.qvision.certificacion.regres.models.IniciaSesionModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;


import static co.com.qvision.certificacion.regres.utils.Constantes.RECURSO_INICIAR_SESION;

public class IniciaSesion implements Task {

    public static final String APLICACION = "application/json; charset=utf-8";
    public static final String ACCEPT = "*/*";

    private final IniciaSesionModel iniciarSesionModel;

    public IniciaSesion(IniciaSesionModel iniciarSesionModel) {
        this.iniciarSesionModel = iniciarSesionModel;
    }

    @Step("{0} inicia sesi�n en regress")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to(RECURSO_INICIAR_SESION)
                .with(request -> request.contentType(APLICACION)
                        .accept(ACCEPT)
                        .body(iniciarSesionModel)
                        .relaxedHTTPSValidation()
                        .urlEncodingEnabled(false)
                ));
    }

   public static IniciaSesion conLosDatos(IniciaSesionModel iniciarSesionModel){
        return Tasks.instrumented(IniciaSesion.class, iniciarSesionModel);

    }
}
