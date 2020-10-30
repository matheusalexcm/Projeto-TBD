/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Pessoa;
import model.dao.PessoaDAO;
import org.hibernate.Session;

/**
 *
 * @author Matheus
 */
public class PessoaTest {
    
    public static void main(String[] args) {
        
        Pessoa p = new Pessoa();
        p.setNmPessoa("Joao");
        p.setNmPessoa("Maria");
        
        PessoaDAO dao = new PessoaDAO();
        p = dao.save(p);
     
    }
    
}
