/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import bean.ClienteEfb;
import dao.ClienteDao_efb;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

public class JDlgCliente extends javax.swing.JDialog {

    boolean incluindo;
    MaskFormatter masradata;
    MaskFormatter mascaraCep, mascaraCpf, mascaraDataNascimento, mascaratelefone, mascaraCelular, mascaraRg;
    Util util;
    ClienteEfb cliente;
    ClienteDao_efb clienteDao;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public JDlgCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Clientes");
        habilitar(false);
        limpar();
        cliente = new ClienteEfb();
        clienteDao = new ClienteDao_efb();
        incluindo = false;

        try {
            mascaraCep = new MaskFormatter("#####-###");
            mascaraCpf = new MaskFormatter("###.###.###-##");
            masradata = new MaskFormatter("##/##/####");
            mascaratelefone = new MaskFormatter("####-#####");
            mascaraCelular = new MaskFormatter("(##)#####-####");
            mascaraRg = new MaskFormatter("#.###.###");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        jFmtDatadeNascimento_efb.setFormatterFactory(new DefaultFormatterFactory(masradata));
        jFmtCep_efb.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
        jFmtCpf_efb.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        jFmtTelefone_efb.setFormatterFactory(new DefaultFormatterFactory(mascaratelefone));
        jFmtRg_efb.setFormatterFactory(new DefaultFormatterFactory(mascaraRg));
        jFmtCelular_efb.setFormatterFactory(new DefaultFormatterFactory(mascaraCelular));

    }

    public void habilitar(boolean valor) {
        util.habilitar(valor,
                jTxtCodigoCliente_efb,
                jTxtNome_efb,
                jFmtCpf_efb,
                jFmtRg_efb,
                jFmtCelular_efb,
                jFmtTelefone_efb,
                jFmtCep_efb,
                jTxtCidade_efb,
                jCmbUF_efb,
                jTxtEndereco_efb,
                jTxtComplemento_efb,
                jTxtEmail_efb,
                jFmtDatadeNascimento_efb,
                jCmbSexo_efb,
                jTxtBairro_efb,
                jBtnCancelar_efb,
                jBtnConfirmar_efb);

        util.habilitar(!valor,
                jBtnIncluir_efb,
                jBtnAlterar_efb,
                jBtnPesquisar_efb);

    }

    public void limpar() {

        util.limparCampos(jTxtCodigoCliente_efb,
                jTxtNome_efb,
                jFmtCpf_efb,
                jFmtRg_efb,
                jFmtCelular_efb,
                jFmtTelefone_efb,
                jFmtCep_efb,
                jTxtCidade_efb,
                jCmbUF_efb,
                jTxtEndereco_efb,
                jTxtComplemento_efb,
                jTxtEmail_efb,
                jFmtDatadeNascimento_efb,
                jCmbSexo_efb,
                jTxtBairro_efb);
    }

    public ClienteEfb viewBean() {
        cliente.setIdclienteEfb(util.paraInteiro(jTxtCodigoCliente_efb.getText()));
        cliente.setNomeEfb(jTxtNome_efb.getText());
        cliente.setRgEfb(jFmtRg_efb.getText());
        cliente.setCpfEfb(jFmtCpf_efb.getText());
        cliente.setSexoEfb((String) jCmbSexo_efb.getSelectedItem());
        try {
            cliente.setDataNascimentoEfb(format.parse(jFmtDatadeNascimento_efb.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCliente.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        cliente.setEmailEfb(jTxtEmail_efb.getText());
        cliente.setTelefoneEfb(jFmtTelefone_efb.getText());
        cliente.setEnderecoEfb(jTxtEndereco_efb.getText());
        cliente.setBairroEfb(jTxtBairro_efb.getText());
        cliente.setNumeroEfb(jFmtCelular_efb.getText());
        cliente.setCepEfb(jFmtCep_efb.getText());
        cliente.setCidadeEfb(jTxtCidade_efb.getText());
        cliente.setEstadoEfb((String) jCmbUF_efb.getSelectedItem());
        cliente.setComplementoEfb(jTxtComplemento_efb.getText());
        return cliente;
    }

    public void beanView(ClienteEfb cliente) {
        jTxtCodigoCliente_efb.setText(util.paraString(cliente.getIdclienteEfb()));
        jTxtNome_efb.setText(cliente.getNomeEfb());
        jFmtRg_efb.setText(cliente.getRgEfb());
        jFmtCpf_efb.setText(cliente.getCpfEfb());
        jCmbSexo_efb.setSelectedItem(cliente.getSexoEfb());
        jFmtDatadeNascimento_efb.setText(format.format(cliente.getDataNascimentoEfb()));
        jTxtEmail_efb.setText(cliente.getEmailEfb());
        jFmtCelular_efb.setText(cliente.getTelefoneEfb());
        jTxtEndereco_efb.setText(cliente.getEnderecoEfb());
        jTxtBairro_efb.setText(cliente.getBairroEfb());
        jFmtCelular_efb.setText(cliente.getNumeroEfb());
        jFmtCep_efb.setText(cliente.getCepEfb());
        jTxtCidade_efb.setText(cliente.getCidadeEfb());
        jCmbUF_efb.setSelectedItem(cliente.getEstadoEfb());
        jFmtTelefone_efb.setText(cliente.getTelefoneEfb());
        jTxtComplemento_efb.setText(cliente.getComplementoEfb());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTxtCodigoCliente_efb = new javax.swing.JTextField();
        jTxtNome_efb = new javax.swing.JTextField();
        jTxtCidade_efb = new javax.swing.JTextField();
        jTxtEndereco_efb = new javax.swing.JTextField();
        jTxtComplemento_efb = new javax.swing.JTextField();
        jTxtEmail_efb = new javax.swing.JTextField();
        jCmbSexo_efb = new javax.swing.JComboBox<>();
        jCmbUF_efb = new javax.swing.JComboBox<>();
        jTxtBairro_efb = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBtnIncluir_efb = new javax.swing.JButton();
        jBtnAlterar_efb = new javax.swing.JButton();
        jBtnExcluir_efb = new javax.swing.JButton();
        jBtnCancelar_efb = new javax.swing.JButton();
        jBtnConfirmar_efb = new javax.swing.JButton();
        jBtnPesquisar_efb = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jFmtDatadeNascimento_efb = new javax.swing.JFormattedTextField();
        jFmtRg_efb = new javax.swing.JFormattedTextField();
        jFmtCpf_efb = new javax.swing.JFormattedTextField();
        jFmtCelular_efb = new javax.swing.JFormattedTextField();
        jFmtTelefone_efb = new javax.swing.JFormattedTextField();
        jFmtCep_efb = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código Cliente");

        jLabel2.setText("Nome");

        jLabel3.setText("CPF");

        jLabel4.setText("RG");

        jLabel5.setText("Telefone");

        jLabel6.setText("Numero:");

        jLabel7.setText("CEP");

        jLabel8.setText("UF");

        jLabel9.setText("Endereço");

        jLabel10.setText("Complemento");

        jLabel11.setText("Cidade");

        jLabel13.setText("Data de Nascimento");

        jLabel14.setText("Sexo");

        jCmbSexo_efb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jCmbUF_efb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF" }));

        jLabel17.setText("Bairro:");

        jBtnIncluir_efb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/inserir.png"))); // NOI18N
        jBtnIncluir_efb.setText("Incluir");
        jBtnIncluir_efb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluir_efbActionPerformed(evt);
            }
        });

        jBtnAlterar_efb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar_efb.setText("Alterar");
        jBtnAlterar_efb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterar_efbActionPerformed(evt);
            }
        });

        jBtnExcluir_efb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        jBtnExcluir_efb.setText("Excluir");
        jBtnExcluir_efb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluir_efbActionPerformed(evt);
            }
        });

        jBtnCancelar_efb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar_efb.setText("Cancelar");
        jBtnCancelar_efb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelar_efbActionPerformed(evt);
            }
        });

        jBtnConfirmar_efb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        jBtnConfirmar_efb.setText("Confirmar");
        jBtnConfirmar_efb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmar_efbActionPerformed(evt);
            }
        });

        jBtnPesquisar_efb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa.png"))); // NOI18N
        jBtnPesquisar_efb.setText("Pesquisar");
        jBtnPesquisar_efb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisar_efbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jBtnIncluir_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jBtnAlterar_efb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnExcluir_efb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnConfirmar_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCancelar_efb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnPesquisar_efb)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jBtnIncluir_efb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnAlterar_efb)
                .addComponent(jBtnExcluir_efb)
                .addComponent(jBtnCancelar_efb)
                .addComponent(jBtnConfirmar_efb)
                .addComponent(jBtnPesquisar_efb))
        );

        jLabel16.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtCodigoCliente_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFmtCpf_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jFmtRg_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jTxtBairro_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtCep_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtCidade_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(216, 216, 216)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTxtEndereco_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTxtComplemento_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtNome_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFmtDatadeNascimento_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14)
                                    .addComponent(jCmbSexo_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jCmbUF_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jFmtTelefone_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFmtCelular_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jTxtEmail_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCodigoCliente_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCmbSexo_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtNome_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtDatadeNascimento_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCmbUF_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtBairro_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFmtRg_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmtCpf_efb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFmtCep_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtCidade_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTxtEmail_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFmtCelular_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFmtTelefone_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtComplemento_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtEndereco_efb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluir_efbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluir_efbActionPerformed
        // TODO add your handling code here:
        habilitar(true);
        limpar();
        incluindo = true;
        cliente = new ClienteEfb();
    }//GEN-LAST:event_jBtnIncluir_efbActionPerformed

    private void jBtnAlterar_efbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterar_efbActionPerformed
        // TODO add your handling code here:
        habilitar(true);
        incluindo = false;
        jTxtCodigoCliente_efb.setEnabled(false);
    }//GEN-LAST:event_jBtnAlterar_efbActionPerformed

    private void jBtnExcluir_efbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluir_efbActionPerformed
        // TODO add your handling code here:
        if (util.pergunta("Quer mesmo excluir")) {
            cliente = viewBean();
            clienteDao.delete(cliente);
        } else {
            util.mensagem("Exclusão cancelada");
        }
        habilitar(false);
        limpar();

    }//GEN-LAST:event_jBtnExcluir_efbActionPerformed

    private void jBtnCancelar_efbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelar_efbActionPerformed
        // TODO add your handling code here:
        habilitar(false);
        limpar();
    }//GEN-LAST:event_jBtnCancelar_efbActionPerformed

    private void jBtnConfirmar_efbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmar_efbActionPerformed
        // TODO add your handling code here:
        cliente = viewBean();
        if (cliente != null) {
            if (incluindo == true) {
                clienteDao.insert(cliente);
            } else {
                clienteDao.update(cliente);
            }
        }
        incluindo = false;
        cliente = null;
        habilitar(false);
        limpar();
    }//GEN-LAST:event_jBtnConfirmar_efbActionPerformed

    private void jBtnPesquisar_efbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisar_efbActionPerformed
        // TODO add your handling code here:
        cliente=new ClienteEfb();
        JDlgPesquisaCliente jDlgPesquisaCliente = new JDlgPesquisaCliente(null, true);
        jDlgPesquisaCliente.setTelaAnterior(this);
        jDlgPesquisaCliente.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisar_efbActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCliente dialog = new JDlgCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar_efb;
    private javax.swing.JButton jBtnCancelar_efb;
    private javax.swing.JButton jBtnConfirmar_efb;
    private javax.swing.JButton jBtnExcluir_efb;
    private javax.swing.JButton jBtnIncluir_efb;
    private javax.swing.JButton jBtnPesquisar_efb;
    private javax.swing.JComboBox<String> jCmbSexo_efb;
    private javax.swing.JComboBox<String> jCmbUF_efb;
    private javax.swing.JFormattedTextField jFmtCelular_efb;
    private javax.swing.JFormattedTextField jFmtCep_efb;
    private javax.swing.JFormattedTextField jFmtCpf_efb;
    private javax.swing.JFormattedTextField jFmtDatadeNascimento_efb;
    private javax.swing.JFormattedTextField jFmtRg_efb;
    private javax.swing.JFormattedTextField jFmtTelefone_efb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTxtBairro_efb;
    private javax.swing.JTextField jTxtCidade_efb;
    private javax.swing.JTextField jTxtCodigoCliente_efb;
    private javax.swing.JTextField jTxtComplemento_efb;
    private javax.swing.JTextField jTxtEmail_efb;
    private javax.swing.JTextField jTxtEndereco_efb;
    private javax.swing.JTextField jTxtNome_efb;
    // End of variables declaration//GEN-END:variables
}
