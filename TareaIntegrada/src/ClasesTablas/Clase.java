package ClasesTablas;

import java.time.LocalDate;

/**
 * La clase Clase determina los campos requeridos para contruir un objeto de
 * tipo Clase.
 *
 * @author Hugo Pozuelo Martinez
 * @author Felipe Vargas Contreras
 * @version v1.0 (2022/05/19)
 */
public class Clase {

    private int id_clase;
    private String dniAlumno;
    private String dniTrabajador;
    private LocalDate fecha;
    private String matricula;

    public Clase(int id_clase, String dniAlumno, String dniTrabajador, LocalDate fecha, String matricula) {
        this.id_clase = id_clase;
        this.dniAlumno = dniAlumno;
        this.dniTrabajador = dniTrabajador;
        this.fecha = fecha;
        this.matricula = matricula;
    }

    public int getId_clase() {
        return id_clase;
    }

    public String getDniAlumno() {
        return dniAlumno;
    }

    public String getDniTrabajador() {
        return dniTrabajador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "[CLASE]-+-+-+-+-+-+-+-+-+-+-+-+\n"
                + "Identificador de la clase: " + id_clase
                + "\nDNI del alumno: " + dniAlumno
                + "\nDNI del instructor: " + dniTrabajador
                + "\nFecha de realización: " + fecha
                + "\nMatrícula del vehículo: " + matricula
                + "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
    }

}
