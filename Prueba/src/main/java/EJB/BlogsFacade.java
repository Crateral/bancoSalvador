/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EJB;

import Entities.Blogs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zarce
 */
@Stateless
public class BlogsFacade extends AbstractFacade<Blogs> implements BlogsFacadeLocal {

    @PersistenceContext(unitName = "bancoSalvador")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BlogsFacade() {
        super(Blogs.class);
    }
    
}
