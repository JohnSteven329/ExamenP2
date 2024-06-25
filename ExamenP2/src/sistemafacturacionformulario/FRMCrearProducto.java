package sistemafacturacionformulario;

import javax.swing.*;
import sistemafacturacionmodelo.Producto;
import java.util.ArrayList;

public class FRMCrearProducto extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtCodigo;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private ArrayList<Producto> productos;

    public FRMCrearProducto(ArrayList<Producto> productos) {
        this.productos = productos;

        setTitle("Nuevo Producto");
        setBounds(100, 100, 450, 300);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(null);

        JLabel lblCodigo = new JLabel("Código");
        lblCodigo.setBounds(21, 24, 69, 13);
        getContentPane().add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(100, 21, 198, 19);
        getContentPane().add(txtCodigo);

        JLabel lblDescripcion = new JLabel("Descripción");
        lblDescripcion.setBounds(21, 60, 69, 13);
        getContentPane().add(lblDescripcion);

        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(100, 57, 198, 19);
        getContentPane().add(txtDescripcion);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(21, 96, 69, 13);
        getContentPane().add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(100, 93, 198, 19);
        getContentPane().add(txtPrecio);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 122, 85, 21);
        btnGuardar.addActionListener(e -> guardarProducto());
        getContentPane().add(btnGuardar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 122, 85, 21);
        btnCancelar.addActionListener(e -> dispose());
        getContentPane().add(btnCancelar);
        
    }

    private void guardarProducto() {
        if (txtCodigo.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double precio = Double.parseDouble(txtPrecio.getText());
            Producto producto = new Producto(txtCodigo.getText(), txtDescripcion.getText(), precio);
            productos.add(producto);
            JOptionPane.showMessageDialog(this, "Producto guardado correctamente.");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}



