package co.com.qvision.certificacion.regres.builders;


import co.com.qvision.certificacion.regres.intefaces.IBuilderIniciarSesion;
import co.com.qvision.certificacion.regres.models.IniciarSesionModel;
import co.com.qvision.certificacion.regres.utils.LeerExcel;

public class IniciarSesionBuilder implements IBuilderIniciarSesion {
    private String email;
    public IniciarSesionBuilder(String email) {
        this.email = email;
    }

    public static IniciarSesionBuilder email(String email) {
        return new IniciarSesionBuilder(email);
    }
    public IniciarSesionModel yClave() {
        return this.build();
    }

    @Override
    public IniciarSesionModel build() {
        IniciarSesionModel iniciarSesion = new IniciarSesionModel();
        iniciarSesion.setContrasena(LeerExcel.getClave(this.email));
        iniciarSesion.setEmail(this.email);
        return iniciarSesion;
    }
}
