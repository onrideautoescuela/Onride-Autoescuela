package Main;

/**
 * La clase ErrorBaseDatos permite alterar el mensaje cuando se produce una
 * excepción en la BBDD.
 *
 * @author Felipe Vargas Contreras
 * @version v1.0 (2022/05/19)
 */
public class ErrorBaseDatos extends Exception {

    public ErrorBaseDatos(String arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

}
