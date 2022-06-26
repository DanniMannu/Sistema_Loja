package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SobreInfo {

	private JFrame frameSobre;
	private PrincipalScreen ps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SobreInfo window = new SobreInfo();
					visivel(window);
				//	window.frameSobre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void visivel(SobreInfo w) {
		w.frameSobre.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public SobreInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSobre = new JFrame();
		frameSobre.setTitle("Sobre");
		frameSobre.setBounds(100, 100, 613, 469);
		frameSobre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSobre.getContentPane().setLayout(null);
		
		JLabel descricao1 = new JLabel("Sistema para controle de de ordens de servi\u00E7os");
		descricao1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		descricao1.setBounds(8, 59, 552, 38);
		frameSobre.getContentPane().add(descricao1);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ps= new PrincipalScreen();
				frameSobre.setVisible(false);
			}
		});
		voltar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		voltar.setBounds(448, 341, 112, 38);
		frameSobre.getContentPane().add(voltar);
		
		JLabel descricao = new JLabel("Desenvolvido por Daniela Manuela, seguindo determinado tutorial elaborado pelo professor Jos\u00E9 de Assis.");
		descricao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		descricao.setBounds(10, 85, 579, 48);
		frameSobre.getContentPane().add(descricao);
	}
}
