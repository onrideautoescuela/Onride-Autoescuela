package ClasesTablas;

import java.time.LocalDate;

/**
 * La clase Practico (extends Examen) determina los campos requeridos para
 * contruir un objeto de tipo Practico.
 *
 * @author Hugo Pozuelo Martinez
 * @author Felipe Vargas Contreras
 * @version v1.0 (2022/05/19)
 */
public class Practico extends Examen {

    private int leves;
    private int deficientes;
    private int graves;
    private String matricula;
    private String dniTrabajador;

    public Practico(int idExamen, LocalDate fecha, boolean aprobado, int leves, int deficientes, int graves, String matricula, String dniTrabajador) {
        super(idExamen, fecha, aprobado);
        this.leves = leves;
        this.deficientes = deficientes;
        this.graves = graves;
        this.matricula = matricula;
        this.dniTrabajador = dniTrabajador;
    }

    public int getLeves() {
        return leves;
    }

    public int getDeficientes() {
        return deficientes;
    }

    public int getGraves() {
        return graves;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getDniTrabajador() {
        return dniTrabajador;
    }

    @Override
    public boolean isAprobado() {
        return super.isAprobado(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDate getFecha() {
        return super.getFecha(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdExamen() {
        return super.getIdExamen(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "[EXAMEN PRÁCTICO]-+-+-+-+-+-+-+\n"
                + super.toString()
                + "\nCantidad de faltas leves: " + leves
                + "\nCantidad de faltas deficientes: " + deficientes
                + "\nCantidad de faltas graves: " + graves
                + "\nMatrícula del vehículo: " + matricula
                + "\nDNI del examinador: " + dniTrabajador
                + "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
    }

}
