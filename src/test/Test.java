/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Cliente;
import model.ItensVenda;
import model.Pessoa;
import model.Pessoa.Fone;
import model.Produto;
import model.Venda;
import model.dao.ClienteDAO;
import model.dao.ItensVendaDAO;
import model.dao.PessoaDAO;
import model.dao.ProdutoDAO;
import model.dao.VendaDAO;

/**
 *
 * @author Matheus
 */
public class Test {
    
    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Instancias
        Pessoa pessoa = new Pessoa();
        Cliente cliente = new Cliente();
        Venda venda = new Venda();
        ItensVenda itensVenda = new ItensVenda();
        Produto produto = new Produto();
        
        //Insert Pessoa
        PessoaDAO pDao = new PessoaDAO();
        
        //Insert Cliente
        ClienteDAO cliDao = new ClienteDAO();
        Fone fone = new Cliente().new Fone();
        
        cliente.setDtCadastro(sdf.parse("12/10/2017"));
        cliente.setNmPessoa("Valdira Neto");
        fone.setDdd(11);
        fone.setNumero(99999999);
        fone.setTipo('C');
        cliente = cliDao.save(cliente);
        
        cliente.setDtCadastro(sdf.parse("12/11/2016"));
        cliente.setNmPessoa("João da Silva");
        fone.setDdd(11);
        fone.setNumero(30000000);
        fone.setTipo('T');
        cliente = cliDao.save(cliente);
        
        //Insert Produto
        ProdutoDAO prodDao = new ProdutoDAO();
        
        produto.setNmProduto("Caneta");
        produto.setVlProduto(0.89);
        produto = prodDao.save(produto);
        
        produto.setNmProduto("Tesoura");
        produto.setVlProduto(2.50);
        produto = prodDao.save(produto);
        
        //Insert Venda
        VendaDAO vDao = new VendaDAO();
        
        cliente.setIdPessoa(1);
        venda.setCliente(cliente);
        venda.setDtVenda(sdf.parse("21/08/2020"));
        venda = vDao.save(venda);
        
        cliente.setIdPessoa(2);
        venda.setCliente(cliente);
        venda.setDtVenda(sdf.parse("07/09/2020"));
        venda = vDao.save(venda);
        
        //Insert Itens da Venda
        ItensVendaDAO iDao = new ItensVendaDAO();
        
        produto.setIdProduto(1);
        itensVenda.setProduto(produto);
        venda.setIdVenda(1);
        itensVenda.setVenda(venda);
        itensVenda.setQtde(Double.valueOf(5));
        itensVenda = iDao.save(itensVenda);
        
        produto.setIdProduto(2);
        itensVenda.setProduto(produto);
        venda.setIdVenda(2);
        itensVenda.setVenda(venda);
        itensVenda.setQtde(Double.valueOf(3));
        itensVenda = iDao.save(itensVenda);
    }
    
}
