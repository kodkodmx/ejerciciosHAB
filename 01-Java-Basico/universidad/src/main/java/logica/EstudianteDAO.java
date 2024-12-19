package logica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {
    private Connection connection;

    public EstudianteDAO() throws SQLException {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/universidad", "root", "");
        } catch (SQLException e) {
            throw new SQLException("No se pudo conectar a la base de datos", e);
        }
    }

    public void agregarEstudiante(Estudiante estudiante) throws SQLException {
        String sql = "INSERT INTO estudiantes (nombre, edad, calificacion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, estudiante.getNombre());
            stmt.setInt(2, estudiante.getEdad());
            stmt.setDouble(3, estudiante.getCalificacion());
            stmt.executeUpdate();
        }
    }

    public List<Estudiante> obtenerEstudiantes() throws SQLException {
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                double calificacion = rs.getDouble("calificacion");
                estudiantes.add(new Estudiante(id, nombre, edad, calificacion));
            }
        }
        return estudiantes;
    }
}

