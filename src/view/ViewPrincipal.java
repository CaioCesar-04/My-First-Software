package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerTelaPrincipal;
import controller.ControllerUsuarios;

import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class ViewPrincipal extends JFrame {


	
	private JMenuItem mntmProdutos;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmVendidos;
	private JMenuItem mntmClientes;
	private JMenuItem mntmCadastroVendas;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnProdutos;
	private JButton btnV;
	private JButton btnUsuario;
	/**
	 * Create the frame.
	 */
	public ViewPrincipal() {
		getContentPane().setBackground(new Color(50, 205, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AgroSanches");
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivos = new JMenu("Arquivos");
		menuBar.add(mnArquivos);
		
		JMenuItem mnSair = new JMenuItem("Sair");
		mnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		mnSair.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/app/imagens/sair.png")));
		mnArquivos.add(mnSair);
		
		JMenu mnCadastros = new JMenu("Cadastros");
		menuBar.add(mnCadastros);
		
		mntmClientes = new JMenuItem("Clientes");
		
		mnCadastros.add(mntmClientes);
		
		mntmProdutos = new JMenuItem("Produtos");
		
		mnCadastros.add(mntmProdutos);
		
		mntmUsuarios = new JMenuItem("Usuários");
		
		mnCadastros.add(mntmUsuarios);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		mntmCadastroVendas = new JMenuItem("Cadastro de Vendas");
	
		mnVendas.add(mntmCadastroVendas);
		
		mntmVendidos = new JMenuItem("Consultar Vendas");
	
		mnVendas.add(mntmVendidos);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/app/imagens/fundo.jpeg")));
		lblNewLabel.setBounds(436, 11, 1458, 1008);
		getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("CLIENTES");
		
		btnNewButton.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		btnNewButton.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/app/imagens/clientes.png")));
		btnNewButton.setBounds(72, 125, 236, 69);
		getContentPane().add(btnNewButton);
		
		btnProdutos = new JButton("PRODUTOS");
		btnProdutos.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		btnProdutos.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/app/imagens/produtos.png")));
		btnProdutos.setBounds(72, 348, 236, 69);
		getContentPane().add(btnProdutos);
		
		btnV = new JButton("VENDA");
		btnV.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/app/imagens/vendas.png")));
		btnV.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		btnV.setBounds(72, 548, 236, 69);
		getContentPane().add(btnV);
		
		btnUsuario = new JButton("USUÁRIOS");
		btnUsuario.setFont(new Font("Yu Gothic Medium", Font.BOLD, 18));
		btnUsuario.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/app/imagens/usuarios.png")));
		btnUsuario.setBounds(72, 759, 236, 69);
		getContentPane().add(btnUsuario);
				
	}
	public void addActionListener(ControllerTelaPrincipal controller ) {
		mntmClientes.addActionListener(controller);
		mntmProdutos.addActionListener(controller);
		mntmUsuarios.addActionListener(controller);
		mntmVendidos.addActionListener(controller);
		mntmCadastroVendas.addActionListener(controller);
		btnNewButton.addActionListener(controller);
		btnUsuario.addActionListener(controller);
		btnProdutos.addActionListener(controller);
		btnV.addActionListener(controller);
	}
}
