/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByIdexamen", query = "SELECT e FROM Examen e WHERE e.idexamen = :idexamen"),
    @NamedQuery(name = "Examen.findByDate", query = "SELECT e FROM Examen e WHERE e.date = :date"),
    @NamedQuery(name = "Examen.findByType", query = "SELECT e FROM Examen e WHERE e.type = :type")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamen")
    private Integer idexamen;
    @Size(max = 10)
    @Column(name = "date")
    private String date;
    @Size(max = 30)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexamen")
    private List<EtudiantExam> etudiantExamList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexamen")
    private List<MatiereExam> matiereExamList;

    public Examen() {
    }

    public Examen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public Integer getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<EtudiantExam> getEtudiantExamList() {
        return etudiantExamList;
    }

    public void setEtudiantExamList(List<EtudiantExam> etudiantExamList) {
        this.etudiantExamList = etudiantExamList;
    }

    @XmlTransient
    public List<MatiereExam> getMatiereExamList() {
        return matiereExamList;
    }

    public void setMatiereExamList(List<MatiereExam> matiereExamList) {
        this.matiereExamList = matiereExamList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamen != null ? idexamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idexamen == null && other.idexamen != null) || (this.idexamen != null && !this.idexamen.equals(other.idexamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Examen[ idexamen=" + idexamen + " ]";
    }
    
}
