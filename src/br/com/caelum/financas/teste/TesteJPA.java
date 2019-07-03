package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteJPA {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setId(10);
        conta.setTitular("Maria Santos");
        conta.setBanco("Itau");
        conta.setNumero("54321");
        conta.setAgencia("3344");

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        Conta removerConta = manager.find(Conta.class,10);

//        manager.remove(removerConta);
        removerConta.setTitular("Mario Santos");




        manager.getTransaction().commit();

        manager.close();
    }
}
