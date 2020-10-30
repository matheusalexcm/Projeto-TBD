/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import model.Cliente;
import model.Produto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Matheus
 */
public class ApiCriteria {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Cliente.class, "c");
        Criteria critVenda = criteria.createCriteria("Venda", "v");
        Criteria critItensVenda = criteria.createCriteria("ItensVenda", "itv");
        Criteria critProduto = criteria.createCriteria("Produto", "p");
            critVenda.add(Restrictions.eq("c.idPessoa", "v.idPessoa"));
            critItensVenda.add(Restrictions.eq("v.idVenda", "itv.idVenda"));
            critProduto.add(Restrictions.eq("itv.idProduto", "p.idProduto"));
            List<Cliente> clientes = criteria.list();
            List<Produto> produtos = criteria.list();
            
            for (Cliente cliente : clientes) {
                System.out.println(cliente.getNmPessoa());
            }
            
            for (Produto produto : produtos) {
                System.out.println(produto.getNmProduto());
        }

    }

}
