package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TesteJPARelacionamento {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setTitular("Carlos");
        conta.setBanco("Itau");
        conta.setNumero("54321");
        conta.setAgencia("3344");
//      conta.setId(2);  Atualizar conta já existente com merge
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Aniversario");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200"));
        movimentacao.setConta(conta);

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

;

        manager.persist(conta);
//        manager.merge(conta);

        manager.persist(movimentacao);

        manager.getTransaction().commit();

        manager.close();
    }
}
