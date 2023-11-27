/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.VendedorEfb;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PesquisarVendedor_efb extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public void addList(VendedorEfb vendedorEfb) {
        lista.add(vendedorEfb);
        this.fireTableDataChanged();
    }

    public void removeList(int linha) {
        lista.remove(linha);
        this.fireTableDataChanged();
    }

    public VendedorEfb getVendedor(int row) {
        return (VendedorEfb) lista.get(row);

    }

    @Override
    public int getRowCount() {
        if (lista == null) {
            return 0;
        } else {
            return lista.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VendedorEfb Vendedor = (VendedorEfb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return Vendedor.getIdvendedorEfb();
        }
        if (columnIndex == 1) {
            return Vendedor.getNomeEfb();
        }
        if (columnIndex == 2) {
            return Vendedor.getAtivoEfb();
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
                return "Ativo";
        }
        return "";
    }

}
