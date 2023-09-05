/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import EJB.ReadersFacadeLocal;
import Entities.Readers;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author zarce
 */
@Named("readerController")
@ManagedBean
@SessionScoped
public class ReaderController implements Serializable{
    
    @EJB
    private ReadersFacadeLocal  readerFacade;
    private List<Readers> readers;
    private Readers reader;
    String mensaje = "";

    public ReadersFacadeLocal getReaderFacade() {
        return readerFacade;
    }

    public void setReaderFacade(ReadersFacadeLocal readerFacade) {
        this.readerFacade = readerFacade;
    }

    public List<Readers> getReaders() {
        this.readers = this.readerFacade.findAll();
        return readers;
    }

    public void setReaders(List<Readers> readers) {
        this.readers = readers;
    }

    public Readers getReader() {
        return reader;
    }

    public void setReader(Readers reader) {
        this.reader = reader;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @PostConstruct
    public void init(){
        this.reader = new Readers();
    }
    public void guardar(){
        try {
            reader.setId(0);
            this.readerFacade.create(reader);
            this.reader = new Readers();
            this.mensaje = "Almacenado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void actualizar(){
        try {
            this.readerFacade.edit(reader);
            this.reader = new Readers();
            this.mensaje = "Actualizado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void eliminar(Readers r){
        try {
            this.readerFacade.remove(r);
            this.reader = new Readers();
            this.mensaje = "Eliminado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void cargarID(Readers r){
        this.reader = r;
    }
    public void limpiar(){
        this.reader = new Readers();
    }
}
