package bbdd;

import ClasesTablas.Clase;
import ClasesTablas.Practico;
import ClasesTablas.Teorico;
import ClasesTablas.Trabajador;
import ClasesTablas.Vehiculo;
import Main.ErrorBaseDatos;
import ClasesTablas.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

/**
 * La clase BD_Autoescuela incorpora los métodos necesarios para operar en cada
 * una de las tablas de la BBDD.
 *
 * @author David Garcia Terrel
 * @author Hugo Pozuelo Martinez
 * @author Felipe Vargas Contreras
 * @version v1.0 (2022/05/19)
 */
public class BD_Autoescuela extends BD_Conector {

    private static Statement s;
    private static ResultSet reg;

    public BD_Autoescuela(String bbdd) {
        super(bbdd);
    }

    /**
     * Localiza en la tabla [vehiculo] de la BBDD aquel registro en el que el
     * campo [MATRICULA] coincida con el String pasado. Felipe Vargas Contreras
     *
     * @param matricula Tipo de dato String con formato [0-9]{4}[a-zA-Z]{3}.
     * @return Devuelve un Vehiculo, un Vehiculo vacío o NULL.
     * @throws ErrorBaseDatos
     */
    public Vehiculo buscarVehiculo(String matricula) throws ErrorBaseDatos {
        String cadena = "SELECT * from vehiculo where MATRICULA = '" + matricula + "'";

        Vehiculo vehiculo = null;

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena);
            while (reg.next()) {
                vehiculo = new Vehiculo(reg.getString("MATRICULA"), reg.getString("MARCA"), reg.getString("MODELO"), reg.getDate("FECHA MATRICULACION").toLocalDate(), reg.getBoolean("ITV"));
            }
            s.close();
            this.cerrar();
            return vehiculo;
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }
    }

    /**
     * Localiza en la tabla [clase] de la BBDD aquel registro en el que el campo
     * [IDCLASE] coincida con el int pasado. Felipe Vargas Contreras
     *
     * @param ide Tipo de dato int que cumple la siguiente condición (ide > 0).
     * @return Devuelve una Clase, una Clase vacía o NULL.
     * @throws ErrorBaseDatos
     */
    public Clase buscarClase(int ide) throws ErrorBaseDatos {
        String cadena = "SELECT * from clase where IDCLASE = '" + ide + "'";

        Clase clase = null;

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena);
            while (reg.next()) {
                clase = new Clase(ide, reg.getString("DNI_ALUMNO"), reg.getString("DNI_TRABAJADOR"), reg.getDate("FECHA").toLocalDate(), reg.getString("MATRICULA"));
            }
            s.close();
            this.cerrar();
            return clase;
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }
    }

    /**
     * Localiza en la tabla [practico] de la BBDD aquel registro en el que el
     * campo [ID_PRACTICO] coincida con el int pasado. Felipe Vargas Contreras
     *
     * @param ide Tipo de dato int que cumple con la siguiente condición (ide >
     * 0).
     * @return Devuelve un Examen.Practico, un Examen.Practico vacío o NULL.
     * @throws ErrorBaseDatos
     */
    public Practico buscarExamenPractico(int ide) throws ErrorBaseDatos {
        String cadena = "SELECT * from practico where ID_PRACTICO = '" + ide + "'";

        Practico practico = null;

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena);
            while (reg.next()) {
                practico = new Practico(ide, reg.getDate("FECHA").toLocalDate(), reg.getBoolean("APROBADO"), reg.getInt("LEVES"), reg.getInt("DEFICIENTES"), reg.getInt("GRAVES"), reg.getString("MATRICULA"), reg.getString("DNI_TRABAJADOR"));
            }
            s.close();
            this.cerrar();
            return practico;
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }
    }

    /**
     * Localiza en la tabla [teorico] de la BBDD aquel registro en el que el
     * campo [ID_TEORICO] coincida con el int pasado. Felipe Vargas Contreras
     *
     * @param ide Tipo de dato int que cumple con la siguiente condición (ide >
     * 0)
     * @return Devuelve un Examen.Teorico, un Examen.Teorico vacío o NULL.
     * @throws ErrorBaseDatos
     */
    public Teorico buscarExamenTeorico(int ide) throws ErrorBaseDatos {
        String cadena = "SELECT * from teorico where ID_TEORICO = '" + ide + "'";

        Teorico teorico = null;

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena);
            while (reg.next()) {
                teorico = new Teorico(ide, reg.getDate("FECHA").toLocalDate(), reg.getBoolean("APROBADO"), reg.getInt("FALLOS"));
            }
            s.close();
            this.cerrar();
            return teorico;
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }
    }

    /**
     * Localiza en la tabla [trabajador] de la BBDD aquel registro en el que el
     * campo [DNI] coincida con el String pasado. Felipe Vargas Contreras
     *
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve un Persona.Trabajador, un Persona.Trabajador vacío o
     * NULL.
     * @throws ErrorBaseDatos
     */
    public Trabajador buscarTrabajador(String dni) throws ErrorBaseDatos {
        String cadena = "SELECT * from trabajador where DNI = '" + dni + "'";

        Direccion direccion = null;

        Trabajador trabajador = null;

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena);
            while (reg.next()) {
                char letra;

                if (reg.getString("LETRA") == null) {
                    letra = '0';
                } else {
                    letra = reg.getString("LETRA").charAt(0);
                }
                direccion = new Direccion(reg.getString("CALLE"), reg.getInt("NUMERO"), reg.getInt("PLANTA"), letra, reg.getInt("CODIGO POSTAL"));
                trabajador = new Trabajador(dni, reg.getString("NOMBRE"), reg.getString("APELLIDOS"), reg.getDate("FECHA NACIMIENTO").toLocalDate(), reg.getString("TELEFONO"), reg.getString("CORREO"), reg.getDate("FCHA ALTA").toLocalDate(), direccion, reg.getBoolean("ADMINISTRADOR"), reg.getString("CONTRASEÑA"));
            }
            s.close();
            this.cerrar();
            return trabajador;
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }
    }

    /**
     * Localiza en la tabla [alumno] de la BBDD aquel registro en el que el
     * campo [DNI] coincida con el String pasado. Felipe Vargas Contreras
     *
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve un Persona.Alumno, un Persona.Alumno vacío o NULL.
     */
    public Alumno buscarAlumno(String dni) {
        Vector<Examen> examenes = new Vector<Examen>();

        Examen examen = null;

        String cadena1 = "SELECT * from teorico where DNI_ALUMNO  = '" + dni + "'";

        Alumno alumno = null;

        Direccion direccion = null;

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena1);
            while (reg.next()) {
                examen = new Teorico(reg.getInt("ID_TEORICO"), reg.getDate("FECHA").toLocalDate(), reg.getBoolean("APROBADO"), reg.getInt("FALLOS"));
                examenes.add(examen);
            }
            s.close();
            this.cerrar();
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }

        String cadena2 = "SELECT * from practico where DNI_ALUMNO = '" + dni + "'";

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena2);
            while (reg.next()) {
                examen = new Practico(reg.getInt("ID_PRACTICO"), reg.getDate("FECHA").toLocalDate(), reg.getBoolean("APROBADO"), reg.getInt("LEVES"), reg.getInt("DEFICIENTES"), reg.getInt("GRAVES"), reg.getString("MATRICULA"), reg.getString("DNI_TRABAJADOR"));
                examenes.add(examen);
            }
            s.close();
            this.cerrar();
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }

        String cadena3 = "SELECT * from alumno where DNI = '" + dni + "'";

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena3);
            while (reg.next()) {

                char letra;

                if (reg.getString("LETRA") == null) {
                    letra = '0';
                } else {
                    letra = reg.getString("LETRA").charAt(0);
                }

                direccion = new Direccion(reg.getString("CALLE"), reg.getInt("NUMERO"), reg.getInt("PLANTA"), letra, reg.getInt("CODIGO POSTAL"));
                alumno = new Alumno(dni, reg.getString("NOMBRE"), reg.getString("APELLIDOS"), reg.getDate("FECHA NACIMIENTO").toLocalDate(), reg.getString("TELEFONO"), reg.getString("CORREO"), reg.getDate("FECHA ALTA").toLocalDate(), direccion, examenes);
            }
            s.close();
            this.cerrar();
            return alumno;
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }
    }

    /**
     * Localiza en la tabla [clase] de la BBDD todos los registros en el que el
     * campo [DNI_TRABAJADOR] coincida con el String pasado. Hugo Pozuelo
     * Martínez
     *
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve un Vector.Clase, un Vector.Clase vacío o NULL.
     * @throws ErrorBaseDatos
     */
    public Vector<Clase> buscarClaseProfesor(String dni) throws ErrorBaseDatos {
        String cadena = "SELECT * FROM clase WHERE DNI_TRABAJADOR = '" + dni + "'";

        Vector<Clase> clases = new Vector<Clase>();

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena);
            while (reg.next()) {
                clases.add(new Clase(reg.getInt("IDCLASE"), reg.getString("DNI_ALUMNO").toUpperCase(), reg.getString("DNI_TRABAJADOR").toUpperCase(), reg.getDate("FECHA").toLocalDate(), reg.getString("MATRICULA").toUpperCase()));
            }
            s.close();
            this.cerrar();
            return clases;
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }
    }

    /**
     * Localiza en la tabla [practico] de la BBDD todos los registros en el que
     * el campo [DNI_TRABAJADOR] coincida con el String pasado. Hugo Pozuelo
     * Martínez
     *
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve un Vector.Examen.Practico, un Vector.Examen.Practico
     * vacío o NULL.
     * @throws ErrorBaseDatos
     */
    public Vector<Practico> buscarExamenPracticoProfesor(String dni) throws ErrorBaseDatos {
        String cadena = "SELECT * FROM practico WHERE DNI_TRABAJADOR = '" + dni + "'";

        Vector<Practico> practicos = new Vector<Practico>();

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena);
            while (reg.next()) {
                practicos.add(new Practico(reg.getInt("ID_PRACTICO"), reg.getDate("FECHA").toLocalDate(), reg.getBoolean("APROBADO"), reg.getInt("LEVES"), reg.getInt("DEFICIENTES"), reg.getInt("GRAVES"), reg.getString("MATRICULA").toUpperCase(), reg.getString("DNI_TRABAJADOR").toUpperCase()));
            }
            s.close();
            this.cerrar();
            return practicos;
        } catch (SQLException e) {
            this.cerrar();
            return null;
        }
    }

    /**
     * Inserta en la tabla [alumno] de la BBDD los campos del Alumno pasado.
     * David Garcia Terrel
     *
     * @param a1 Tipo de dato Alumno.
     * @return Devuelve el total de filas insertadas.
     * @throws ErrorBaseDatos
     */
    public int insertar_Alumno(Alumno a1) throws ErrorBaseDatos {
        String planta;
        String letra;

        String cadenaSQL = null;

        if (a1.getDireccion().getLetra() == '0' && a1.getDireccion().getPlantra() == 0) {
            cadenaSQL = "INSERT INTO alumno Values ('" + a1.getDni() + "','" + a1.getNombre() + "','" + a1.getApellidos() + "','" + a1.getFechanacimiento() + "','"
                    + a1.getTelefono() + "','" + a1.getCorreo() + "','" + a1.getFechaAlta() + "','" + a1.getDireccion().getCalle() + "','" + a1.getDireccion().getNumero() + "',"
                    + null + "," + null + ",'" + a1.getDireccion().getCodigopostal() + "')";
        }

        if (a1.getDireccion().getLetra() == '0' && a1.getDireccion().getPlantra() != 0) {
            planta = String.valueOf(a1.getDireccion().getPlantra());
            cadenaSQL = "INSERT INTO alumno Values ('" + a1.getDni() + "','" + a1.getNombre() + "','" + a1.getApellidos() + "','" + a1.getFechanacimiento() + "','"
                    + a1.getTelefono() + "','" + a1.getCorreo() + "','" + a1.getFechaAlta() + "','" + a1.getDireccion().getCalle() + "','" + a1.getDireccion().getNumero() + "','"
                    + planta + "'," + null + ",'" + a1.getDireccion().getCodigopostal() + "')";
        }

        if (a1.getDireccion().getLetra() != '0' && a1.getDireccion().getPlantra() == 0) {
            letra = String.valueOf(a1.getDireccion().getLetra());
            cadenaSQL = "INSERT INTO alumno Values ('" + a1.getDni() + "','" + a1.getNombre() + "','" + a1.getApellidos() + "','" + a1.getFechanacimiento() + "','"
                    + a1.getTelefono() + "','" + a1.getCorreo() + "','" + a1.getFechaAlta() + "','" + a1.getDireccion().getCalle() + "','" + a1.getDireccion().getNumero() + "',"
                    + null + ",'" + letra + "','" + a1.getDireccion().getCodigopostal() + "')";
        }

        if (a1.getDireccion().getLetra() != '0' && a1.getDireccion().getPlantra() != 0) {
            letra = String.valueOf(a1.getDireccion().getLetra());
            planta = String.valueOf(a1.getDireccion().getPlantra());
            cadenaSQL = "INSERT INTO alumno Values ('" + a1.getDni() + "','" + a1.getNombre() + "','" + a1.getApellidos() + "','" + a1.getFechanacimiento() + "','"
                    + a1.getTelefono() + "','" + a1.getCorreo() + "','" + a1.getFechaAlta() + "','" + a1.getDireccion().getCalle() + "','" + a1.getDireccion().getNumero() + "','"
                    + planta + "','" + letra + "','" + a1.getDireccion().getCodigopostal() + "')";
        }

        try {
            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            throw new ErrorBaseDatos("No se puede realizar el alta del alumno");
        }
    }

    /**
     * Inserta en la tabla [trabajador] de la BBDD los campos del Trabajador
     * pasado. David Garcia Terrel
     *
     * @param a1 Tipo de dato Trabajador.
     * @return Devuelve el total de filas insertadas.
     * @throws ErrorBaseDatos
     */
    public int insertar_Trabajador(Trabajador a1) throws ErrorBaseDatos {
        String planta;
        String letra;

        String cadenaSQL = null;

        if (a1.getDireccion().getLetra() == '0' && a1.getDireccion().getPlantra() == 0) {
            cadenaSQL = "INSERT INTO trabajador Values ('" + a1.getDni() + "','" + a1.getNombre() + "','" + a1.getApellidos() + "','" + a1.getFechanacimiento() + "','"
                    + a1.getTelefono() + "','" + a1.getCorreo() + "','" + a1.getFechaAlta() + "','" + a1.getDireccion().getCalle() + "','" + a1.getDireccion().getNumero() + "',"
                    + null + "," + null + ",'" + a1.getDireccion().getCodigopostal() + "', " + a1.isAdministrador() + " , '" + a1.getContraseña() + "')";
        }

        if (a1.getDireccion().getLetra() == '0' && a1.getDireccion().getPlantra() != 0) {
            planta = String.valueOf(a1.getDireccion().getPlantra());
            cadenaSQL = "INSERT INTO trabajador Values ('" + a1.getDni() + "','" + a1.getNombre() + "','" + a1.getApellidos() + "','" + a1.getFechanacimiento() + "','"
                    + a1.getTelefono() + "','" + a1.getCorreo() + "','" + a1.getFechaAlta() + "','" + a1.getDireccion().getCalle() + "','" + a1.getDireccion().getNumero() + "','"
                    + planta + "'," + null + ",'" + a1.getDireccion().getCodigopostal() + "' , " + a1.isAdministrador() + " , '" + a1.getContraseña() + "')";
        }

        if (a1.getDireccion().getLetra() != '0' && a1.getDireccion().getPlantra() == 0) {
            letra = String.valueOf(a1.getDireccion().getLetra());
            cadenaSQL = "INSERT INTO trabajador Values ('" + a1.getDni() + "','" + a1.getNombre() + "','" + a1.getApellidos() + "','" + a1.getFechanacimiento() + "','"
                    + a1.getTelefono() + "','" + a1.getCorreo() + "','" + a1.getFechaAlta() + "','" + a1.getDireccion().getCalle() + "','" + a1.getDireccion().getNumero() + "',"
                    + null + ",'" + letra + "','" + a1.getDireccion().getCodigopostal() + "', " + a1.isAdministrador() + " , '" + a1.getContraseña() + "')";
        }

        if (a1.getDireccion().getLetra() != '0' && a1.getDireccion().getPlantra() != 0) {
            letra = String.valueOf(a1.getDireccion().getLetra());
            planta = String.valueOf(a1.getDireccion().getPlantra());
            cadenaSQL = "INSERT INTO trabajador Values ('" + a1.getDni() + "','" + a1.getNombre() + "','" + a1.getApellidos() + "','" + a1.getFechanacimiento() + "','"
                    + a1.getTelefono() + "','" + a1.getCorreo() + "','" + a1.getFechaAlta() + "','" + a1.getDireccion().getCalle() + "','" + a1.getDireccion().getNumero() + "','"
                    + planta + "','" + letra + "','" + a1.getDireccion().getCodigopostal() + "' , " + a1.isAdministrador() + " , '" + a1.getContraseña() + "')";
        }
        try {
            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            throw new ErrorBaseDatos("No se puede realizar el alta del Trabajador");
        }
    }

    /**
     * Inserta en la tabla [vehiculo] de la BBDD los campos del Vehiculo pasado.
     * David Garcia Terrel
     *
     * @param v1 Tipo de dato Vehiculo.
     * @return Devuelve el total de filas insertadas.
     * @throws ErrorBaseDatos
     */
    public int insertar_Vehiculo(Vehiculo v1) throws ErrorBaseDatos {
        String cadenaSQL = "INSERT INTO vehiculo Values ('" + v1.getMatricula() + "','" + v1.getMarca() + "','" + v1.getModelo() + "','" + v1.getFecha_matriculacion() + "'," + v1.isItv_Pasada() + ")";
        try {
            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            throw new ErrorBaseDatos("No se puede realizar el alta del Vehículo");
        }
    }

    /**
     * Inserta en la tabla [teorico] de la BBDD los campos del Teorico pasado
     * junto al String que hace referencia al campo [DNI_ALUMNO]. David Garcia
     * Terrel
     *
     * @param t1 Tipo de dato Teorico.
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z][1}.
     * @return Devuelve el total de filas insertadas.
     * @throws ErrorBaseDatos
     */
    public int insertar_Examen_Teorico(Teorico t1, String dni) throws ErrorBaseDatos {
        String cadenaSQL = "INSERT INTO teorico Values (0,'" + dni + "','" + t1.getFecha() + "','" + t1.getFallos() + "'," + t1.isAprobado() + ")";
        try {
            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            throw new ErrorBaseDatos("No se puede realizar el alta del Examen Teórico");
        }
    }

    /**
     * Inserta en la tabla [practico] de la BBDD los campos del Practico pasado
     * junto al String que hace referencia al campo [DNI_ALUMNO]. David Garcia
     * Terrel
     *
     * @param p1 Tipo de dato Practico.
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve el total de filas insertadas.
     * @throws ErrorBaseDatos
     */
    public int insertar_Examen_Practico(Practico p1, String dni) throws ErrorBaseDatos {
        String cadenaSQL = "INSERT INTO practico Values (0,'" + dni + "','" + p1.getDniTrabajador() + "','" + p1.getMatricula() + "','" + p1.getFecha() + "','" + p1.getLeves() + "','" + p1.getDeficientes() + "','" + p1.getGraves() + "'," + p1.isAprobado() + ")";
        try {
            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            throw new ErrorBaseDatos("No se puede realizar el alta del Examen Práctico");
        }
    }

    /**
     * Inserta en la tabla [clase] de la BBDD los campos de la Clase pasada.
     * David Garcia Terrel
     *
     * @param c1 Tipo de dato Clase.
     * @return Devuelve el total de filas insertadas.
     * @throws ErrorBaseDatos
     */
    public int insertar_Clase(Clase c1) throws ErrorBaseDatos {
        String cadenaSQL = "INSERT INTO clase Values (0,'" + c1.getDniAlumno() + "','" + c1.getDniTrabajador() + "','" + c1.getFecha() + "','" + c1.getMatricula() + "')";
        try {
            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate(cadenaSQL);
            s.close();
            this.cerrar();
            return filas;
        } catch (SQLException e) {
            throw new ErrorBaseDatos("No se puede realizar el alta de la clase");
        }
    }

    /**
     * Elimina de la tabla [alumno] de la BBDD aquel registro en el que el campo
     * [DNI] coincida con el String pasado. Elimina de la tabla [teorico] de la
     * BBDD todos los registros en el que el campo [DNI_ALUMNO] coincida con el
     * String pasado. Elimina de la tabla [practico] de la BBDD todos los
     * registros en el que el campo [DNI_ALUMNO] coincida con el String pasado.
     * Elimina de la tabla [clase] de la BBDD todos los registros en el que el
     * campo [DNI_ALUMNO] coincida con el String pasado. Hugo Pozuelo Martinez
     *
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve el total de filas eliminadas.
     * @throws ErrorBaseDatos
     */
    public int borrarAlumno(String dni) throws ErrorBaseDatos {

        try {

            this.abrir();
            c.setAutoCommit(false);
            s = c.createStatement();
            s.executeUpdate("DELETE FROM clase WHERE DNI_ALUMNO = '" + dni + "'");
            s.executeUpdate("DELETE FROM practico WHERE DNI_ALUMNO = '" + dni + "'");
            s.executeUpdate("DELETE FROM teorico WHERE DNI_ALUMNO = '" + dni + "'");
            int filas = s.executeUpdate("DELETE FROM alumno WHERE DNI = '" + dni + "'");
            s.close();
            c.commit();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            try {

                c.rollback();

            } catch (SQLException x) {

                System.out.println(x.getMessage());

            }

            this.cerrar();
            throw new ErrorBaseDatos("Contacte con Sistemas: No es posible dar de baja de la base de datos al alumno. ");

        }

    }

    /**
     * Elimina de la tabla [trabajador] de la BBDD aquel registro en el que el
     * campo [DNI] coincida con el String pasado. Reemplaza por NULL en la tabla
     * [practico] de la BBDD todos los registros en el que el campo
     * [DNI_TRABAJADOR] coincida con el String pasado. Reemplaza por NULL en la
     * tabla [clase] de la BBDD todos los registros en el que el campo
     * [DNI_TRABAJADOR] coincida con el String pasado. Hugo Pozuelo Martinez
     *
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve el total de filas eliminadas.
     * @throws ErrorBaseDatos
     */
    public int borrarTrabajador(String dni) throws ErrorBaseDatos {

        try {

            this.abrir();
            c.setAutoCommit(false);
            s = c.createStatement();
            s.executeUpdate("UPDATE clase SET DNI_TRABAJADOR = NULL WHERE DNI_TRABAJADOR = '" + dni + "'");
            s.executeUpdate("UPDATE practico SET DNI_TRABAJADOR = NULL WHERE DNI_TRABAJADOR = '" + dni + "'");
            int filas = s.executeUpdate("DELETE FROM trabajador WHERE DNI = '" + dni + "'");
            s.close();
            c.commit();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            try {

                c.rollback();

            } catch (SQLException x) {

                System.out.println(x.getMessage());

            }

            this.cerrar();
            throw new ErrorBaseDatos("Contacte con Sistemas: No es posible dar de baja de la base de datos al trabajador. ");

        }

    }

    /**
     * Elimina de la tabla [vehiculo] de la BBDD aquel registro en el que el
     * campo [MATRICULA] coincida con el String pasado. Reemplaza por NULL en la
     * tabla [practico] de la BBDD todos los registros en el que el campo
     * [MATRICULA] coincida con el String pasado. Reemplaza por NULL en la tabla
     * [clase] de la BBDD todos los registros en el que el campo [MATRICULA]
     * coincida con el String pasado. Hugo Pozuelo Martinez
     *
     * @param matricula Tipo de dato String con formato [0-9]{4}[a-zA-Z]{3}.
     * @return Devuelve el total de filas eliminadas.
     * @throws ErrorBaseDatos
     */
    public int borrarVehiculo(String matricula) throws ErrorBaseDatos {

        try {

            this.abrir();
            c.setAutoCommit(false);
            s = c.createStatement();
            s.executeUpdate("UPDATE clase SET MATRICULA = NULL WHERE MATRICULA = '" + matricula + "'");
            s.executeUpdate("UPDATE practico SET MATRICULA = NULL WHERE MATRICULA = '" + matricula + "'");
            int filas = s.executeUpdate("DELETE FROM vehiculo WHERE MATRICULA = '" + matricula + "'");
            s.close();
            c.commit();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            try {

                c.rollback();

            } catch (SQLException x) {

                System.out.println(x.getMessage());

            }

            this.cerrar();
            throw new ErrorBaseDatos("Contacte con Sistemas: No es posible dar de baja de la base de datos al vehículo. ");

        }

    }

    /**
     * Elimina de la tabla [clase] de la BBDD aquel registro en el que el campo
     * [IDCLASE] coincida con el int pasado. Hugo Pozuelo Martinez
     *
     * @param id_clase Tipo de dato int que cumple con la siguiente condición
     * (id_clase > 0).
     * @return Devuelve el total de filas eliminadas.
     * @throws ErrorBaseDatos
     */
    public int borrarClase(int id_clase) throws ErrorBaseDatos {

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate("DELETE FROM clase WHERE IDCLASE = " + id_clase);
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            this.cerrar();
            throw new ErrorBaseDatos("Contacte con Sistemas: No es posible dar de baja de la base de datos a la clase. ");

        }

    }

    /**
     * Elimina de la tabla [practico] de la BBDD aquel registro en el que el
     * campo [ID_PRACTICO] coincida con el int pasado. Hugo Pozuelo Martinez
     *
     * @param idExamen Tipo de dato int que cumple con la siguiente condición
     * (idExamen > 0).
     * @return Devuelve el total de filas eliminadas.
     * @throws ErrorBaseDatos
     */
    public int borrarPractico(int idExamen) throws ErrorBaseDatos {

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate("DELETE FROM practico WHERE ID_PRACTICO = " + idExamen);
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            this.cerrar();
            throw new ErrorBaseDatos("Contacte con Sistemas: No es posible dar de baja de la base de datos al examen práctico. ");

        }

    }

    /**
     * Elimina de la tabla [teorico] de la BBDD aquel registro en el que el
     * campo [ID_TEORICO] coincida con el int pasado. Hugo Pozuelo Martinez
     *
     * @param idExamen Tipo de dato int que cumple con la siguiente condición
     * (idExamen > 0).
     * @return Devuelve el total de filas eliminadas.
     * @throws ErrorBaseDatos
     */
    public int borrarTeorico(int idExamen) throws ErrorBaseDatos {

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate("DELETE FROM teorico WHERE ID_TEORICO = " + idExamen);
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            this.cerrar();
            throw new ErrorBaseDatos("Contacte con Sistemas: No es posible dar de baja de la base de datos al examen teórico. ");

        }

    }

    /**
     * Elimina de la tabla [clase] de la BBDD todos los registros en el que el
     * campo [IDCLASE] coincida con el int pasado además de que el campo
     * [DNI_TRABAJADOR] coincida con el String pasado. Hugo Pozuelo Martinez
     *
     * @param id_clase Tipo de dato int que cumple con la siguiente condición
     * (id_clase > 0).
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve el total de filas eliminadas.
     * @throws ErrorBaseDatos
     */
    public int borrarClaseProfesor(int id_clase, String dni) throws ErrorBaseDatos {

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate("DELETE FROM clase WHERE IDCLASE = " + id_clase + " AND DNI_TRABAJADOR = '" + dni + "'");
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            this.cerrar();
            throw new ErrorBaseDatos("Contacte con Sistemas: No es posible dar de baja de la base de datos a la clase. ");

        }

    }

    /**
     * Elimina de la tabla [practico] de la BBDD todos los registros en el que
     * el campo [ID_PRACTICO] coincida con el int pasado además de que el campo
     * [DNI_TRABAJADOR] coincida con el String pasado. Hugo Pozuelo Martinez
     *
     * @param idExamen Tipo de dato int que cumple con la siguiente condición
     * (id_clase > 0).
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve el total de filas eliminadas.
     * @throws ErrorBaseDatos
     */
    public int borrarPracticoProfesor(int idExamen, String dni) throws ErrorBaseDatos {

        try {

            this.abrir();
            s = c.createStatement();
            int filas = s.executeUpdate("DELETE FROM practico WHERE ID_PRACTICO = " + idExamen + " AND DNI_TRABAJADOR = '" + dni + "'");
            s.close();
            this.cerrar();
            return filas;

        } catch (SQLException e) {

            this.cerrar();
            throw new ErrorBaseDatos("Contacte con Sistemas: No es posible dar de baja de la base de datos al examen práctico. ");

        }

    }

    /**
     * Método de autenticación para poder realizar operaciones sobre la BBDD.
     * Localiza en la tabla [trabajador] de la BBDD aquel registro en el que el
     * campo [DNI] coincida con el primer String pasado además de que el campo
     * [CONTRASEÑA] coincida con el segundo String pasado. Hugo Pozuelo Martinez
     *
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @param clave Tipo de dato String que cumple con la siguiente condición
     * !(clave >= 8).
     * @return Devuelve 0 si no coinciden las credenciales; Devuelve 1 si
     * coinciden las credenciales y es administrador; Devuelve 2 si coinciden
     * las credenciales y no es administrador.
     * @throws ErrorBaseDatos
     */
    public int iniciarSesion(String dni, String clave) throws ErrorBaseDatos {

        int retorno = 0;

        try {

            this.abrir();
            PreparedStatement ps = c.prepareStatement("SELECT ADMINISTRADOR FROM trabajador WHERE DNI = ? AND CONTRASEÑA = ?");
            ps.setString(1, dni);
            ps.setString(2, clave);
            reg = ps.executeQuery();
            if (reg.next()) {
                if (reg.getBoolean(1)) {
                    retorno = 1;
                } else {
                    retorno = 2;
                }
            }
            ps.close();
            this.cerrar();
            return retorno;

        } catch (SQLException e) {

            this.cerrar();
            throw new ErrorBaseDatos("Contacte con Sistemas: No es posible iniciar sesión en la base de datos. ");

        }

    }

    /**
     * Cuenta en la tabla [clase] de la BBDD todos los registros en el que el
     * campo [DNI_ALUMNO] coincida con el String pasado. Felipe Vargas Contreras
     *
     * @param dni Tipo de dato String con formato [0-9]{8}[a-zA-Z]{1}.
     * @return Devuelve si el total de clases realizadas supera o iguala 4.
     * @throws ErrorBaseDatos
     */
    public boolean clasesRealizadas(String dni) throws ErrorBaseDatos {
        String cadena = "SELECT COUNT(*) from clase where DNI_ALUMNO = '" + dni + "'";

        boolean a = false;

        try {
            this.abrir();
            s = c.createStatement();
            reg = s.executeQuery(cadena);
            while (reg.next()) {
                if (reg.getInt(1) >= 4) {
                    a = true;
                }
            }
            s.close();
            this.cerrar();
            return a;
        } catch (SQLException e) {
            this.cerrar();
            throw new ErrorBaseDatos("Error en la select");
        }
    }

}
