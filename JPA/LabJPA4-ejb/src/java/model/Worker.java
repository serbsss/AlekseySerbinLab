/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author НР
 */
@Entity
@Table(name = "worker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Worker.findAll", query = "SELECT w FROM Worker w"),
    @NamedQuery(name = "Worker.findByIdWorker", query = "SELECT w FROM Worker w WHERE w.idWorker = :idWorker"),
    @NamedQuery(name = "Worker.findByFio", query = "SELECT w FROM Worker w WHERE w.fio = :fio"),
    @NamedQuery(name = "Worker.findByWorkExp", query = "SELECT w FROM Worker w WHERE w.workExp = :workExp"),
    @NamedQuery(name = "Worker.findBySalary", query = "SELECT w FROM Worker w WHERE w.salary = :salary"),
    @NamedQuery(name = "Worker.findByLogin", query = "SELECT w FROM Worker w WHERE w.login = :login"),
    @NamedQuery(name = "Worker.findByPassword", query = "SELECT w FROM Worker w WHERE w.password = :password"),
    @NamedQuery(name = "Worker.findByPosition", query = "SELECT w FROM Worker w WHERE w.position = :position")})
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_worker")
    private Integer idWorker;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fio")
    private String fio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "work_exp")
    private int workExp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private int salary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "position")
    private String position;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idWorker")
    private Collection<Operation> operationCollection;

    public Worker() {
    }

    public Worker(Integer idWorker) {
        this.idWorker = idWorker;
    }

    public Worker(Integer idWorker, String fio, int workExp, int salary, String login, String password, String position) {
        this.idWorker = idWorker;
        this.fio = fio;
        this.workExp = workExp;
        this.salary = salary;
        this.login = login;
        this.password = password;
        this.position = position;
    }

    public Integer getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(Integer idWorker) {
        this.idWorker = idWorker;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getWorkExp() {
        return workExp;
    }

    public void setWorkExp(int workExp) {
        this.workExp = workExp;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @XmlTransient
    public Collection<Operation> getOperationCollection() {
        return operationCollection;
    }

    public void setOperationCollection(Collection<Operation> operationCollection) {
        this.operationCollection = operationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWorker != null ? idWorker.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Worker)) {
            return false;
        }
        Worker other = (Worker) object;
        if ((this.idWorker == null && other.idWorker != null) || (this.idWorker != null && !this.idWorker.equals(other.idWorker))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Worker[ idWorker=" + idWorker + " ]";
    }
    
}
