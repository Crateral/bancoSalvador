/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author zarce
 */
@Entity
@Table(name = "readers")
@NamedQueries({
    @NamedQuery(name = "Readers.findAll", query = "SELECT r FROM Readers r"),
    @NamedQuery(name = "Readers.findById", query = "SELECT r FROM Readers r WHERE r.id = :id"),
    @NamedQuery(name = "Readers.findByName", query = "SELECT r FROM Readers r WHERE r.name = :name")})
public class Readers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "readersCollection")
    private Collection<Blogs> blogsCollection;

    public Readers() {
    }

    public Readers(Integer id) {
        this.id = id;
    }

    public Readers(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Blogs> getBlogsCollection() {
        return blogsCollection;
    }

    public void setBlogsCollection(Collection<Blogs> blogsCollection) {
        this.blogsCollection = blogsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Readers)) {
            return false;
        }
        Readers other = (Readers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Readers[ id=" + id + " ]";
    }
    
}
