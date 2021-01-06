import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.table.AbstractTableModel;

public class ModeloTabela2 extends AbstractTableModel {
	ArrayList<Object[]> produtos;
	ModeloTabela2(ArrayList<Object[]>produtos){
		this.produtos = produtos;
	}
	ModeloTabela2(Object[] produtos){
		this.produtos=new ArrayList<>();
		this.produtos.add(produtos);
	}
	void setModelo(ArrayList<Object[]>produtos){
		this.produtos = produtos;
//		this.fireTableDataChanged();
	}
	void setModelo(Object[] produtos){
		this.produtos=new ArrayList<>();
		this.produtos.add(produtos);
//		this.fireTableDataChanged();
	}
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {	
		return produtos.size();
	}
	@Override
	public String getColumnName(int column) {
	     switch (column) {
         case 1:
             return "NOME";
         case 2:
             return "VALOR";
         case 0:
             return "ID";
         case 3:
        	 return "RAMO";
     }
     return null;
 }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object registro[] = produtos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return registro[0].toString();
            case 1:
            	return registro[1].toString();
            case 2:
            	return registro[2].toString();
            case 3:
            	return registro[3].toString();
            default:
                return new Object();
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
