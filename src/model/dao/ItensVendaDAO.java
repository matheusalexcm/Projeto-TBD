/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import javax.persistence.EntityManager;
import model.ItensVenda;

/**
 *
 * @author Matheus
 */
public class ItensVendaDAO {

    public ItensVenda save(ItensVenda itensVenda) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(itensVenda);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return itensVenda;
    }
}
