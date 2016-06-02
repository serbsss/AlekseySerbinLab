/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author НР
 */
@Entity
@Table(name = "operation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operation.findAll", query = "SELECT o FROM Operation o"),
    @NamedQuery(name = "Operation.findByIdOperation", query = "SELECT o FROM Operation o WHERE o.idOperation = :idOperation"),
    @NamedQuery(name = "Operation.findByType", query = "SELECT o FROM Operation o WHERE o.type = :type"),
    @NamedQuery(name = "Operation.findByNumberInvoice", query = "SELECT o FROM Operation o WHERE o.numberInvoice = :numberInvoice"),
    @NamedQuery(name = "Operation.findByCost", query = "SELECT o FROM Operation o WHERE o.cost = :cost")})
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operation")
    private Integer idOperation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberInvoice")
    private int numberInvoice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private int cost;
    @JoinTable(name = "operation_material", joinColumns = {
        @JoinColumn(name = "id_operation", referencedColumnName = "id_operation")}, inverseJoinColumns = {
        @JoinColumn(name = "id_material", referencedColumnName = "id_material")})
    @ManyToMany
    private Collection<Material> materialCollection;
    @JoinColumn(name = "id_worker", referencedColumnName = "id_worker")
    @ManyToOne(optional = false)
    private Worker idWorker;

    public Operation() {
    }

    public Operation(Integer idOperation) {
        this.idOperation = idOperation;
    }

    public Operation(Integer idOperation, String type, int numberInvoice, int cost) {
        this.idOperation = idOperation;
        this.type = type;
        this.numberInvoice = numberInvoice;
        this.cost = cost;
    }

    public Integer getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(Integer idOperation) {
        this.idOperation = idOperation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(int numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @XmlTransient
    public Collection<Material> getMaterialCollection() {
        return materialCollection;
    }

    public void setMaterialCollection(Collection<Material> materialCollection) {
        this.materialCollection = materialCollection;
    }

    public Worker getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Worker idWorker) {
        this.idWorker = idWorker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperation != null ? idOperation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.idOperation == null && other.idOperation != null) || (this.idOperation != null && !this.idOperation.equals(other.idOperation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Operation[ idOperation=" + idOperation + " ]";
    }
    
}
