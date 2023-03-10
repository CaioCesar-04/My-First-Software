 package view;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControllerLogin;
import controller.ControllerUsuarios;
import model.entidades.ModelUsuario;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JPanel panel_1;
	private JButton btnSalvaLogin;
	
	
			
			
	public ViewLogin() {
		
		
		setResizable(false);
		
		setTitle("AGROSANCHES");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 488, 76);
		
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Login de Acesso");
		labelTitulo.setBounds(112, 11, 266, 54);
		panel.add(labelTitulo);
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setBackground(new Color(255, 255, 255));
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 36));
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 73, 488, 328);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelExem = new JLabel("Entre com suas credenciais");
		labelExem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelExem.setHorizontalAlignment(SwingConstants.CENTER);
		labelExem.setBounds(112, 11, 268, 33);
		
		panel_1.add(labelExem);
		
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setBounds(125, 125, 67, 14);
		panel_1.add(labelSenha);
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelSenha.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton outButton = new JButton("Sair");
		outButton.setBackground(new Color(217, 81, 51));
		outButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		outButton.setForeground(Color.WHITE);
		outButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		outButton.setFocusPainted(false);
		outButton.setBorderPainted(false);
		outButton.setBounds(125, 270, 242, 34);
		panel_1.add(outButton);
		
		loginButton = new JButton("Entrar");
		
		
		loginButton.setBounds(125, 225, 242, 34);
		panel_1.add(loginButton);
		loginButton.setBackground(new Color(58, 65, 84));
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		loginButton.setBorderPainted(false);
		loginButton.setFocusPainted(false);
		
		JLabel labelUsuario = new JLabel("Usuário:");
		labelUsuario.setBounds(122, 55, 62, 14);
		panel_1.add(labelUsuario);
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		
		setTextUser(new JTextField());
		getTextUser().setColumns(10);
		
		setPasswordField(new JPasswordField());
		
		btnSalvaLogin = new JButton("Último login");
		btnSalvaLogin.setIcon(new ImageIcon(ViewLogin.class.getResource("/app/imagens/entrar.png")));
		btnSalvaLogin.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalvaLogin.setBounds(125, 195, 242, 23);
		panel_1.add(btnSalvaLogin);
		
		setLocationRelativeTo(null);
	}
	public void addActionListener(ControllerLogin controller ) {
		loginButton.addActionListener(controller);
		btnSalvaLogin.addActionListener(controller);
	}
	
	
	public JTextField getTextUser() {
		return textUser;
	}
	public void setTextUser(JTextField textUser) {
		this.textUser = textUser;
		textUser.setBounds(125, 80, 242, 34);
		panel_1.add(textUser);
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
		passwordField.setBounds(125, 150, 242, 34);
		panel_1.add(passwordField);
	}
	public void msgErroLogin() {
		JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos", "ERRO", JOptionPane.ERROR_MESSAGE);		
	}
	public void msgErro(String erroMsg) {
		JOptionPane.showMessageDialog(null, erroMsg, "ERRO", JOptionPane.ERROR_MESSAGE);	
	}
	
	
	
}

