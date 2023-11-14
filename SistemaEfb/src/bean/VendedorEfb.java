package bean;
// Generated 13/11/2023 08:04:02 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VendedorEfb generated by hbm2java
 */
@Entity
@Table(name = "vendedor_efb",
        catalog = "db_emily_barros"
)
public class VendedorEfb implements java.io.Serializable {

    private int idvendedorEfb;
    private String nomeEfb;
    private String sobrenomeEfb;
    private String cpfEfb;
    private String rgEfb;
    private String enderecoEfb;
    private String ativoEfb;

    public VendedorEfb() {
    }

    public VendedorEfb(int idvendedorEfb) {
        this.idvendedorEfb = idvendedorEfb;
    }

    public VendedorEfb(int idvendedorEfb, String nomeEfb, String sobrenomeEfb, String cpfEfb, String rgEfb, String enderecoEfb, String ativoEfb) {
        this.idvendedorEfb = idvendedorEfb;
        this.nomeEfb = nomeEfb;
        this.sobrenomeEfb = sobrenomeEfb;
        this.cpfEfb = cpfEfb;
        this.rgEfb = rgEfb;
        this.enderecoEfb = enderecoEfb;
        this.ativoEfb = ativoEfb;
    }

    @Id

    @Column(name = "idvendedor_efb", unique = true, nullable = false)
    public int getIdvendedorEfb() {
        return this.idvendedorEfb;
    }

    public void setIdvendedorEfb(int idvendedorEfb) {
        this.idvendedorEfb = idvendedorEfb;
    }

    @Column(name = "nome_efb")
    public String getNomeEfb() {
        return this.nomeEfb;
    }

    public void setNomeEfb(String nomeEfb) {
        this.nomeEfb = nomeEfb;
    }

    @Column(name = "sobrenome_efb")
    public String getSobrenomeEfb() {
        return this.sobrenomeEfb;
    }

    public void setSobrenomeEfb(String sobrenomeEfb) {
        this.sobrenomeEfb = sobrenomeEfb;
    }

    @Column(name = "cpf_efb")
    public String getCpfEfb() {
        return this.cpfEfb;
    }

    public void setCpfEfb(String cpfEfb) {
        this.cpfEfb = cpfEfb;
    }

    @Column(name = "rg_efb")
    public String getRgEfb() {
        return this.rgEfb;
    }

    public void setRgEfb(String rgEfb) {
        this.rgEfb = rgEfb;
    }

    @Column(name = "endereco_efb")
    public String getEnderecoEfb() {
        return this.enderecoEfb;
    }

    public void setEnderecoEfb(String enderecoEfb) {
        this.enderecoEfb = enderecoEfb;
    }

    @Column(name = "ativo_efb", length = 5)
    public String getAtivoEfb() {
        return this.ativoEfb;
    }

    public void setAtivoEfb(String ativoEfb) {
        this.ativoEfb = ativoEfb;
    }

}
