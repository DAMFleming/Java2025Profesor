package unidad9.swing.multicontador;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main extends WindowAdapter {
	
	private JFrame frame;
	
	Main(String[] args) {
        frame = new JFrame("Multi-Contador");
        frame.addWindowListener(this);
        frame.getContentPane().setLayout(new GridLayout(0, 1));
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ContadorGlobal cg;
        cg = new ContadorGlobal();
        ContadorParcial cp;
        frame.add(cp = new ContadorParcial(cg));
        cg.addContadorParcial(cp);
        frame.add(cp = new ContadorParcial(cg));
        cg.addContadorParcial(cp);
        frame.add(cp = new ContadorParcial(cg));
        cg.addContadorParcial(cp);
        frame.add(cg);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> new Main(args).show());
    }

	@Override
	public void windowClosing(WindowEvent e) {
		int respuesta = JOptionPane.showConfirmDialog(frame, "¿Está seguro de que quiere cerrar la aplicación?");
		if (respuesta == JOptionPane.YES_OPTION)
			System.exit(0);
	}

}
