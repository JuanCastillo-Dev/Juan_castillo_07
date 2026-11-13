package vallegrande.edu.pe.sistemahotel.model;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private String nombreHuesped;
    private String dni;
    private String telefono;
    private String tipoHabitacion;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private String estado;

    public Reserva() {}

    public Reserva(int idReserva, String nombreHuesped, String dni, String telefono,
                   String tipoHabitacion, LocalDate fechaIngreso, LocalDate fechaSalida, String estado) {
        this.idReserva = idReserva;
        this.nombreHuesped = nombreHuesped;
        this.dni = dni;
        this.telefono = telefono;
        this.tipoHabitacion = tipoHabitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }

    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }

    public String getNombreHuesped() { return nombreHuesped; }
    public void setNombreHuesped(String nombreHuesped) { this.nombreHuesped = nombreHuesped; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(String tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }

    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(LocalDate fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
