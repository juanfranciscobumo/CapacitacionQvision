package co.com.qvision.certificacion.regres.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObtenerFecha {
    private ObtenerFecha() {

    }

    public static String getFechaDelServicio(String fecha) {

        return fecha.split("T")[0];
    }

    public static String getFechaDelSistema() {

        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }
}
