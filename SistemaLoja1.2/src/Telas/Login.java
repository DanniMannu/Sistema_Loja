package Telas;

import java.awt.EventQueue;
import java.sql.*;
import camada_acesso_dados.ModuloConexaoBD;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login {
	Connection conexao=null;
	PreparedStatement pst=null; 	//Biblioteca para manipular sql
	ResultSet rs= null;				//vai exibir os resultados das instrucoes que vamos usar no sql 
	
	private JFrame frmSSystem;
	private JTextField username;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel screenStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmSSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		conexao= ModuloConexaoBD.conector();
		System.out.println(conexao);  //se for null não conectou
		if(conexao != null) {
			screenStatus.setText("Conectado ao BD");
		} else screenStatus.setText("Nao Conectado ao BD");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSSystem = new JFrame();
		frmSSystem.setResizable(false);
		frmSSystem.setTitle("S System-Login");
		frmSSystem.setBounds(100, 100, 450, 300);
		frmSSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSSystem.getContentPane().setLayout(null);
		
		JLabel userl = new JLabel("Usu\u00E1rio");
		userl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		userl.setBounds(42, 40, 114, 25);
		frmSSystem.getContentPane().add(userl);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(42, 99, 114, 25);
		frmSSystem.getContentPane().add(lblSenha);
		
		username = new JTextField();
		username.setBounds(122, 44, 219, 20);
		frmSSystem.getContentPane().add(username);
		username.setColumns(10);
		
		JButton btn_login = new JButton("Login");
		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_login.setBounds(252, 169, 89, 23);
		frmSSystem.getContentPane().add(btn_login);
		
		btn_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logar();		
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(122, 114, 219, -18);
		frmSSystem.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(122, 103, 219, 20);
		frmSSystem.getContentPane().add(passwordField_1);
		
		screenStatus = new JLabel("Status");
		screenStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		screenStatus.setBounds(42, 173, 114, 14);
		frmSSystem.getContentPane().add(screenStatus);
	}
	
	public void logar() {
		String sql="select * from users where login=? and senha=?";
		try {
			//as linhas abaixo preparam a consulta ao bd em funcao do
			//que foi digitado nos campos de preenchimento usuario e password
			pst= conexao.prepareStatement(sql);
			pst.setString(1, username.getText());
			pst.setString(2, passwordField_1.getText()); //esta riscado por ser do tipo password
			//a linha abaixo executa a query sql
			rs=pst.executeQuery(); 
			
			if(rs.next()) { //se existir o usuario e password
				PrincipalScreen principal= new PrincipalScreen();
	//			principal.setVisible(true);
				frmSSystem.setVisible(false);
				conexao.close();
			} else {
				JOptionPane.showMessageDialog(null, "invalid user or password");
			}
			
		} catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
	}
}
