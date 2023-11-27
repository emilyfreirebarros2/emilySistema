/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.ProdutoEfb;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PesquisarProduto_efb extends AbstractTableModel {

    private List Produtolista;

    public void setList(List lista) {
        this.Produtolista = lista;
        this.fireTableDataChanged();
    }

    public void addList(ProdutoEfb vendasProduto) {
        Produtolista.add(vendasProduto);
        this.fireTableDataChanged();
    }

    public void removeList(int linha) {
        Produtolista.remove(linha);
        this.fireTableDataChanged();
    }

    public ProdutoEfb getProduto(int row) {
        return (ProdutoEfb) Produtolista.get(row);
    }

    @Override
    public int getRowCount() {
        if (Produtolista == null) {
            return 0;
        } else {
            return Produtolista.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProdutoEfb Produto = (ProdutoEfb) Produtolista.get(rowIndex);
        if (columnIndex == 0) {
            return Produto.getIdprodutoEfb();
        }
        if (columnIndex == 1) {
            return Produto.getNomeEfb();
        }
        if (columnIndex == 2) {
            return Produto.getQuantidadeEstoqueEfb();
        }

        return "";
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "Quantidade em estoque";
        }
        return "";
    }

}
