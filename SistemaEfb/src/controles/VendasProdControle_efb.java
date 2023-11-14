package controles;

import bean.VendaProdutoEfb;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class VendasProdControle_efb extends AbstractTableModel {

    List lstVendasProduto;

    public VendasProdControle_efb() {
        lstVendasProduto = new ArrayList<>();
    }

    public void setList(List lstVendasProduto) {
        this.lstVendasProduto = lstVendasProduto;
        this.fireTableDataChanged();
    }

    public void addList(VendaProdutoEfb vendasProduto) {
        lstVendasProduto.add(vendasProduto);
        this.fireTableDataChanged();
    }

    public void removeList(int linha) {
        lstVendasProduto.remove(linha);
        this.fireTableDataChanged();

    }

    public VendaProdutoEfb getBean(int row) {
        return (VendaProdutoEfb) lstVendasProduto.get(row);
    }

    @Override
    public int getRowCount() {
        return lstVendasProduto.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VendaProdutoEfb vendasProduto = (VendaProdutoEfb) lstVendasProduto.get(rowIndex);
        if (columnIndex == 0) {
            return vendasProduto.getIdvendaProdutoEfb();
        }
        if (columnIndex == 1) {
            return vendasProduto.getProdutoEfb();
        }
        if (columnIndex == 2) {
            return vendasProduto.getQuantidadeEfb();
        }
        if (columnIndex == 3) {
            return vendasProduto.getValorUnitarioEfb();
        }
        return vendasProduto.getValorUnitarioEfb()* vendasProduto.getQuantidadeEfb();
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Venda";
        }
        if (columnIndex == 1) {
            return "Produto";
        }
        if (columnIndex == 2) {
            return "Quantidade";
        }
        if (columnIndex == 3) {
            return "Valor Unitario";
        }
        if (columnIndex == 4) {
            return "total";
        }
        return "";
    }

}
