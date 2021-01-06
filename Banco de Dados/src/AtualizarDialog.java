import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import com.sun.xml.internal.bind.v2.model.core.ID;

import Logica.ManipulatesDatabase;

import java.awt.Color;
import javax.swing.JComboBox;

public class AtualizarDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ManipulatesDatabase MD;

	public AtualizarDialog(ManipulatesDatabase MD) {
		 this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setTitle("                CADASTRO DE MERCADO");
		this.setVisible(false);
		setBounds(700, 100, 740, 521);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel atualizar = new JLabel("ATUALIZAR/DELETAR");
		atualizar.setForeground(Color.RED);
		atualizar.setFont(new Font("Arial", Font.BOLD, 20));
		atualizar.setBounds(264, 35, 226, 57);
		contentPanel.add(atualizar);
		
		JTextArea pesqu = new JTextArea();
		pesqu.setFont(new Font("Arial", Font.PLAIN, 13));
		pesqu.setBorder(new LineBorder(new Color(0, 0, 0)));
		pesqu.setBounds(112, 103, 365, 36);
		contentPanel.add(pesqu);
		
		JLabel pesquisar = new JLabel("Pesquisar");
		pesquisar.setBorder(new LineBorder(new Color(0, 0, 0)));
		pesquisar.setIcon(new ImageIcon(getClass().getResource("/imagem/pesquisa2.png")));
		pesquisar.setBounds(500, 99, 94, 35);
		contentPanel.add(pesquisar);
		
		JButton cadbotao = new JButton("ATUALIZAR");
		cadbotao.setIcon(new ImageIcon(getClass().getResource("/imagem/salvar (2).png")));
		cadbotao.setFont(new Font("Arial", Font.BOLD, 13));
		cadbotao.setBounds(98, 420, 141, 40);
		contentPanel.add(cadbotao);
		
		JButton cancelarbotao = new JButton("CANCELAR");
		cancelarbotao.setIcon(new ImageIcon(getClass().getResource("/imagem/cancelar (2).png")));
		cancelarbotao.setFont(new Font("Arial", Font.BOLD, 13));
		cancelarbotao.setBounds(518, 420, 154, 40);
		contentPanel.add(cancelarbotao);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(26, 145, 673, 271);
		panel.setLayout(null);
		contentPanel.add(panel);
		
		JLabel nomelabel = new JLabel("NOME DO ITEM:");
		nomelabel.setBounds(21, 31, 106, 14);
		panel.add(nomelabel);
		nomelabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JLabel valorlabel = new JLabel("VALOR R$:");
		valorlabel.setBounds(24, 77, 71, 14);
		panel.add(valorlabel);
		valorlabel.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JEditorPane valorPane = new JEditorPane();
		valorPane.setBounds(174, 77, 156, 20);
		panel.add(valorPane);
		valorPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel idlabel = new JLabel("ID:");
		idlabel.setBounds(21, 172, 46, 14);
		panel.add(idlabel);
		idlabel.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JTextPane idpane = new JTextPane();
		idpane.setBounds(174, 166, 125, 20);
		panel.add(idpane);
		idpane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		idpane.setEditable(false);
		
		JEditorPane nomePane = new JEditorPane();
		nomePane.setBorder(new LineBorder(new Color(0, 0, 0)));
		nomePane.setBounds(174, 31, 313, 20);
		panel.add(nomePane);
		
		JLabel QTD = new JLabel("RAMO:");
		QTD.setFont(new Font("Arial", Font.PLAIN, 13));
		QTD.setBounds(21, 126, 125, 14);
		panel.add(QTD);
		
		JTextPane ramopane = new JTextPane();
		ramopane.setBorder(new LineBorder(new Color(0, 0, 0)));
		ramopane.setBounds(174, 126, 313, 20);
		panel.add(ramopane);
		
		JButton btndeletar = new JButton("DELETAR");
		btndeletar.setIcon(new ImageIcon(getClass().getResource("/imagem/oie_transparent (2).png")));
		btndeletar.setFont(new Font("Arial", Font.BOLD, 13));
		btndeletar.setBounds(305, 421, 125, 40);
		contentPanel.add(btndeletar);
		
		JLabel pesquisaid = new JLabel("Pesquisa ID:  ");
		pesquisaid.setBounds(26, 105, 76, 14);
		contentPanel.add(pesquisaid);
		panel.setVisible(false);
		
		pesquisar.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if(pesqu.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
				}else {
				try {
					System.out.println("casdasd"+pesqu.getText());
					Object o[] = MD.searchByProdutoID(Integer.valueOf(pesqu.getText()));
					if(o!=null) {
					idpane.setText(o[0].toString());
					nomePane.setText(o[1].toString());
					valorPane.setText(o[2].toString());
					ramopane.setText(o[3].toString());
					}else {
						JOptionPane.showMessageDialog(null, "NÃO EXISTENTE");	
					}
				} catch (NumberFormatException p) {
					JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				pesqu.setText("");
				panel.setVisible(true);	
				}
				
			}
			public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
		});	
		cancelarbotao.addActionListener((ActionEvent ae) -> {
	           this.dispose();
	    });
		cadbotao.addActionListener((ActionEvent ae) -> {
	        if(nomePane.getText().equals("")|| valorPane.getText().equals("")||ramopane.getText().equals("")) {
	        	 JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
	        }else {
	        	Object p[] = {Integer.valueOf(idpane.getText()),nomePane.getText(),Float.valueOf(valorPane.getText()),ramopane.getText()};		
				try {
					if(MD.updateRecordsProduto(p)) {
					JOptionPane.showMessageDialog(null,"ATUALIZADO com SUCESSO\n" );	
					 this.dispose();
					}
				}catch(NumberFormatException e) {
						 JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
				}catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
	        }		
	      });
		btndeletar.addActionListener((ActionEvent ae) -> {
	        if(nomePane.getText().equals("")|| valorPane.getText().equals("")||ramopane.getText().equals("")) {
	        	 JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
	        }else {
	        	Object o[] = {Integer.valueOf(idpane.getText()),nomePane.getText(),Float.valueOf(valorPane.getText()),ramopane.getText()};
				try {
					MD.deleteProduto(o);
		        	JOptionPane.showMessageDialog(null, "APAGADO COM SUCESSO");	
					 this.dispose();
				}catch(NumberFormatException e) {
						 JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
				}catch(Exception e){}

	        	this.dispose();
	        }		
	      });
		
	}

}
