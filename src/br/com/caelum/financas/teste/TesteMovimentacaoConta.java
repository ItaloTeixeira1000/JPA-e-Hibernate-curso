package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteMovimentacaoConta {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();
//        Conta conta = manager.find(Conta.class,10);
//        System.out.println(conta.getMovimentacoes().size());
        Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");
        List<Conta> contas = query.getResultList();

        for(Conta conta: contas){
            System.out.println("Número de movimentaçôes: "+ conta.getMovimentacoes().size());
        }
    }
}
