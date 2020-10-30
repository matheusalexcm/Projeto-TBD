/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import model.Produto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Matheus
 */
public class HQL {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Query q = session.createQuery("select max(vlProduto) from Produto");

        List<Produto> resultado = q.list();
        
        for (Produto produto : resultado) {
            System.out.println("Produto mais caro: " + produto.getNmProduto());
        }

        session.close();
    }

}
