package unidad9.swing.multicontador;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	private JFrame frame;
	
	Main(String[] args) {
        frame = new JFrame("Multi-Contador");
        frame.getContentPane().setLayout(new GridLayout(0, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
