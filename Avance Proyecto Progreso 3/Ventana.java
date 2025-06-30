import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JTabbedPane txtFallasMostrar;
    private JPanel RegistroUsuario;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtCorreo;
    private JComboBox cboRol;
    private JButton BtnAgg;
    private JButton BtnMostrar;
    private JButton BtnBuscar;
    private JTextArea textInfo;
    private JButton btnAggfalla;
    private JButton listarFallasButton;
    private JTextField txtTipo;
    private JTextField txtUbicacionPorCP;
    private JTextField txtDescripcion;
    private JTextField txtCorreoFalla;
    private JTextArea textinfodos;
    private JPasswordField psContrasenia;
    private JTextField txtCorreoIniciar;
    private JButton btnIniciarSesion;
    private JComboBox cboUbiParroquia;
    private JTextArea txtFallasRegistradas;
    private JButton btnMostrarFallasRegistradas;
    private JTextField txtCedulaFallasRegistradas;
    private JTextField txtPonerACargo;
    private JButton btnAsignarTrabajador;
    private JRadioButton ButtonAActivo;
    private JRadioButton ButtonPendiente;
    private JTextArea txtEstadistica;
    private JComboBox cboBarriosEstadistica;
    private JTextField txtEstadisticaCP;
    private JButton BtnMostrarEstadisticas;
    private JRadioButton BtaActivoEstadistica;
    private JRadioButton BtaPendienteEstadistica;
    private JRadioButton ButtonFinalizado;
    private JRadioButton BtaFinalizadoEstadistica;
    private RegistroUsuarios registroUsuarios =new RegistroUsuarios();
    private RegistroFallas registroFallas = new RegistroFallas(registroUsuarios.getListaUsuarios());
    private RegistroMantenimientos registroMantenimientos;
    public Ventana() {

        Usuarios us1= new Usuarios("Derick","1724568922","Derick.tipan@udla.edu.ec","Tecnico",1);
        Usuarios us2= new Usuarios("Pedro","1708532115","Pedro.velastegui@udla.edu.ec","Usuario");
        Usuarios us3= new Usuarios("Kimberlly","1724568922","kim.ramos@udla.edu.ec","Tecnico",5);
        Usuarios us4 = new Usuarios("Ainhoa", "1723728885", "ainhoa.salas@udla.edu.ec", "Usuario", 1);
        registroUsuarios.registroinicial(us1);
        registroUsuarios.registroinicial(us2);
        registroUsuarios.registroinicial(us3);
        registroUsuarios.registroinicial(us4);
        registroFallas.setListaUsuarios(registroUsuarios.getListaUsuarios());
        Fallas fallaElectrica1 = new Fallas("Corte de energía", "Magdalena", "170112",
                "Interrupción del suministro eléctrico en el sector desde las 14:00", "Pendiente",
                "Pedro.velastegui@udla.edu.ec", "Derick.tipan@udla.edu.ec");

        Fallas fallaElectrica2 = new Fallas("Cableado peligroso", "Centro Histórico", "170215",
                "Cables de alta tensión expuestos en poste, riesgo de electrocución", "Pendiente",
                "ainhoa.salas@udla.edu.ec", "kim.ramos@udla.edu.ec");

        Fallas fallaElectrica3 = new Fallas("Medidor dañado", "Ponceano", "170318",
                "Medidor de energía con display no funcional en cliente ", "Pendiente",
                "ainhoa.salas@udla.edu.ec", "Derick.tipan@udla.edu.ec");
        registroFallas.getColaFallas().add(fallaElectrica1);
        registroFallas.getColaFallas().add(fallaElectrica2);
        registroFallas.getColaFallas().add(fallaElectrica3);

        for (Usuarios u : registroUsuarios.getListaUsuarios()) {
            String correo = u.getCorreo().toLowerCase();
            if (correo.equals("pedro.velastegui@udla.edu.ec")) {
                u.incrementarFallas();
            } else if (correo.equals("ainhoa.salas@udla.edu.ec")) {
                u.incrementarFallas();
                u.incrementarFallas();
            }
        }
        ButtonGroup estadoGroup = new ButtonGroup();
        estadoGroup.add(ButtonAActivo);
        estadoGroup.add(ButtonPendiente);
        estadoGroup.add(ButtonFinalizado);
        ButtonPendiente.setSelected(true);
        ButtonGroup estadisticasGroup = new ButtonGroup();
        estadisticasGroup.add(BtaActivoEstadistica);
        estadisticasGroup.add(BtaPendienteEstadistica);
        estadisticasGroup.add(BtaFinalizadoEstadistica);
        registroMantenimientos = new RegistroMantenimientos(registroUsuarios.getListaUsuarios());

        BtnAgg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String cedula = txtCedula.getText();
                String correo = txtCorreo.getText();
                String rol = (String) cboRol.getSelectedItem();
                Usuarios nuevoUsuario = new Usuarios(nombre, cedula, correo, rol);
                registroUsuarios.registrarUsuario(nuevoUsuario);
                txtNombre.setText("");
                txtCedula.setText("");
                txtCorreo.setText("");
                cboRol.setSelectedIndex(0);
                registroFallas.setListaUsuarios(registroUsuarios.getListaUsuarios());

            }
        });
        BtnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lista = registroUsuarios.mostrarUsuarios();
                textInfo.setText(lista);
            }
        });
        BtnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                String cedula = txtCedula.getText().trim();


                if (!nombre.isEmpty() && !cedula.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Por favor use solo un campo de búsqueda a la vez",
                            "Búsqueda inválida",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }


                if (!nombre.isEmpty()) {
                    textInfo.setText(registroUsuarios.buscarPorNombre(nombre));
                    txtCedula.setText("");
                }

                else if (!cedula.isEmpty()) {
                    textInfo.setText(registroUsuarios.buscarPorCedula(cedula));
                    txtNombre.setText("");
                }

                else {
                    textInfo.setText(registroUsuarios.mostrarUsuarios());
                }


            }
        });
        btnAggfalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = txtTipo.getText();
                String parroquia = (String) cboUbiParroquia.getSelectedItem();
                String codigoPostal = txtUbicacionPorCP.getText();
                String descripcion = txtDescripcion.getText();
                String correo = txtCorreoFalla.getText();
                String encargado = registroUsuarios.obtenerTecnicoDisponible();

                if (encargado.isEmpty()) {
                    return;
                }


                if (tipo.isEmpty() || "Seleccione una parroquia".equals(parroquia) ||
                        codigoPostal.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Todos los campos son obligatorios",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Fallas nuevaFalla = new Fallas(tipo, parroquia, codigoPostal, descripcion,
                        "Pendiente", correo, encargado);

                registroFallas.RegistrarFalla(nuevaFalla, correo);


                txtTipo.setText("");
                txtUbicacionPorCP.setText("");
                txtDescripcion.setText("");
                cboUbiParroquia.setSelectedIndex(0);
            }
        });
        listarFallasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textinfodos.setText(registroFallas.mostrarTodasFallas());
                String lista = registroFallas.mostrarTodasFallas();
                textinfodos.setText(lista);
            }
        });

        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correoIngresado = txtCorreoIniciar.getText().trim();
                String contraseniaIngresada = new String(psContrasenia.getPassword());


                String correoValido = "ariel.manzano@udla.edu.ec";
                String contraseniaValida = "1234";

                if (correoIngresado.equalsIgnoreCase(correoValido) &&
                        contraseniaIngresada.equals(contraseniaValida)) {

                    txtFallasMostrar.setSelectedComponent(RegistroUsuario);
                    JOptionPane.showMessageDialog(null, "¡Bienvenido Alejandro Manzano!");


                    txtCorreoIniciar.setText("");
                    psContrasenia.setText("");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Credenciales incorrectas",
                            "Error de autenticación",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnMostrarFallasRegistradas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener parámetros de filtrado
                String parroquia = (String) cboBarriosEstadistica.getSelectedItem();
                String codigoPostal = txtEstadisticaCP.getText().trim();

                // Determinar qué estados están seleccionados
                boolean mostrarActivos = BtaActivoEstadistica.isSelected();
                boolean mostrarPendientes = BtaPendienteEstadistica.isSelected();
                boolean mostrarFinalizados = BtaFinalizadoEstadistica.isSelected();

                // Si no hay ningún estado seleccionado, mostrar todos por defecto
                if (!mostrarActivos && !mostrarPendientes && !mostrarFinalizados) {
                    mostrarActivos = true;
                    mostrarPendientes = true;
                    mostrarFinalizados = true;
                }

                // Filtrar las fallas
                StringBuilder resultado = new StringBuilder();

                for (Fallas f : registroFallas.getColaFallas()) {
                    // Filtrar por parroquia si se seleccionó una
                    if (!"Seleccione una parroquia".equals(parroquia)) {
                        if (!f.getParroquia().equalsIgnoreCase(parroquia)) {
                            continue;
                        }
                    }

                    // Filtrar por código postal si se ingresó uno
                    if (!codigoPostal.isEmpty()) {
                        if (!f.getCodigoPostal().equalsIgnoreCase(codigoPostal)) {
                            continue;
                        }
                    }

                    // Filtrar por estado
                    String estado = f.getEstado();
                    if ((estado.equalsIgnoreCase("Activo") && !mostrarActivos) ||
                            (estado.equalsIgnoreCase("Pendiente") && !mostrarPendientes) ||
                            (estado.equalsIgnoreCase("Finalizado") && !mostrarFinalizados)) {
                        continue;
                    }

                    // Agregar al resultado
                    resultado.append(f.toString()).append("\n");
                }

                // Mostrar resultados en el área de texto
                if (resultado.length() == 0) {
                    txtEstadistica.setText("No se encontraron fallas con los criterios seleccionados");
                } else {
                    txtEstadistica.setText(resultado.toString());
                }
            }

        });
        btnAsignarTrabajador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedulaFallasRegistradas.getText().trim();
                String correoTecnico = txtPonerACargo.getText().trim();

                if (cedula.isEmpty() || correoTecnico.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar cédula y correo de técnico");
                    return;
                }

                // Verificar que el correo pertenece a un técnico
                boolean esTecnico = false;
                for (Usuarios u : registroUsuarios.getListaUsuarios()) {
                    if (u.getCorreo().equalsIgnoreCase(correoTecnico) &&
                            u.getRol().equalsIgnoreCase("tecnico")) {
                        esTecnico = true;
                        break;
                    }
                }

                if (!esTecnico) {
                    JOptionPane.showMessageDialog(null, "El correo no pertenece a un técnico válido");
                    return;
                }

                boolean exito = registroFallas.asignarTecnicoAFalla(cedula, correoTecnico);
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Técnico asignado/actualizado correctamente");
                    btnMostrarFallasRegistradas.doClick(); // Actualizar vista
                    txtPonerACargo.setText(""); // Limpiar campo después de asignar
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron fallas para este usuario");
                }
            }
        });
        ButtonAActivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedulaFallasRegistradas.getText().trim();
                if (cedula.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cédula primero");
                    ButtonPendiente.setSelected(true); // Revierte la selección
                    return;
                }

                boolean exito = registroFallas.cambiarEstadoFalla(cedula, "Activo");
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Estado cambiado a Activo");
                    btnMostrarFallasRegistradas.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado");
                    ButtonPendiente.setSelected(true); // Revierte la selección
                }
            }
        });
        ButtonPendiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedulaFallasRegistradas.getText().trim();
                if (cedula.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cédula primero");
                    return;
                }

                boolean exito = registroFallas.cambiarEstadoFalla(cedula, "Pendiente");
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Estado cambiado a Pendiente");
                    btnMostrarFallasRegistradas.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado");
                    ButtonAActivo.setSelected(true); // Revierte la selección
                }
            }
        });
        ButtonFinalizado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedulaFallasRegistradas.getText().trim();
                if (cedula.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cédula primero");
                    return;
                }
                boolean exito = registroFallas.cambiarEstadoFalla(cedula, "Finalizado");
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Estado cambiado a Finalizado");
                    btnMostrarFallasRegistradas.doClick();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado");

                    ButtonPendiente.setSelected(true);
                }
            }
        });
        BtnMostrarEstadisticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String parroquia = (String) cboBarriosEstadistica.getSelectedItem();
                String codigoPostal = txtEstadisticaCP.getText().trim();

                boolean mostrarActivos = BtaActivoEstadistica.isSelected();
                boolean mostrarPendientes = BtaPendienteEstadistica.isSelected();
                boolean mostrarFinalizados = BtaFinalizadoEstadistica.isSelected();

                if (!mostrarActivos && !mostrarPendientes && !mostrarFinalizados) {
                    mostrarActivos = true;
                    mostrarPendientes = true;
                    mostrarFinalizados = true;
                }

                StringBuilder resultado = new StringBuilder();
                resultado.append("=== ESTADÍSTICAS DE FALLAS ===\n\n");

                int totalFallas = 0;
                int fallasActivas = 0;
                int fallasPendientes = 0;
                int fallasFinalizadas = 0;

                for (Fallas f : registroFallas.getColaFallas()) {
                    if (!"Seleccione una parroquia".equals(parroquia)) {
                        if (!f.getParroquia().equalsIgnoreCase(parroquia)) {
                            continue;
                        }
                    }

                    if (!codigoPostal.isEmpty()) {
                        if (!f.getCodigoPostal().equalsIgnoreCase(codigoPostal)) {
                            continue;
                        }
                    }

                    String estado = f.getEstado();
                    if ((estado.equalsIgnoreCase("Activo") && !mostrarActivos) ||
                            (estado.equalsIgnoreCase("Pendiente") && !mostrarPendientes) ||
                            (estado.equalsIgnoreCase("Finalizado") && !mostrarFinalizados)) {
                        continue;
                    }


                    totalFallas++;
                    if (estado.equalsIgnoreCase("Activo")) fallasActivas++;
                    else if (estado.equalsIgnoreCase("Pendiente")) fallasPendientes++;
                    else if (estado.equalsIgnoreCase("Finalizado")) fallasFinalizadas++;

                    resultado.append(f.toString()).append("\n");
                }

                resultado.append("\n=== RESUMEN ESTADÍSTICO ===\n");
                resultado.append("Total de fallas que coinciden: ").append(totalFallas).append("\n");
                if (mostrarActivos) {
                    resultado.append("Fallas Activas: ").append(fallasActivas).append("\n");
                }
                if (mostrarPendientes) {
                    resultado.append("Fallas Pendientes: ").append(fallasPendientes).append("\n");
                }
                if (mostrarFinalizados) {
                    resultado.append("Fallas Finalizadas: ").append(fallasFinalizadas).append("\n");
                }

                txtEstadistica.setText(resultado.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
