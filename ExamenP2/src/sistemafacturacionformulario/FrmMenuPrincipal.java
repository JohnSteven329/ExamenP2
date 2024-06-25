package sistemafacturacionformulario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import sistemafacturacionmodelo.Cliente;
import sistemafacturacionmodelo.Producto;

public class FrmMenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JDesktopPane desktopPane;
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;

    public FrmMenuPrincipal() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();

        setTitle("Sistema de Facturación Electrónica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menú Archivo
        JMenu mnArchivo = new JMenu("Archivo");
        mnArchivo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnArchivo);

        JMenuItem mntmSalir = new JMenuItem("Salir");
        mntmSalir.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mntmSalir.addActionListener(e -> System.exit(0));
        mnArchivo.add(mntmSalir);

        // Menú Clientes
        JMenu mnClientes = new JMenu("Clientes");
        mnClientes.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnClientes);

        JMenuItem mntmNuevoCliente = new JMenuItem("Nuevo Cliente");
        mntmNuevoCliente.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mntmNuevoCliente.addActionListener(e -> abrirFormularioCliente());
        mnClientes.add(mntmNuevoCliente);

        // Menú Productos
        JMenu mnProductos = new JMenu("Productos");
        mnProductos.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnProductos);

        JMenuItem mntmNuevoProducto = new JMenuItem("Nuevo Producto");
        mntmNuevoProducto.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mntmNuevoProducto.addActionListener(e -> abrirFormularioProducto());
        mnProductos.add(mntmNuevoProducto);

        // Menú Facturas
        JMenu mnFacturas = new JMenu("Facturas");
        mnFacturas.setFont(new Font("Segoe UI", Font.BOLD, 16));
        menuBar.add(mnFacturas);

        JMenuItem mntmFacturar = new JMenuItem("Facturar");
        mntmFacturar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        mntmFacturar.addActionListener(e -> abrirFormularioFacturar());
        mnFacturas.add(mntmFacturar);

        // Contenido principal
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout()); 
        setContentPane(contentPane);

        desktopPane = new JDesktopPane();
        contentPane.add(desktopPane, BorderLayout.CENTER); 
    }

    private void abrirFormularioCliente() {
        FRMCrearCliente frmCrearCliente = new FRMCrearCliente(clientes);
        desktopPane.add(frmCrearCliente);
        frmCrearCliente.setVisible(true);
    }

    private void abrirFormularioProducto() {
        FRMCrearProducto frmCrearProducto = new FRMCrearProducto(productos);
        desktopPane.add(frmCrearProducto);
        frmCrearProducto.setVisible(true);
    }

    private void abrirFormularioFacturar() {
        FRMFacturar frmFacturar = new FRMFacturar(clientes, productos);
        desktopPane.add(frmFacturar);
        frmFacturar.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FrmMenuPrincipal frame = new FrmMenuPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}