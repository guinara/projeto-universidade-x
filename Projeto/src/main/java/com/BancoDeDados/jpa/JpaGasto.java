package com.BancoDeDados.jpa;

import com.BancoDeDados.Model.Financeiro.Gasto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class JpaGasto {
    @PersistenceContext
    EntityManager manager;
    public JpaGasto() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("faculdade");
        this.manager = factory.createEntityManager();
        manager.getTransaction().begin();
    }
    public void fechaManager(){
        this.manager.getTransaction().commit();
        this.manager.close();
    }
    public void adiciona(Gasto gasto) {
        manager.persist(gasto);
        fechaManager();
    }

    public void altera(Gasto gasto) {
        manager.merge(gasto);
        fechaManager();
    }

    public List<Gasto> lista() {
        List<Gasto> gastos=manager.createQuery("from Gasto").getResultList();
        fechaManager();
        return gastos;
    }

    public Gasto buscaPorId(int id) {
        Gasto gastoAchado=manager.find(Gasto.class, id);
        return gastoAchado;
    }

    public void remove(Gasto gasto) {
        Gasto gastoARemover = buscaPorId(gasto.getIdgasto());
        manager.remove(gastoARemover);
        fechaManager();
    }
}
