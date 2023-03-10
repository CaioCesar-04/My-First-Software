package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControllerClientes;
import controller.ControllerTelaPrincipal;
import model.entidades.ModelCliente;
import javax.swing.JFormattedTextField;

public class ViewCliente extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField textCod;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textCidade;
	private JTextField textCep;
	private JTextField textFone;
	private JTextField textCpfCnpj;
	private JTextField textIE;
	private JTextField textNFazenda;
	private JTable jtCliente;
	private JTextField textEmail;
	private JComboBox comboBoxEstados;
	private JButton jbSalvar;
	private JButton jbAlterar;
	private JButton btnNovo;
	private JButton jbCancelar;
	private JButton btnExcluir;
	
	
	private ControllerClientes controllerClientes = new ControllerClientes();
	
	private ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();

	

	public void carregarClienteTabela() {
		DefaultTableModel modelo = (DefaultTableModel) getJtCliente().getModel();
		listaModelClientes = controllerClientes.listaClientes();
		modelo.setNumRows(0);
		int cont = listaModelClientes.size();
		for(int i = 0;i<cont;i++) {
			modelo.addRow(new Object[] {
					listaModelClientes.get(i).getCodcliente(),
					listaModelClientes.get(i).getNomeCliente(),
					listaModelClientes.get(i).getCpfCnpj(),
					listaModelClientes.get(i).getTelefone(),
					listaModelClientes.get(i).getEndereco(),
					listaModelClientes.get(i).getCep()		
			});
		}
		
	}
	
	public void habilitaCampos(boolean c) {
		getTextCep().setEditable(c);
		getTextCidade().setEditable(c);
		getTextCpfCnpj().setEditable(c);
		getTextEmail().setEditable(c);
		getTextEndereco().setEditable(c);
		getTextFone().setEditable(c);
		getTextIE().setEditable(c);
		getTextNFazenda().setEditable(c);
		getTextNome().setEditable(c);
		getComboBoxEstados().setEditable(c);
	}
	public void limparCampos() {
		getTextCep().setText("");
		getTextCidade().setText("");
		getTextCpfCnpj().setText("");
		getTextEmail().setText("");
		getTextEndereco().setText("");
		getTextFone().setText("");
		getTextIE().setText("");
		getTextNFazenda().setText("");
		getTextNome().setText("");
	}


	public ViewCliente() {
		setTitle("Clientes");
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1155, 755);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1139, 716);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel codCliente = new JLabel("Código:");
		codCliente.setBounds(17, 11, 79, 24);
		panel.add(codCliente);
		
		setTextCod(new JTextField());
		getTextCod().setEditable(false);
		getTextCod().setBounds(17, 37, 79, 20);
		panel.add(getTextCod());
		getTextCod().setColumns(10);
		
		JLabel lblNome = new JLabel(" Nome:");
		lblNome.setBounds(17, 99, 46, 14);
		panel.add(lblNome);
		
		setTextNome(new JTextField());
		getTextNome().setEditable(false);
		getTextNome().setBounds(17, 124, 536, 20);
		panel.add(getTextNome());
		getTextNome().setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(17, 155, 86, 24);
		panel.add(lblEndereco);
		
		setTextEndereco(new JTextField());
		getTextEndereco().setEditable(false);
		getTextEndereco().setBounds(14, 190, 372, 20);
		panel.add(getTextEndereco());
		getTextEndereco().setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(410, 165, 46, 14);
		panel.add(lblCidade);
		
		setTextCidade(new JTextField());
		getTextCidade().setEditable(false);
		getTextCidade().setBounds(410, 190, 142, 20);
		panel.add(getTextCidade());
		getTextCidade().setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("UF:");
		lblNewLabel_4.setBounds(574, 165, 46, 14);
		panel.add(lblNewLabel_4);
		
	    setComboBoxEstados(new JComboBox());
		getComboBoxEstados().setModel(new DefaultComboBoxModel(new String[] {"AC", "AL ", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		getComboBoxEstados().setToolTipText("");
		getComboBoxEstados().setBounds(574, 189, 60, 22);
		panel.add(getComboBoxEstados());
		
		setTextCep(new JTextField());
		getTextCep().setEditable(false);
		getTextCep().setBounds(705, 190, 141, 20);
		panel.add(getTextCep());
		getTextCep().setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(705, 165, 46, 14);
		panel.add(lblCep);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(886, 165, 121, 14);
		panel.add(lblTelefone);
		
		setTextFone(new JTextField());
		getTextFone().setEditable(false);
		getTextFone().setBounds(888, 190, 201, 20);
		panel.add(getTextFone());
		getTextFone().setColumns(10);
		
		JLabel lblCpfCnpj = new JLabel("CPF/CNPJ:");
		lblCpfCnpj.setBounds(17, 225, 72, 36);
		panel.add(lblCpfCnpj);
		
		setTextCpfCnpj(new JTextField());
		getTextCpfCnpj().setEditable(false);
		getTextCpfCnpj().setBounds(17, 259, 369, 20);
		panel.add(getTextCpfCnpj());
		getTextCpfCnpj().setColumns(10);
		
		JLabel lblIe = new JLabel("Inscrição Estadual:");
		lblIe.setBounds(410, 236, 179, 14);
		panel.add(lblIe);
		
		setTextIE(new JTextField());
		getTextIE().setEditable(false);
		getTextIE().setBounds(410, 259, 224, 20);
		panel.add(getTextIE());
		getTextIE().setColumns(10);
		
		JLabel lblNfazenda = new JLabel("Nome da Fazenda:");
		lblNfazenda.setBounds(705, 236, 187, 14);
		panel.add(lblNfazenda);
		
		setTextNFazenda(new JTextField());
		getTextNFazenda().setEditable(false);
		getTextNFazenda().setBounds(709, 259, 380, 20);
		panel.add(getTextNFazenda());
		getTextNFazenda().setColumns(10);
		
		jbSalvar = new JButton("Salvar");
		
		jbSalvar.setIcon(new ImageIcon(ViewCliente.class.getResource("/app/imagens/salvar.png")));
		jbSalvar.setBounds(1025, 682, 104, 23);
		panel.add(jbSalvar);
		
		jbAlterar = new JButton("Alterar");
		
		jbAlterar.setIcon(new ImageIcon(ViewCliente.class.getResource("/app/imagens/alterar.png")));
		jbAlterar.setBounds(247, 290, 130, 23);
		panel.add(jbAlterar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 339, 1112, 326);
		panel.add(scrollPane);
		
		setJtCliente(new JTable());
		getJtCliente().setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "CPF/CNPJ", "Contato", "Endere\u00E7o", "CEP"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		getJtCliente().getColumnModel().getColumn(0).setPreferredWidth(50);
		getJtCliente().getColumnModel().getColumn(0).setMinWidth(30);
		getJtCliente().getColumnModel().getColumn(1).setPreferredWidth(133);
		getJtCliente().getColumnModel().getColumn(4).setPreferredWidth(243);
		scrollPane.setViewportView(getJtCliente());
		
		btnNovo = new JButton("Novo");
		
		btnNovo.setIcon(new ImageIcon(ViewCliente.class.getResource("/app/imagens/novo.png")));
		btnNovo.setBounds(17, 290, 89, 23);
		panel.add(btnNovo);
		
		jbCancelar = new JButton("Cancelar");
	
		jbCancelar.setIcon(new ImageIcon(ViewCliente.class.getResource("/app/imagens/cancelar.png")));
		jbCancelar.setBounds(116, 290, 121, 23);
		panel.add(jbCancelar);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(563, 99, 46, 14);
		panel.add(lblNewLabel);
		
		setTextEmail(new JTextField());
		getTextEmail().setEditable(false);
		getTextEmail().setBounds(563, 124, 526, 20);
		panel.add(getTextEmail());
		getTextEmail().setColumns(10);
		
		btnExcluir = new JButton("Excluir");
		
		btnExcluir.setIcon(new ImageIcon(ViewCliente.class.getResource("/app/imagens/excluir.png")));
		btnExcluir.setBounds(387, 290, 111, 23);
		panel.add(btnExcluir);
		
		setLocationRelativeTo(null);
		
		 carregarClienteTabela();
	}
	public void addActionListener(ControllerClientes controller ) {
		jbSalvar.addActionListener(controller);
		btnExcluir.addActionListener(controller);
		jbCancelar.addActionListener(controller);
		jbAlterar.addActionListener(controller);
		btnNovo.addActionListener(controller);
	}
	public void msgInserido() {
		JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso.", "Inserido",JOptionPane.INFORMATION_MESSAGE);
	}
	public void msgInseridoErro() {
		JOptionPane.showMessageDialog(null, "Não foi possível inserir o cliente.", "Erro",JOptionPane.ERROR_MESSAGE);
	}
	public void msgAlterado() {
		JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.", "Inserido",JOptionPane.INFORMATION_MESSAGE);
	}
	public void msgAlteradoErro() {
		JOptionPane.showMessageDialog(null, "Não foi possível alterar o cliente.", "Erro",JOptionPane.ERROR_MESSAGE);
	}
	public void msgNotSelected() {
		JOptionPane.showMessageDialog(null,"Nenhum registro selecionado ou código inválido.","ERRO", JOptionPane.WARNING_MESSAGE);
	}
	public void msgDeletado() {
		JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso","Deletado",JOptionPane.INFORMATION_MESSAGE);
	}
	public void msgDeletadoErro() {
		JOptionPane.showMessageDialog(null, "Não foi possível deletar o cliente.","Erro",JOptionPane.ERROR_MESSAGE);
	}
	public JTable getJtCliente() {
		return jtCliente;
	}
	public void setJtCliente(JTable jtCliente) {
		this.jtCliente = jtCliente;
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
	public JTextField getTextEndereco() {
		return textEndereco;
	}
	public void setTextEndereco(JTextField textEndereco) {
		this.textEndereco = textEndereco;
	}
	public JTextField getTextCidade() {
		return textCidade;
	}
	public void setTextCidade(JTextField textCidade) {
		this.textCidade = textCidade;
	}
	public JTextField getTextCep() {
		return textCep;
	}
	public void setTextCep(JTextField textCep) {
		this.textCep = textCep;
	}
	public JTextField getTextFone() {
		return textFone;
	}
	public void setTextFone(JTextField textFone) {
		this.textFone = textFone;
	}
	public JTextField getTextCpfCnpj() {
		return textCpfCnpj;
	}
	public void setTextCpfCnpj(JTextField textCpfCnpj) {
		this.textCpfCnpj = textCpfCnpj;
	}
	public JTextField getTextIE() {
		return textIE;
	}
	public void setTextIE(JTextField textIE) {
		this.textIE = textIE;
	}
	public JTextField getTextNFazenda() {
		return textNFazenda;
	}
	public void setTextNFazenda(JTextField textNFazenda) {
		this.textNFazenda = textNFazenda;
	}
	public JTextField getTextEmail() {
		return textEmail;
	}
	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}
	public JComboBox getComboBoxEstados() {
		return comboBoxEstados;
	}
	public void setComboBoxEstados(JComboBox comboBoxEstados) {
		this.comboBoxEstados = comboBoxEstados;
	}
	
}
