package vallegrande.edu.pe.sistemahotel.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public List<Reserva> listar() {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reserva r = new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getString("nombre_huesped"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("tipo_habitacion"),
                        rs.getDate("fecha_ingreso").toLocalDate(),
                        rs.getDate("fecha_salida").toLocalDate(),
                        rs.getString("estado")
                );
                lista.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar reservas: " + e.getMessage());
        }
        return lista;
    }

    public boolean registrar(Reserva r) {
        String sql = "INSERT INTO reservas (nombre_huesped, dni, telefono, tipo_habitacion, fecha_ingreso, fecha_salida, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getNombreHuesped());
            ps.setString(2, r.getDni());
            ps.setString(3, r.getTelefono());
            ps.setString(4, r.getTipoHabitacion());
            ps.setDate(5, Date.valueOf(r.getFechaIngreso()));
            ps.setDate(6, Date.valueOf(r.getFechaSalida()));
            ps.setString(7, r.getEstado());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar reserva: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizar(Reserva r) {
        String sql = "UPDATE reservas SET nombre_huesped=?, dni=?, telefono=?, tipo_habitacion=?, fecha_ingreso=?, fecha_salida=?, estado=? WHERE id_reserva=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getNombreHuesped());
            ps.setString(2, r.getDni());
            ps.setString(3, r.getTelefono());
            ps.setString(4, r.getTipoHabitacion());
            ps.setDate(5, Date.valueOf(r.getFechaIngreso()));
            ps.setDate(6, Date.valueOf(r.getFechaSalida()));
            ps.setString(7, r.getEstado());
            ps.setInt(8, r.getIdReserva());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar reserva: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idReserva) {
        String sql = "DELETE FROM reservas WHERE id_reserva=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idReserva);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar reserva: " + e.getMessage());
            return false;
        }
    }
}
