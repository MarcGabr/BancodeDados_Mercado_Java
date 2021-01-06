import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.List;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Logica.ManipulatesDatabase;

import java.awt.Color;



public class BuscaDialog extends JDialog {
	 private JTable tabela = new JTable();
	    private final ModeloTabela2 modelo;
	private final JPanel contentPanel = new JPanel();

	public BuscaDialog(ManipulatesDatabase MD) {
		setBounds(100, 100, 881, 577);
		contentPanel.setLayout(null);
		getContentPane().add(contentPanel);
		 	modelo = new ModeloTabela2(new ArrayList<>());
	        this.setModal(true);
	        
	        JButton cancelarbotao = new JButton("CANCELAR");
	        cancelarbotao.setIcon(new ImageIcon(getClass().getResource("/imagem/cancelar (2).png")));
			cancelarbotao.setFont(new Font("Arial", Font.BOLD, 13));
			cancelarbotao.setBounds(357, 487, 147, 40);
			contentPanel.add(cancelarbotao);
			
			JLabel Pesquisar = new JLabel("BUSCA DE ITEM");
			Pesquisar.setForeground(Color.RED);
			Pesquisar.setFont(new Font("Arial", Font.BOLD, 20));
			Pesquisar.setBounds(327, 11, 260, 40);
			contentPanel.add(Pesquisar);
			
			JScrollPane adc2 = new JScrollPane();
			adc2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			adc2.setBounds(67, 199, 732, 277);
			contentPanel.add(adc2);
			adc2.setViewportView(tabela);
			adc2.setVisible(true);
			tabela.setModel(modelo);
			tabela.getColumnModel().getColumn(0).setResizable(false);
			tabela.getColumnModel().getColumn(1).setResizable(false);
			tabela.getColumnModel().getColumn(2).setResizable(false);
			tabela.getColumnModel().getColumn(3).setResizable(false);
			tabela.setDragEnabled(false);
			
			JScrollPane adc3 = new JScrollPane();
			adc3.setBounds(116, 132, 365, 40);
			contentPanel.add(adc3);
			
			JTextArea textnome = new JTextArea();
			textnome.setBorder(new LineBorder(new Color(0, 0, 0)));
			adc3.setViewportView(textnome);
									
									JTextPane textID = new JTextPane();
									textID.setBorder(new LineBorder(new Color(0, 0, 0)));
									textID.setBounds(116, 93, 199, 29);
									contentPanel.add(textID);
									
									JLabel buscaid = new JLabel("Busca ID:");
									buscaid.setBounds(26, 93, 80, 14);
									contentPanel.add(buscaid);
									
									JLabel buscname = new JLabel("Busca Nome:");
									buscname.setBounds(26, 138, 76, 14);
									contentPanel.add(buscname);
									
									JLabel pesquisar = new JLabel("Pesquisar");
									pesquisar.setBorder(new LineBorder(new Color(0, 0, 0)));
									pesquisar.setIcon(new ImageIcon(getClass().getResource("/imagem/pesquisa2.png")));
									pesquisar.setBounds(644, 105, 94, 35);
									contentPanel.add(pesquisar);
									
									pesquisar.addMouseListener(new MouseListener() {
										public void mouseClicked(MouseEvent e) {
											 try {
												 if((textnome.getText().equals("")&&textID.getText().equals(""))||(!(textnome.getText().equals(""))&&!(textID.getText().equals("")))) {
										        	 JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
										        }else {
										        	if(textID.getText().length()>0){
													modelo.setModelo(MD.searchByProdutoID(Integer.valueOf(textID.getText())));
													}else{
														modelo.setModelo(MD.searchByDescriptionProdutos(textnome.getText(), "Nome"));
													}
										        	modelo.fireTableDataChanged();
										        }
											
										}catch(NumberFormatException e1){
												JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
										}catch(NullPointerException f) {
								  	    	   JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
								  	       } catch (Exception e1) {}
										}
										public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
									});	
									cancelarbotao.addActionListener((ActionEvent ae) -> {
							           this.dispose();
							        });
			
	}
}
