package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class TestaConsultaFuncoes {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();
        Conta conta = new Conta();
        conta.setId(10);

        //sum = soma
        //avg = média

        TypedQuery<Double> query = manager.createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        query.setParameter("pConta",conta);

        // BigDecimal soma =  query.getSingleResult();
        Double media = query.getSingleResult();
        System.out.println(media);
//        List<Movimentacao> movimentacoes = query.getResultList();
//
//        for (Movimentacao m : movimentacoes){
//            System.out.println("\nDescricao: "+ m.getDescricao());
//            System.out.println("Valor: " + m.getValor());
//        }

    }
}
