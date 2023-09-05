/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package EJB;

import Entities.Readers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author zarce
 */
@Local
public interface ReadersFacadeLocal {

    void create(Readers readers);

    void edit(Readers readers);

    void remove(Readers readers);

    Readers find(Object id);

    List<Readers> findAll();

    List<Readers> findRange(int[] range);

    int count();
    
}
