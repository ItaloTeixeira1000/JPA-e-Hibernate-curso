package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TestaConsulta {
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();
        Conta conta = new Conta();
        conta.setId(10);

        Query query = manager.createQuery("select m from Movimentacao m where m.conta=:pConta"
                + " and m.tipoMovimentacao = :pTipo"
                + " order by m.valor desc");
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);
        query.setParameter("pConta",conta);
        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao m : movimentacoes){
            System.out.println("\nDescricao: "+ m.getDescricao());
            System.out.println("Valor: " + m.getValor());
        }

    }
}
