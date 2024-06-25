package sistemafacturacionformulario;

import javax.swing.*;
import sistemafacturacionmodelo.Cliente;
import java.util.ArrayList;

public class FRMCrearCliente extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private ArrayList<Cliente> clientes;

    public FRMCrearCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;

        setTitle("Nuevo Cliente");
        setBounds(100, 100, 450, 300);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(null);

        JLabel lblCedula = new JLabel("Cédula");
        lblCedula.setBounds(21, 24, 69, 13);
        getContentPane().add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(100, 21, 198, 19);
        getContentPane().add(txtCedula);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(21, 60, 69, 13);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 57, 198, 19);
        getContentPane().add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(21, 96, 69, 13);
        getContentPane().add(lblApellido);

        txtApellido = new JTextField();
        txtApellido.setBounds(100, 93, 198, 19);
        getContentPane().add(txtApellido);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 122, 85, 21);
        btnGuardar.addActionListener(e -> guardarCliente());
        getContentPane().add(btnGuardar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 122, 85, 21);
        btnCancelar.addActionListener(e -> dispose());
        getContentPane().add(btnCancelar);
    }

    private void guardarCliente() {
        if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(txtCedula.getText(), txtNombre.getText(), txtApellido.getText());
        clientes.add(cliente);
        JOptionPane.showMessageDialog(this, "Cliente guardado correctamente.");
        dispose();
    }
}


