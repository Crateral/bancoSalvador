/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import EJB.BlogsFacadeLocal;
import Entities.Blogs;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("blogController")
@ManagedBean
@SessionScoped
public class BlogController implements Serializable{
    
    @EJB
    private BlogsFacadeLocal  blogFacade;
    private List<Blogs> blogs;
    private Blogs blog;
    String mensaje = "";

    public BlogsFacadeLocal getBlogFacade() {
        return blogFacade;
    }

    public void setBlogFacade(BlogsFacadeLocal blogFacade) {
        this.blogFacade = blogFacade;
    }

    public List<Blogs> getBlogs() {
        this.blogs = this.blogFacade.findAll();
        return blogs;
    }

    public void setBlogs(List<Blogs> blogs) {
        this.blogs = blogs;
    }

    public Blogs getBlog() {
        return blog;
    }

    public void setBlog(Blogs blog) {
        this.blog = blog;
    }
    
    @PostConstruct
    public void init(){
        this.blog = new Blogs();
    }
    public void guardar(){
        try {
            blog.setId(0);
            this.blogFacade.create(blog);
            this.blog = new Blogs();
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
            this.blogFacade.edit(blog);
            this.blog = new Blogs();
            this.mensaje = "Actualizado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void eliminar(Blogs b){
        try {
            this.blogFacade.remove(b);
            this.blog = new Blogs();
            this.mensaje = "Eliminado Con exito";
        } catch (Exception e) {
            e.printStackTrace();
            this.mensaje = "Error : " + e.getMessage();
        }
        FacesMessage mens = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mens);
    }
    public void cargarID(Blogs b){
        this.blog = b;
    }
    public void limpiar(){
        this.blog = new Blogs();
    }
}
