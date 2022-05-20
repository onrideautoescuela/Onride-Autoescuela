package ClasesTablas;

import java.time.LocalDate;

/**
 * La clase Vehiculo determina los campos requeridos para contruir un objeto de
 * tipo Vehiculo.
 *
 * @author Hugo Pozuelo Martinez
 * @author Felipe Vargas Contreras
 * @version v1.0 (2022/05/19)
 */
public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private LocalDate fecha_matriculacion;
    private boolean itv_Pasada;

    public Vehiculo(String matricula, String marca, String modelo, LocalDate fecha_matriculacion, boolean itv_Pasada) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.fecha_matriculacion = fecha_matriculacion;
        this.itv_Pasada = itv_Pasada;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getFecha_matriculacion() {
        return fecha_matriculacion;
    }

    public boolean isItv_Pasada() {
        return itv_Pasada;
    }

    @Override
    public String toString() {
        return "[VEHÍCULO]+-+-+-+-+-+-+-+-+-+-+\n"
                + "Matrícula: " + matricula
                + "\nMarca: " + marca
                + "\nModelo: " + modelo
                + "\nFecha de matriculación: " + fecha_matriculacion
                + "\n¿ITV pasada?" + itv_Pasada
                + "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+";
    }

}
