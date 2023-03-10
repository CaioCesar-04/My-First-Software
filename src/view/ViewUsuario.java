package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerUsuarios;
import model.entidades.ModelUsuario;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textCod;
	private JTextField textNome;
	private JTextField textUsername;
	private JTextField textSenha;
	private JTable tableUsuarios;
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnNovo;
	private JButton btnCancelar;
	private JButton btnExcluir;

	ControllerUsuarios controllerUsuarios = new ControllerUsuarios();
	
	ArrayList<ModelUsuario> listaModelUsuarios = new ArrayList<>();
	String salvarAlterar;
	/**
	 * Launch the application.
	 */

	public void carregarUsuarios() {
		listaModelUsuarios = controllerUsuarios.getListaUsuario();
		DefaultTableModel modelo = (DefaultTableModel) getTableUsuarios().getModel();
		modelo.setNumRows(0);
		int cont = listaModelUsuarios.size();
		for(int i =0; i<cont;i++) {
			modelo.addRow(new Object[] {
					listaModelUsuarios.get(i).getId(),
					listaModelUsuarios.get(i).getNome(),
					listaModelUsuarios.get(i).getUsername()
			});
		}
	}
	
	public void limparCampos() {
		getTextCod().setText("");
		getTextNome().setText("");
		getTextSenha().setText("");
		getTextUsername().setText("");
		
	}
	
	public void habilitarCampos(boolean c) {
		
		getTextNome().setEditable(c);
		getTextSenha().setEditable(c);
		getTextUsername().setEditable(c);
			
		
	}

	/**
	 * Create the frame.
	 */
	public ViewUsuario() {
		setTitle("Usuário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 707, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 691, 575);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCod = new JLabel("Código:");
		lblCod.setBounds(10, 11, 62, 26);
		panel.add(lblCod);
		
		setTextCod(new JTextField());
		getTextCod().setEditable(false);
		getTextCod().setBounds(10, 37, 80, 20);
		panel.add(getTextCod());
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(143, 17, 46, 14);
		panel.add(lblNome);
		
		setTextNome(new JTextField());
		getTextNome().setColumns(10);
		getTextNome().setBounds(143, 37, 538, 20);
		panel.add(getTextNome());
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(10, 82, 129, 14);
		panel.add(lblNewLabel);
		
		setTextUsername(new JTextField());
		getTextUsername().setColumns(10);
		getTextUsername().setBounds(10, 107, 391, 20);
		panel.add(getTextUsername());
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(411, 82, 72, 14);
		panel.add(lblNewLabel_1);
		
		setTextSenha(new JTextField());
		getTextSenha().setColumns(10);
		getTextSenha().setBounds(411, 107, 270, 20);
		panel.add(getTextSenha());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 671, 350);
		panel.add(scrollPane);
		
		setTableUsuarios(new JTable());
		getTableUsuarios().setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Username"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		getTableUsuarios().getColumnModel().getColumn(1).setPreferredWidth(351);
		getTableUsuarios().getColumnModel().getColumn(2).setPreferredWidth(233);
		scrollPane.setViewportView(getTableUsuarios());
		
		btnSalvar = new JButton("Salvar");
	
		btnSalvar.setIcon(new ImageIcon(ViewUsuario.class.getResource("/app/imagens/salvar.png")));
		btnSalvar.setBounds(578, 541, 103, 23);
		panel.add(btnSalvar);
		
		btnAlterar = new JButton("Alterar");
	
		btnAlterar.setIcon(new ImageIcon(ViewUsuario.class.getResource("/app/imagens/alterar.png")));
		btnAlterar.setBounds(240, 138, 130, 23);
		panel.add(btnAlterar);
		
		btnNovo = new JButton("Novo");
	
		btnNovo.setIcon(new ImageIcon(ViewUsuario.class.getResource("/app/imagens/novo.png")));
		btnNovo.setBounds(10, 138, 89, 23);
		panel.add(btnNovo);
		
		btnCancelar = new JButton("Cancelar");
	
		btnCancelar.setIcon(new ImageIcon(ViewUsuario.class.getResource("/app/imagens/cancelar.png")));
		btnCancelar.setBounds(109, 138, 121, 23);
		panel.add(btnCancelar);
		
		btnExcluir = new JButton("Excluir");
	
		btnExcluir.setIcon(new ImageIcon(ViewUsuario.class.getResource("/app/imagens/excluir.png")));
		btnExcluir.setBounds(380, 138, 111, 23);
		panel.add(btnExcluir);
		setLocationRelativeTo(null);
		setResizable(false);
		carregarUsuarios();
		habilitarCampos(false);
	}
	public void addActionListener(ControllerUsuarios controllerUsuarios) {
		btnCancelar.addActionListener(controllerUsuarios);
		btnAlterar.addActionListener(controllerUsuarios);
		btnExcluir.addActionListener(controllerUsuarios);
		btnNovo.addActionListener(controllerUsuarios);
		btnSalvar.addActionListener(controllerUsuarios);
		
	}

	public JTable getTableUsuarios() {
		return tableUsuarios;
	}

	public void setTableUsuarios(JTable tableUsuarios) {
		this.tableUsuarios = tableUsuarios;
	}
	public JTextField getTextCod() {
		return textCod;
	}
	public void setTextCod(JTextField textCod) {
		this.textCod = textCod;
	}
	public JTextField getTextNome() {
		return textNome;
	}
	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}
	public JTextField getTextUsername() {
		return textUsername;
	}
	public void setTextUsername(JTextField textUsername) {
		this.textUsername = textUsername;
	}
	public JTextField getTextSenha() {
		return textSenha;
	}
	public void setTextSenha(JTextField textSenha) {
		this.textSenha = textSenha;
	}

	public void msgNotSelected() {
		JOptionPane.showMessageDialog(null,"Nenhum registro selecionado ou código inválido.","ERRO", JOptionPane.WARNING_MESSAGE);
		
	}
}
