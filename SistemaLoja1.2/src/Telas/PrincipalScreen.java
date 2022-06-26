package Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalScreen {
	private final JDesktopPane desktopPane = new JDesktopPane();
	private JFrame principalScFram;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalScreen ps= new PrincipalScreen();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	public PrincipalScreen() {
		principalScFram = new JFrame();
		principalScFram.setResizable(false);
		
		principalScFram.setTitle("Controlo de Ordem de Serviço");
		principalScFram.getContentPane().setLayout(null);
		
		principalScFram.setBounds(100, 100, 1034, 519);
		principalScFram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		principalScFram.setJMenuBar(menuBar);
		
		JMenu cadastro = new JMenu("Cadastro");
		cadastro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(cadastro);
		
		JMenuItem clientes = new JMenuItem("Clientes");
		clientes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cadastro.add(clientes);
		
		JMenuItem ordemServ = new JMenuItem("Ordem Servi\u00E7o");
		ordemServ.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cadastro.add(ordemServ);
		
		JMenuItem usuario = new JMenuItem("Usu\u00E1rios");
		usuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cadastro.add(usuario);
		
		JMenu relatorio = new JMenu("Relat\u00F3rio");
		relatorio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(relatorio);
		
		JMenuItem servicos = new JMenuItem("Servi\u00E7os");
		servicos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		relatorio.add(servicos);
		
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(ajuda);
		
		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SobreInfo sobre = new SobreInfo();
				sobre.visivel(sobre);
				principalScFram.setVisible(false);
			}
		});
		sobre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		ajuda.add(sobre);
		
		JMenu opcoes = new JMenu("Op\u00E7oes");
		opcoes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(opcoes);
		
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sair= JOptionPane.showConfirmDialog(null,"Tem a certeza que deseja sair? ", "Atençao", JOptionPane.YES_NO_OPTION);
				if(sair == JOptionPane.YES_OPTION) {
					System.exit(0);
				} 
			}
		});
		sair.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		opcoes.add(sair);
		
		desktopPane.setBounds(10, 11, 597, 441);
		principalScFram.getContentPane().add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PrincipalScreen.class.getResource("/icons/x.png")));
		lblNewLabel.setBounds(698, 242, 204, 210);
		principalScFram.getContentPane().add(lblNewLabel);
		
		JLabel lblUtilizadorAtual = new JLabel("Utilizador");
		lblUtilizadorAtual.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUtilizadorAtual.setBounds(617, 33, 108, 26);
		principalScFram.getContentPane().add(lblUtilizadorAtual);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblData.setBounds(618, 125, 349, 26);
		principalScFram.getContentPane().add(lblData);
		
		principalScFram.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				//Para Mostrar data e hora do sistema quando a janela é aberta
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);	//caso queira somente uma parte(só a data)
			//	lblData.setText(formatador.format(data));								//Adiciono desta forma
				lblData.setText(data.toString());
				
			}
		});
		
		principalScFram.setVisible(true);
		

		
	}
}
