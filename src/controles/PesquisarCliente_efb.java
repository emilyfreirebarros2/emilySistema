/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.ClienteEfb;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PesquisarCliente_efb extends AbstractTableModel{


    private List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public ClienteEfb getCliente(int row) {
        return (ClienteEfb) lista.get(row);
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
        ClienteEfb cliente = (ClienteEfb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return cliente.getIdclienteEfb();
        }
        if (columnIndex == 1) {
            return cliente.getNomeEfb();
        }
        if (columnIndex == 2) {
            return cliente.getCidadeEfb();
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
                return "Cidade";
        }
        return "";
    }

 
    
}
