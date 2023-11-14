/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.VendaEfb;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PesquisarVenda_efb extends AbstractTableModel {

    private List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public VendaEfb getVenda(int row) {
        return (VendaEfb) lista.get(row);
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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VendaEfb Venda = (VendaEfb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return Venda.getIdvendaEfb();
        }
        if (columnIndex == 1) {
            return Venda.getVendedorEfb().getNomeEfb();
        }
        if (columnIndex == 2) {
            return Venda.getClienteEfb().getNomeEfb();
        }

        if (columnIndex == 3) {
            return Venda.getTotalEfb();
        }

        return "";
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Funcionario";
            case 2:
                return "Cliente";
            case 3:
                return "Total";
        }
        return "";
    }

}
