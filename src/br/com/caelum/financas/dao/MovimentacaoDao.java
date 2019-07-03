package br.com.caelum.financas.dao;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MovimentacaoDao {

    private EntityManager manager;

    public MovimentacaoDao(EntityManager manager){

        this.manager = manager;
    }

    public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {
        TypedQuery<Double> query = manager.createQuery("select avg(m.valor) from Movimentacao m where m.conta=:pConta"
                + " and m.tipoMovimentacao = :pTipo", Double.class);
        query.setParameter("pTipo", tipo);
        query.setParameter("pConta",conta);

        // BigDecimal soma =  query.getSingleResult();
        Double media = query.getSingleResult();
        return media;
    }
}
