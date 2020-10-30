/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import javax.persistence.EntityManager;
import model.Pessoa;

/**
 *
 * @author Matheus
 */
public class PessoaDAO {
    
    public Pessoa save(Pessoa pessoa) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
        return pessoa;
    }
    
}
