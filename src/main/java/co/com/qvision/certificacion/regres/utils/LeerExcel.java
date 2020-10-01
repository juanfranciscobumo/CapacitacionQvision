package co.com.qvision.certificacion.regres.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import static co.com.qvision.certificacion.regres.utils.Constantes.QUERY;
import static co.com.qvision.certificacion.regres.utils.Constantes.RUTA_DATA;

public class LeerExcel {
    private static Fillo fillo = new Fillo();
    private static String clave;
    private static final String VCLAVE = "CLAVE";

    private LeerExcel() {

    }

    public static String getClave(String email) {
        try {
            Connection connection = fillo.getConnection(RUTA_DATA);
            Recordset recordset = connection.executeQuery(String.format(QUERY, email));
            while (recordset.next()) {
                clave = recordset.getField(VCLAVE);
            }
            recordset.close();
            connection.close();
        } catch (FilloException e) {
            e.getMessage();
        }
        return clave;
    }
}
