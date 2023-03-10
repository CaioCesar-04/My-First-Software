package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.ControllerProdutos;
import model.entidades.ModelProdutos;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;

public class ViewProduto extends JFrame  {
	


	private JPanel contentPane;
	private JTextField textCodProduto;
	private JTextField textPnome;
	private JTextField textEstoque;
	private JTextField textPvista;
	private JFormattedTextField textPprazo;
	private JTable tableProdutos;
	private JTextField textEspecificacoes;
	private JTextField textPesquisa;
	private JButton salvarButton;
	private JButton searchButton;
	private JButton deleteButton;
	private JButton newButton;
	private JButton cancelButton;
	private JButton alterButton;
	
	ArrayList<ModelProdutos> listaModelProduto = new ArrayList();
	ControllerProdutos controllerProdutos = new ControllerProdutos();
	
	private String salvarAlterar;
	
	/**
	 * coloca os produtos na tabela de produtos
	 */
	public void carregarProdutosTabela() {
		listaModelProduto = controllerProdutos.listaProdutos();
		DefaultTableModel modelo = (DefaultTableModel) tableProdutos.getModel();
		modelo.setNumRows(0);
		//inserir produtos
		int cont = listaModelProduto.size();
		for(int i = 0;i<cont;i++) {
			modelo.addRow(new Object[] {
					listaModelProduto.get(i).getCodProduto(),
					listaModelProduto.get(i).getProNome(),
					listaModelProduto.get(i).getQtdEstoque(),
					listaModelProduto.get(i).getPrecoVista(),
					listaModelProduto.get(i).getPrecoPrazo(),
					listaModelProduto.get(i).getProEspecificacoes()
											
			});
		}
	}
	
	/**
	 * habilita e desabilita a digitação nos campos
	 */
	public void habilitaCampos(boolean c) {
		getTextEspecificacoes().setEditable(c);
		getTextPnome().setEditable(c);
		getTextPprazo().setEditable(c);
		getTextPvista().setEditable(c);
		getTextEstoque().setEditable(c);
	}

	
	/**
	 * limpar os campos do formulario
	 * @param c
	 */
	public void limparCampos() {
		getTextEspecificacoes().setText("");
		getTextEstoque().setText("");
		getTextPnome().setText("");
		getTextPprazo().setText("");
		getTextPvista().setText("");
		getTextCodProduto().setText("");
	}
	public void msgInserido() {
		JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Inserido",JOptionPane.INFORMATION_MESSAGE);
	}
	public void msgInseridoErro() {
		JOptionPane.showMessageDialog(null, "Não foi possível inserir o produto.", "Erro",JOptionPane.ERROR_MESSAGE);
	}
	public void msgAlterado() {
		JOptionPane.showMessageDialog(null, "Produto alterado com sucesso.","Alterado",JOptionPane.INFORMATION_MESSAGE);
	}
	public void msgAlteradoErro() {
		JOptionPane.showMessageDialog(null, "Não foi possível alterar o produto","Erro",JOptionPane.ERROR_MESSAGE);
	}
	public void msgDeletado() {
		JOptionPane.showMessageDialog(null, "Produto deletado com sucesso","Deletado",JOptionPane.INFORMATION_MESSAGE);
	}
	public void msgDeletadoErro() {
		JOptionPane.showMessageDialog(null, "Não foi possível deletar o produto.","Erro",JOptionPane.ERROR_MESSAGE);
	}
	public void msgNotSelected() {
		JOptionPane.showMessageDialog(null,"Nenhum registro selecionado ou código inválido.","ERRO", JOptionPane.WARNING_MESSAGE);
	}
	public void msgErro(String msgErro) {
		JOptionPane.showMessageDialog(null,msgErro,"ERRO", JOptionPane.WARNING_MESSAGE);
	}
	
	

	/**
	 * Launch the application.
	 */
	
	public ViewProduto() {
		setTitle("Produtos");
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 944, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 935, 710);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(36, 26, 46, 14);
		panel.add(lblCodigo);
		
		setTextCodProduto(new JTextField());
		getTextCodProduto().setEditable(false);
		getTextCodProduto().setBounds(34, 51, 80, 20);
		panel.add(getTextCodProduto());
		getTextCodProduto().setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(162, 26, 46, 14);
		panel.add(lblNome);
		
		setTextPnome(new JTextField());
		getTextPnome().setBounds(162, 51, 720, 20);
		panel.add(getTextPnome());
		getTextPnome().setColumns(10);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setBounds(36, 120, 78, 14);
		panel.add(lblEstoque);
		
		setTextEstoque(new JTextField());
		getTextEstoque().setEditable(false);
		getTextEstoque().setBounds(36, 145, 78, 20);
		panel.add(getTextEstoque());
		getTextEstoque().setColumns(10);
		
		JLabel lblPrecoV = new JLabel("Preço à vista:");
		lblPrecoV.setBounds(162, 120, 80, 14);
		panel.add(lblPrecoV);
		
		setTextPvista(new JTextField());
		getTextPvista().setBounds(162, 145, 102, 20);
		panel.add(getTextPvista());
		getTextPvista().setColumns(10);
		
		JLabel lblPrecoP = new JLabel("Preço a prazo:");
		lblPrecoP.setBounds(278, 120, 98, 14);
		panel.add(lblPrecoP);
		
		setTextPprazo(new JFormattedTextField());
		getTextPprazo().setBounds(274, 145, 102, 20);
		panel.add(getTextPprazo());
		getTextPprazo().setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 252, 846, 406);
		panel.add(scrollPane);
		
		tableProdutos = new JTable();
		tableProdutos.setToolTipText("");
		tableProdutos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "Quantidade", "Pre\u00E7o \u00E0 vista", "Pre\u00E7o a prazo", "Especifica\u00E7\u00F5es"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableProdutos.getColumnModel().getColumn(0).setPreferredWidth(55);
		tableProdutos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableProdutos.getColumnModel().getColumn(2).setPreferredWidth(68);
		tableProdutos.getColumnModel().getColumn(4).setPreferredWidth(94);
		tableProdutos.getColumnModel().getColumn(5).setPreferredWidth(247);
		scrollPane.setViewportView(tableProdutos);
		
		JLabel lblEspecificacoes = new JLabel("Especificações:");
		lblEspecificacoes.setBounds(398, 120, 158, 14);
		panel.add(lblEspecificacoes);
		
		setTextEspecificacoes(new JTextField());
		getTextEspecificacoes().setBounds(398, 145, 484, 20);
		panel.add(getTextEspecificacoes());
		getTextEspecificacoes().setColumns(10);
		
		textPesquisa = new JTextField();
		textPesquisa.setBounds(108, 221, 646, 20);
		panel.add(textPesquisa);
		textPesquisa.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPesquisar.setBounds(36, 221, 102, 17);
		panel.add(lblPesquisar);
		
		searchButton = new JButton("Pesquisar");
	
		searchButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/lupa.png")));
		searchButton.setBounds(764, 220, 118, 23);
		panel.add(searchButton);
		
		cancelButton = new JButton("Cancelar");
		
		cancelButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/cancelar.png")));
		cancelButton.setBounds(36, 187, 118, 23);
		panel.add(cancelButton);
		
		newButton = new JButton("Novo");
	
		newButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/novo.png")));
		newButton.setBounds(175, 187, 89, 23);
		panel.add(newButton);
		
		alterButton = new JButton("Alterar");
	
		alterButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/alterar.png")));
		alterButton.setBounds(280, 187, 96, 23);
		panel.add(alterButton);
		
		deleteButton = new JButton("Excluir");
	
		deleteButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/excluir.png")));
		deleteButton.setBounds(398, 187, 124, 23);
		
		panel.add(deleteButton);
		
		salvarButton =  new JButton("Salvar");
		
		salvarButton.setIcon(new ImageIcon(ViewProduto.class.getResource("/app/imagens/salvar.png")));
		salvarButton.setBounds(780, 669, 102, 23);
		
		panel.add(salvarButton);
		
		habilitaCampos(false);
		carregarProdutosTabela();
	}
	
	public void addActionListener(ControllerProdutos controller) {
		salvarButton.addActionListener(controller);
		deleteButton.addActionListener(controller);
		alterButton.addActionListener(controller);
		newButton.addActionListener(controller);
		searchButton.addActionListener(controller);
		cancelButton.addActionListener(controller);
		
		
	}

	public JTable getTableProdutos() {
		return tableProdutos;
	}

	public void setTableProdutos(JTable tableProdutos) {
		this.tableProdutos = tableProdutos;
	}

	public JTextField getTextPesquisa() {
		return textPesquisa;
	}

	public void setTextPesquisa(JTextField textPesquisa) {
		this.textPesquisa = textPesquisa;
	}

	
	public JTextField getTextPnome() {
		return textPnome;
	}

	public void setTextPnome(JTextField textPnome) {
		this.textPnome = textPnome;
	}

	public JTextField getTextEstoque() {
		return textEstoque;
	}

	public void setTextEstoque(JTextField textEstoque) {
		this.textEstoque = textEstoque;
	}

	public JFormattedTextField getTextPprazo() {
		return textPprazo;
	}

	public void setTextPprazo(JFormattedTextField textPprazo) {
		this.textPprazo = textPprazo;
	}

	public JTextField getTextPvista() {
		return textPvista;
	}

	public void setTextPvista(JTextField textPvista) {
		this.textPvista = textPvista;
	}

	public JTextField getTextEspecificacoes() {
		return textEspecificacoes;
	}

	public void setTextEspecificacoes(JTextField textEspecificacoes) {
		this.textEspecificacoes = textEspecificacoes;
	}

	public JTextField getTextCodProduto() {
		return textCodProduto;
	}

	public void setTextCodProduto(JTextField textCodProduto) {
		this.textCodProduto = textCodProduto;
	}
}