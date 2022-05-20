package ClasesTablas;

import java.time.LocalDate;

/**
 * La clase Persona determina los campos requeridos para contruir un objeto de
 * tipo Persona.
 *
 * @author Hugo Pozuelo Martinez
 * @author Felipe Vargas Contreras
 * @version v1.0 (2022/05/19)
 */
public class Persona {

    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechanacimiento;
    private String telefono;
    private String correo;
    private LocalDate fechaAlta;
    private Direccion direccion;

    public Persona(String dni, String nombre, String apellidos, LocalDate fechanacimiento, String telefono, String correo, LocalDate fechaAlta, ClasesTablas.Direccion direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaAlta = fechaAlta;
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "DNI: " + dni
                + "\nNombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nFecha de nacimiento: " + fechanacimiento
                + "\nTeléfono: " + telefono
                + "\nCorreo electrónico: " + correo
                + "\n[DIRECCIÓN]-+-+-+-+-+-+-+-+-+-+"
                + "\n" + direccion.toString();
    }
}
