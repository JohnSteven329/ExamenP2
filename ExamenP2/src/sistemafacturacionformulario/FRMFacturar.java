package sistemafacturacionformulario;

import javax.swing.*;
import sistemafacturacionmodelo.Cliente;
import sistemafacturacionmodelo.Producto;
import java.util.ArrayList;

public class FRMFacturar extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JComboBox<Cliente> cmbClientes;
    private JComboBox<Producto> cmbProductos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;

    public FRMFacturar(ArrayList<Cliente> clientes, ArrayList<Producto> productos) {
        this.clientes = clientes;
        this.productos = productos;

        setTitle("Facturar");
        setBounds(100, 100, 450, 300);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(null);

        JLabel lblCliente = new JLabel("Cliente");
        lblCliente.setBounds(21, 24, 69, 13);
        getContentPane().add(lblCliente);

        cmbClientes = new JComboBox<>();
        cmbClientes.setBounds(100, 21, 198, 21);
        getContentPane().add(cmbClientes);

        JLabel lblProducto = new JLabel("Producto");
        lblProducto.setBounds(21, 60, 69, 13);
        getContentPane().add(lblProducto);

        cmbProductos = new JComboBox<>();
        cmbProductos.setBounds(100, 57, 198, 21);
        getContentPane().add(cmbProductos);

        JButton btnFacturar = new JButton("Facturar");
        btnFacturar.setBounds(100, 122, 85, 21);
        btnFacturar.addActionListener(e -> facturar());
        getContentPane().add(btnFacturar);

        actualizarCombos();
    }

    private void actualizarCombos() {
        cmbClientes.removeAllItems();
        for (Cliente cliente : clientes) {
            cmbClientes.addItem(cliente);
        }

        cmbProductos.removeAllItems();
        for (Producto producto : productos) {
            cmbProductos.addItem(producto);
        }
    }

    private void facturar() {
        Cliente cliente = (Cliente) cmbClientes.getSelectedItem();
        Producto producto = (Producto) cmbProductos.getSelectedItem();
        if (cliente != null && producto != null) {
            JOptionPane.showMessageDialog(this, "Factura creada para " + cliente.getNombre() + " con el producto " + producto.getDescripcion());
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente y un producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}


