package ClasesTablas;

import java.time.LocalDate;

/**
 * La clase Trabajador (extends Persona) determina los campos requeridos para
 * contruir un objeto de tipo Trabajador.
 *
 * @author Hugo Pozuelo Martinez
 * @author Felipe Vargas Contreras
 * @version v1.0 (2022/05/19)
 */
public class Trabajador extends Persona {

    private boolean administrador;
    private String contraseña;

    public Trabajador(String dni, String nombre, String apellidos, LocalDate fechanacimiento, String telefono, String correo, LocalDate fechaAlta, Direccion direccion, boolean administrador, String contraseña) {
        super(dni, nombre, apellidos, fechanacimiento, telefono, correo, fechaAlta, direccion);
        this.administrador = administrador;
        this.contraseña = contraseña;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public Direccion getDireccion() {
        return super.getDireccion(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCorreo() {
        return super.getCorreo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTelefono() {
        return super.getTelefono(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalDate getFechanacimiento() {
        return super.getFechanacimiento(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getApellidos() {
        return super.getApellidos(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        return super.getNombre(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDni() {
        return super.getDni(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "[TRABAJADOR]+-+-+-+-+-+-+-+-+-+\n"
                + super.toString()
                + "\n¿Administrador?: " + administrador
                + "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
    }
}
