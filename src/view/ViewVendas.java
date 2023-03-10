 package view;

import java.util.ArrayList;

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
import controller.ControllerProdutos;
import controller.ControllerVenda;
import model.entidades.ModelCliente;
import model.entidades.ModelProdutos;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewVendas extends JFrame {
	
	 
	private JPanel contentPane;
	private JTextField textCodCliente;
	private JTextField textCodVenda;
	private JTextField textCodProduto;
	private JTextField textQuantidade;
	private JTextField textValorTotal;
	private JTextField textDesconto;
	private JTable table;
	private JComboBox boxProdutos;
	private JComboBox boxClientes;
	private JButton btnAdicioanar;
	ControllerClientes controllerClientes = new ControllerClientes();
	ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
	ModelCliente modelCliente = new ModelCliente();
	ControllerProdutos controllerProdutos =  new ControllerProdutos();
	ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
	ModelProdutos modelProdutos = new ModelProdutos();
	private JButton btnNovo;
	private JButton btnSalvar;
	
	/**
	 * PREENCHE O COMBOBOX COM OS CLIENTE
	 */
	private void listarClientes() {
		listaModelClientes = controllerClientes.listaClientes();
		getBoxClientes().removeAllItems();
		for(int i=0;i<listaModelClientes.size();i++) {
			getBoxClientes().addItem(listaModelClientes.get(i).getNomeCliente());
		}
	}
	private void listarProdutos() {
		listaModelProdutos = controllerProdutos.listaProdutos();
		getBoxProdutos().removeAllItems();
		for(int i=0;i<listaModelProdutos.size();i++) {
			getBoxProdutos().addItem(listaModelProdutos.get(i).getProNome());
		}
	}
	
	public void limparFormulario() {
		getTextQuantidade().setText("");
		getTextDesconto().setText("");
		getTextValorTotal().setText("");
		DefaultTableModel modelo = (DefaultTableModel) getTable().getModel();
		modelo.setNumRows(0);
	}
	

	/**
	 * Create the frame.
	 */
	public ViewVendas() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 931, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBounds(0, 0, 915, 537);
		contentPane.add(panelCadastro);
		
		JLabel lblCodCliente = new JLabel("Código Cliente:");
		lblCodCliente.setBounds(18, 11, 116, 22);
		panelCadastro.add(lblCodCliente);
		
		setTextCodCliente(new JTextField());
		getTextCodCliente().addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
				modelCliente = controllerClientes.retornaClienteController(Integer.parseInt(getTextCodCliente().getText()));
				getBoxClientes().setSelectedItem(modelCliente.getNomeCliente());
				}catch(Exception exc) {
					System.out.println("Selecionou cliente");
				}
			}
		});
		getTextCodCliente().setColumns(10);
		getTextCodCliente().setBounds(18, 44, 159, 20);
		panelCadastro.add(getTextCodCliente());
		
		JLabel lblNumeroVenda = new JLabel("Número da venda:");
		lblNumeroVenda.setBounds(780, 15, 110, 14);
		panelCadastro.add(lblNumeroVenda);
		
		setTextCodVenda(new JTextField());
		getTextCodVenda().setColumns(10);
		getTextCodVenda().setBounds(780, 44, 105, 20);
		panelCadastro.add(getTextCodVenda());
		
		setBoxClientes(new JComboBox());
		getBoxClientes().addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				if(getBoxClientes().isPopupVisible()) {
					carregarClientes();
				}
			}
				
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		getBoxClientes().setBounds(187, 43, 583, 22);
		panelCadastro.add(getBoxClientes());
		
		JLabel lblClientesComboBox = new JLabel("Cliente:");
		lblClientesComboBox.setBounds(187, 15, 46, 14);
		panelCadastro.add(lblClientesComboBox);
		
		JLabel lblProduto = new JLabel("Código Produto:");
		lblProduto.setBounds(18, 88, 94, 14);
		panelCadastro.add(lblProduto);
		
		setTextCodProduto(new JTextField());
		getTextCodProduto().addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				modelProdutos = controllerProdutos.retornaProdutoController(Integer.parseInt(getTextCodProduto().getText()));
				getBoxProdutos().setSelectedItem(modelProdutos.getProNome());
			}
		});
		getTextCodProduto().setColumns(10);
		getTextCodProduto().setBounds(18, 113, 159, 20);
		panelCadastro.add(getTextCodProduto());
		
		setBoxProdutos(new JComboBox());
		getBoxProdutos().addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				if(getBoxProdutos().isVisible()) {
					carregarProdutos();
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		getBoxProdutos().setBounds(187, 112, 471, 22);
		panelCadastro.add(getBoxProdutos());
		
		JLabel lblNewLabel = new JLabel("Produtos:");
		lblNewLabel.setBounds(187, 88, 120, 14);
		panelCadastro.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setBounds(668, 88, 81, 14);
		panelCadastro.add(lblNewLabel_1);
		
		setTextQuantidade(new JTextField());
		getTextQuantidade().setColumns(10);
		getTextQuantidade().setBounds(668, 113, 105, 20);
		panelCadastro.add(getTextQuantidade());
		
		btnAdicioanar = new JButton("Adicionar");
		
		btnAdicioanar.setBounds(783, 112, 102, 23);
		panelCadastro.add(btnAdicioanar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 144, 865, 290);
		panelCadastro.add(scrollPane);
		
		setTable(new JTable());
		getTable().setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3d. Produto", "Nome Produto", "Quant.", "Valor Un.", "Valor Total", "Valor Prazo"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(193);
		table.getColumnModel().getColumn(3).setPreferredWidth(98);
		scrollPane.setViewportView(getTable());
		
	
		
		btnNovo = new JButton("Limpar");
	
		btnNovo.setIcon(new ImageIcon(ViewVendas.class.getResource("/app/imagens/alterar.png")));
		btnNovo.setBounds(614, 503, 120, 23);
		panelCadastro.add(btnNovo);
		
		btnSalvar = new JButton("Salvar");
		
		btnSalvar.setIcon(new ImageIcon(ViewVendas.class.getResource("/app/imagens/salvar.png")));
		btnSalvar.setBounds(744, 503, 110, 23);
		panelCadastro.add(btnSalvar);
		
		setTextValorTotal(new JTextField());
		getTextValorTotal().setColumns(10);
		getTextValorTotal().setBounds(734, 470, 120, 20);
		panelCadastro.add(getTextValorTotal());
		
		JLabel lblNewLabel_2 = new JLabel("Valor total:");
		lblNewLabel_2.setBounds(734, 445, 73, 14);
		panelCadastro.add(lblNewLabel_2);
		
		setTextDesconto(new JTextField());
		getTextDesconto().setColumns(10);
		getTextDesconto().setBounds(614, 470, 100, 20);
		panelCadastro.add(getTextDesconto());
		
		JLabel lblNewLabel_3 = new JLabel("Desconto:");
		lblNewLabel_3.setBounds(614, 445, 59, 14);
		panelCadastro.add(lblNewLabel_3);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		listarClientes();
		listarProdutos();
		carregarClientes();
		carregarProdutos();
	}
	public void addActionListener(ControllerVenda controllerVenda) {
		btnAdicioanar.addActionListener(controllerVenda);
		btnNovo.addActionListener(controllerVenda);
		btnSalvar.addActionListener(controllerVenda);
	}
	
	
	public JTextField getTextCodCliente() {
		return textCodCliente;
	}
	public void setTextCodCliente(JTextField textCodCliente) {
		this.textCodCliente = textCodCliente;
	}
	public JTextField getTextCodVenda() {
		return textCodVenda;
	}
	public void setTextCodVenda(JTextField textCodVenda) {
		this.textCodVenda = textCodVenda;
	}
	public JTextField getTextCodProduto() {
		return textCodProduto;
	}
	public void setTextCodProduto(JTextField textCodProduto) {
		this.textCodProduto = textCodProduto;
	}
	public JTextField getTextQuantidade() {
		return textQuantidade;
	}
	public void setTextQuantidade(JTextField textQuantidade) {
		this.textQuantidade = textQuantidade;
	}
	public JTextField getTextValorTotal() {
		return textValorTotal;
	}
	public void setTextValorTotal(JTextField textValorTotal) {
		this.textValorTotal = textValorTotal;
	}
	public JTextField getTextDesconto() {
		return textDesconto;
	}
	public void setTextDesconto(JTextField textDesconto) {
		this.textDesconto = textDesconto;
		textDesconto.setText("0");
		textDesconto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				desconto();
			}
		});
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JComboBox getBoxProdutos() {
		return boxProdutos;
	}
	public void setBoxProdutos(JComboBox boxProdutos) {
		this.boxProdutos = boxProdutos;
	}
	public JComboBox getBoxClientes() {
		return boxClientes;
	}
	public void setBoxClientes(JComboBox boxClientes) {
		this.boxClientes = boxClientes;
	}
	public void msgErroQuantidade() {
		JOptionPane.showMessageDialog(this, "Prencha todos os campos","ATENÇÃO",JOptionPane.WARNING_MESSAGE);
		
	}
	public void desconto() {
		getTextValorTotal().setText(String.valueOf(Double.parseDouble(getTextValorTotal().getText())- Double.parseDouble(getTextDesconto().getText())));
	}
	private void carregarProdutos() {
		modelProdutos = controllerProdutos.retornaProdutoControllerPNome(getBoxProdutos().getSelectedItem().toString());
		getTextCodProduto().setText(modelProdutos.getCodProduto()+"");
	}
	private void carregarClientes() {
		modelCliente = controllerClientes.retornaClienteControllerPNome(getBoxClientes().getSelectedItem().toString());
		getTextCodCliente().setText(modelCliente.getCodcliente()+"");
	}
	public void msgSalvado() {
		JOptionPane.showMessageDialog(this, "Salvo com sucesso","SALVO",JOptionPane.INFORMATION_MESSAGE);
		
	}
	public void msgSalvadoErro() {
		JOptionPane.showMessageDialog(this, "Erro ao salvar","ERRO",JOptionPane.ERROR_MESSAGE);

		// TODO Auto-generated method stub
		
	}
	public void msgProSalvo() {
		JOptionPane.showMessageDialog(this, "Produtos salvos com sucesso","SALVO",JOptionPane.INFORMATION_MESSAGE);
		
	}
}