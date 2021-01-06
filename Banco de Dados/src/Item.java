import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.config.management.policy.ManagementAssertionCreator;

import Logica.ManipulatesDatabase;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Item extends JPanel {

	private static final long serialVersionUID = 3869943317079902270L;
	JLabel lblInserir;JLabel lblEditar;JLabel lblBusca;
	InserirDialog criar; AtualizarDialog editar; BuscaDialog busca;
	private JButton btnVoltar;
	private JLabel lblTelaDoItem;
	//private ManipulatesDatabase MD;
	public Item(JPanel p,ManipulatesDatabase MD) throws IOException {
		//MD = new ManipulatesDatabase("/FILES"+a);
		setBounds(100, 100, 756, 326);
		setLayout(null);
		lblInserir = new JLabel("INSERIR");
		lblInserir.setIcon(new ImageIcon(getClass().getResource("/imagem/inserindo.png")));
		lblInserir.setFont(new Font("Arial", Font.BOLD, 18));
		lblInserir.setForeground(Color.RED);
		lblInserir.setBounds(38, 91, 199, 100);
		this.add(lblInserir);
		
		lblInserir.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				criar = new InserirDialog(MD);
				criar.setVisible(true);		
			}
			public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
		});
		
		lblEditar = new JLabel("EDITAR/EXCLUIR");
		lblEditar.setIcon(new ImageIcon(getClass().getResource("/imagem/editando.png")));
		lblEditar.setForeground(Color.RED);
		lblEditar.setFont(new Font("Arial", Font.BOLD, 18));
		lblEditar.setBounds(240, 91, 285, 100);
		this.add(lblEditar);
		lblEditar.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				editar = new AtualizarDialog(MD);
				editar.setVisible(true);	
			}
			public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
		});
		
		lblBusca = new JLabel("BUSCA");
		lblBusca.setIcon(new ImageIcon(getClass().getResource("/imagem/pesquisando.png")));
		lblBusca.setFont(new Font("Arial", Font.BOLD, 18));
		lblBusca.setForeground(Color.RED);
		lblBusca.setBounds(535, 91, 189, 100);
		this.add(lblBusca);
			lblBusca.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				busca = new BuscaDialog(MD);
				busca.setVisible(true);	
			}
			public void mousePressed(MouseEvent e) {}public void mouseReleased(MouseEvent e) {}public void mouseEntered(MouseEvent e) {}public void mouseExited(MouseEvent e) {}
		});
		btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(getClass().getResource("/imagem/voltar.png")));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setBounds(303, 228, 122, 23);
		add(btnVoltar);
		
		lblTelaDoItem = new JLabel("TELA DO ITEM");
		lblTelaDoItem.setFont(new Font("Arial", Font.BOLD, 20));
		lblTelaDoItem.setBounds(303, 30, 297, 23);
		add(lblTelaDoItem);
		btnVoltar.addActionListener((ActionEvent ae) -> {
	         this.setVisible(false);  
	         p.setVisible(true);
	     });
		
	
	
	}

}
