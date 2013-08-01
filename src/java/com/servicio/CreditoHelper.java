/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicio;

import org.hibernate.Session;

/**
 *
 * @author yepesk8r
 */
public class CreditoHelper {
    Session session = null;
    
    public CreditoHelper(){
    this.session = NewHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
        public String crear(Credito credito){
        try{
            // se obtiene la sesion
            Session s = NewHibernateUtil.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            s.save(credito);
            s.getTransaction().commit();
            return "guardado con exito";
            
        } catch ( Exception e) {
        e.printStackTrace();
        return "Error";
        }
    }
    
}

