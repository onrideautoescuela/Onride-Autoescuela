package ClasesTablas;

import java.time.LocalDate;

/**
 * La clase Examen determina los campos requeridos para contruir un objeto de
 * tipo Examen.
 *
 * @author Hugo Pozuelo Martinez
 * @author Felipe Vargas Contreras
 * @version v1.0 (2022/05/19)
 */
public class Examen {

    private int idExamen;
    private LocalDate fecha;
    private boolean aprobado;

    public Examen(int idExamen, LocalDate fecha, boolean aprobado) {
        this.idExamen = idExamen;
        this.fecha = fecha;
        this.aprobado = aprobado;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    @Override
    public String toString() {
        return "Identificador del examen: " + idExamen
                + "\nFecha de realización: " + fecha
                + "\n¿Aprobado?" + aprobado;
    }

}
