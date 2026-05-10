package unidad8.gestiontrabajadores;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.DefaultDesktopManager;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	private JMenuBar menuBar;
	private FormularioMDI activo;
	private FormularioMDI formAltas;
	private FormularioMDI formConsultas;
	private JFileChooser fc = new JFileChooser();
	private File file;

	private Main() {
		super("Gestión de Trabajadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crearGUI();
		pack();
		setLocationRelativeTo(null);
	}
	
	private void crearGUI() {
		try {
			JDesktopPane desktop = new JDesktopPane();
			desktop.setDesktopManager(new DefaultDesktopManager());
			
			activo = formAltas = addInternalForm(desktop, "Alta", new PanelAltas(this));
			formConsultas = addInternalForm(desktop, "Consulta", new PanelConsultas(this));
			
			desktop.setPreferredSize(new Dimension(formAltas.getWidth(), formAltas.getHeight()));
			add(desktop, BorderLayout.CENTER);
			
			addMenuPrincipal();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	private FormularioMDI addInternalForm(JDesktopPane dp, String titulo, Panel panel) throws PropertyVetoException {
		FormularioMDI f = new FormularioMDI(titulo, panel);
		f.setVisible(true);
		f.setMaximum(true);
		dp.add(f, JDesktopPane.DEFAULT_LAYER);
		return f;
	}
	
	private void addMenuPrincipal() {
		menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Archivo");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("menú de archivo");
		menuBar.add(menu);
		
		JMenuItem item = new JMenuItem("Abrir", KeyEvent.VK_B);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
		item.getAccessibleContext().setAccessibleDescription("abrir fichero");
		item.addActionListener(this::abrir);
		menu.add(item);
		
		item = new JMenuItem("Cerrar", KeyEvent.VK_R);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		item.getAccessibleContext().setAccessibleDescription("cerrar fichero");
		item.addActionListener(this::cerrar);
		item.setEnabled(false);
		menu.add(item);
		
		item = new JMenuItem("Salir", KeyEvent.VK_S);
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		item.getAccessibleContext().setAccessibleDescription("salir de la aplicación");
		menu.add(item);

		menu = new JMenu("Ver");
		menu.setMnemonic(KeyEvent.VK_V);
		menu.getAccessibleContext().setAccessibleDescription("menú ver");
		menuBar.add(menu);

		item = new JMenuItem("Altas", KeyEvent.VK_T);
		item.setActionCommand("altas");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
		item.getAccessibleContext().setAccessibleDescription("altas de trabajadores");
		item.addActionListener(this::cambiarFormulario);
		item.setEnabled(false);
		menu.add(item);
		
		item = new JMenuItem("Consultas", KeyEvent.VK_C);
		item.setActionCommand("consultas");
		item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
		item.getAccessibleContext().setAccessibleDescription("consulta datos de trabajadores");
		item.addActionListener(this::cambiarFormulario);
		menu.add(item);
		
		setJMenuBar(menuBar);
	}
	
	private void cambiarFormulario(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "altas":
			activo = formAltas;
			break;
		case "consultas":
			activo = formConsultas;
			break;
		}
		activo.toFront();
		activo.setSelected(true);
		menuBar.getMenu(1).getMenuComponent(0).setEnabled(activo == formConsultas);
		menuBar.getMenu(1).getMenuComponent(1).setEnabled(activo == formAltas);
	}
	
	private void abrir(ActionEvent e) {
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			formAltas.setEnabled(true);
			formConsultas.setEnabled(true);
			activo.setSelected(true);
		}
		menuBar.getMenu(0).getMenuComponent(1).setEnabled(true);
	}
	
	private void cerrar(ActionEvent e) {
		formAltas.setEnabled(false);
		formAltas.limipiar();
		formConsultas.setEnabled(false);
		formConsultas.limipiar();
		menuBar.getMenu(0).getMenuComponent(1).setEnabled(false);
	}
	
	public File getFile() {
		return file;
	}
	
	public ExecutorService getExecutorService() {
		return executorService;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Main().setVisible(true));
	}

}
