/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pws.a.prauas;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pws.a.prauas.exceptions.NonexistentEntityException;
import pws.a.prauas.exceptions.PreexistingEntityException;

/**
 *
 * @author user
 */

@Controller
@ResponseBody
public class mycontroller implements Serializable {
      Barang data = new Barang ();
      BarangJpaController actrl = new BarangJpaController();
    
    @RequestMapping ("/getAll")
    public List<Barang> viewAll() {
        return Barang.findBarangEntities();
    }
}

@RequestMapping ("/getName/{id}")
    public String getName(@PathVariable("id") int id) {
        try {
            data = actrl.findUntitled(id);
            return data.getName()+"<br>"+ data.getTglLahir();
        }
        catch (Exception error) {
            return " Data Tidak Ada";
        }
    }
        
    



