import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RegistroMantenimientos {
    private Queue<Mantenimientos> colaMantenimientos;
    private List<Usuarios> listaUsuarios;

    public RegistroMantenimientos(List<Usuarios> listaUsuarios) {
        colaMantenimientos = new LinkedList<>();
        this.listaUsuarios = listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void registrarMantenimiento(Mantenimientos mantenimiento, String correoUsuario) {
        if (mantenimiento == null ||
                mantenimiento.getTipo() == null || mantenimiento.getTipo().trim().isEmpty() ||
                mantenimiento.getParroquia() == null || mantenimiento.getParroquia().trim().isEmpty() ||
                mantenimiento.getCodigoPostal() == null || mantenimiento.getCodigoPostal().trim().isEmpty() ||
                mantenimiento.getDescripcion() == null || mantenimiento.getDescripcion().trim().isEmpty() ||
                mantenimiento.getEstado() == null || mantenimiento.getEstado().trim().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Error: Todos los campos del mantenimiento deben estar completos");
            return;
        }

        Usuarios usuarioEncontrado = null;
        for (Usuarios u : listaUsuarios) {
            if (u.getCorreo().equalsIgnoreCase(correoUsuario)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            JOptionPane.showMessageDialog(null, "Error: El usuario que intenta registrar el mantenimiento no existe.");
            return;
        }

        Mantenimientos nuevoMantenimiento = new Mantenimientos(
                mantenimiento.getTipo(),
                mantenimiento.getParroquia(),
                mantenimiento.getCodigoPostal(),
                mantenimiento.getDescripcion(),
                "Pendiente",
                correoUsuario,
                "Pendiente"
        );

        colaMantenimientos.add(nuevoMantenimiento);
        usuarioEncontrado.incrementarFallas();
        JOptionPane.showMessageDialog(null, "Mantenimiento registrado correctamente por: " + usuarioEncontrado.getNombre());
    }

    // Resto de métodos similares a RegistroFallas...
    public String mostrarTodosMantenimientos() {
        if (colaMantenimientos.isEmpty()) {
            return "No hay mantenimientos registrados";
        }

        StringBuilder sb = new StringBuilder();
        for (Mantenimientos m : colaMantenimientos) {
            sb.append(m.toString()).append("\n");
        }
        return sb.toString();
    }

    public Queue<Mantenimientos> getColaMantenimientos() {
        return this.colaMantenimientos;
    }
}