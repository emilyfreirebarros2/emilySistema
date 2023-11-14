/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.UsuarioEfb;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PesquisarUsuario_efb extends AbstractTableModel{


    private List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public UsuarioEfb getUsuaruio(int row) {
        return (UsuarioEfb) lista.get(row);
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
        UsuarioEfb usuarios = (UsuarioEfb) lista.get(rowIndex);
        if (columnIndex == 0) {
            return usuarios.getIdusuarioEfb();
        }
        if (columnIndex == 1) {
            return usuarios.getNomeEfb();
        }
        if (columnIndex == 2) {
            return usuarios.getAtivoEfb();
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
