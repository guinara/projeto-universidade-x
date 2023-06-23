package com.BancoDeDados.jpa;

import com.BancoDeDados.Model.Aluno.Disciplina;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class JpaDisciplinaDAO {
    @PersistenceContext
    EntityManager manager;

    public JpaDisciplinaDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("faculdade");
        this.manager = factory.createEntityManager();
        manager.getTransaction().begin();
    }
    public void fechaManager(){
        this.manager.getTransaction().commit();
        this.manager.close();
    }
    public void adiciona(Disciplina disciplina) {
        manager.persist(disciplina);
        fechaManager();
    }

    public void altera(Disciplina disciplina) {
        manager.merge(disciplina);
        fechaManager();
    }

    public List<Disciplina> lista() {
        List<Disciplina> disciplinas =manager.createQuery("from Disciplina").getResultList();
        fechaManager();
        return disciplinas;
    }

    public Disciplina buscaPorId(int id) {
        return manager.find(Disciplina.class, id);
    }

    public void remove(Disciplina professor) {
        Disciplina discARemover = buscaPorId(professor.getIdDisciplina());
        manager.remove(discARemover);
        fechaManager();
    }
}
