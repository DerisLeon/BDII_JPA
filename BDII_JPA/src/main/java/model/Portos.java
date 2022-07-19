package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.locationtech.jts.geom.Geometry;

@Entity
@Table(name = "portos_2014")
public class Portos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
    
    @Column(name = "objectid_1")
    private Integer objectid_1;
    
    @Column(name = "uf")
    private Integer uf;
    
    @Column(name = "nome_uf")
    private String nome_uf;
    
    @Column(name = "nome_regia")
    private String nome_regia;

    @Column(name = "municipio")
    private String municipio; 
    
    @Column(name = "codmun")
    private Integer codmun; 
    
    @Column(name = "sum_total")
    private double sum_total; 
    
    @Column(name = "geom")
    private Geometry geometria;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getObjectid_1() {
        return objectid_1;
    }

    public void setObjectid_1(Integer objectid_1) {
        this.objectid_1 = objectid_1;
    }

    public Integer getUf() {
        return uf;
    }

    public void setUf(Integer uf) {
        this.uf = uf;
    }

    public String getNome_uf() {
        return nome_uf;
    }

    public void setNome_uf(String nome_uf) {
        this.nome_uf = nome_uf;
    }

    public String getNome_regia() {
        return nome_regia;
    }

    public void setNome_regia(String nome_regia) {
        this.nome_regia = nome_regia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Integer getCodmun() {
        return codmun;
    }

    public void setCodmun(Integer codmun) {
        this.codmun = codmun;
    }

    public double getSum_total() {
        return sum_total;
    }

    public void setSum_total(double sum_total) {
        this.sum_total = sum_total;
    }

    public Geometry getGeometria() {
        return geometria;
    }

    public void setGeometria(Geometry geometria) {
        this.geometria = geometria;
    }

    @Override
    public String toString() {
        return "Portos{" + "gid=" + gid + ", objectid_1=" + objectid_1 + ", uf=" + uf + ", nome_uf=" + nome_uf + ", nome_regia=" + nome_regia + ", municipio=" + municipio + ", codmun=" + codmun + ", sum_total=" + sum_total + ", geometria=" + geometria + '}';
    }
    
    
}
