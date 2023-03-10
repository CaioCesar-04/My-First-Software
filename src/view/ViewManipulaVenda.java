package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerVendasClientes;
import model.entidades.ModelVendasClientes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewManipulaVenda extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	ArrayList< ModelVendasClientes> listaModelVendaClientes = new ArrayList<>();
	ControllerVendasClientes controllerVendaClientes = new ControllerVendasClientes();
	
	public void carregarVendas() {
		DefaultTableModel modelo = (DefaultTableModel) getTable().getModel();
		listaModelVendaClientes = controllerVendaClientes.getListaVendaClientes();
		modelo.setNumRows(0);
		int cont = listaModelVendaClientes.size();
		for(int i = 0; i<cont;i++) {
			modelo.addRow(new Object[] {
					listaModelVendaClientes.get(i).getModelVenda().getCodVenda(),
					listaModelVendaClientes.get(i).getModelCliente().getNomeCliente(),
					listaModelVendaClientes.get(i).getModelVenda().getData(),
					listaModelVendaClientes.get(i).getModelVenda().getPrecoFinal()
			});
		}
	}
	
	public void msgExcluir() {
		JOptionPane.showMessageDialog(this, "Venda deletada com sucesso","DELETADA",JOptionPane.INFORMATION_MESSAGE);
	}
	public void msgExcluirErro() {
		JOptionPane.showMessageDialog(this, "Erro ao deletar a venda","ERRO",JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Create the frame.
	 */
	public ViewManipulaVenda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 937, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 921, 472);
		contentPane.add(panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 22, 865, 406);
		panel.add(scrollPane_1);
		
		setTable(new JTable());
		getTable().setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome Cliente", "Data", "Valor"
			}
		));
		scrollPane_1.setViewportView(getTable());
		
		setLocationRelativeTo(null);
		setResizable(false);
		
		carregarVendas();
	}
	public void addActionListener(ControllerVendasClientes controllerVendasClientes) {
		
	}

	

	public void setTextPesquisa(JTextField textPesquisa) {
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}
