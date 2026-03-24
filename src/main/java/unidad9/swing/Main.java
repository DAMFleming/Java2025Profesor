package unidad9.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main {
	
	private JFrame frame;
	
	public void crearMostrar() {
        frame = new JFrame("Mi primera aplicación Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container p = frame.getContentPane();
        p.setPreferredSize(new Dimension(900, 700));
        JLabel l = new JLabel("Hola Mundo!");
        l.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        p.add(l, BorderLayout.CENTER);
        JButton b = new JButton("Pulsa aquí");
        p.add(b, BorderLayout.SOUTH);
        b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				l.setText(("Botón pulsado"));
				try {
					Thread.sleep(600000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
        });
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Main()::crearMostrar);
        while(true);
    }
}
