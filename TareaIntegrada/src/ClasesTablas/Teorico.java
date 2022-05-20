package ClasesTablas;

import java.time.LocalDate;

/**
 * La clase Teorico (extends Examen) determina los campos requeridos para
 * contruir un objeto de tipo Teorico.
 *
 * @author Hugo Pozuelo Martinez
 * @author Felipe Vargas Contreras
 * @version v1.0 (2022/05/19)
 */
public class Teorico extends Examen {

    private int fallos;

    public Teorico(int idExamen, LocalDate fecha, boolean aprobado, int fallos) {
        super(idExamen, fecha, aprobado);
        this.fallos = fallos;
    }

    public int getFallos() {
        return fallos;
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
        return "[EXAMEN TEÓRICO]+-+-+-+-+-+-+-+\n"
                + super.toString()
                + "\nCantidad de fallos: " + fallos
                + "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
    }

}
