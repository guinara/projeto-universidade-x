package com.BancoDeDados.jpa;

import com.BancoDeDados.Model.Aluno.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaAlunoDao{
    @PersistenceContext
    EntityManager manager;

    public JpaAlunoDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("faculdade");
        this.manager = factory.createEntityManager();
        manager.getTransaction().begin();
    }
    public void fechaManager(){
        this.manager.getTransaction().commit();
        this.manager.close();
    }
    public void adiciona(Aluno aluno) {
        manager.persist(aluno);
        fechaManager();
    }

    public void altera(Aluno aluno) {
        manager.merge(aluno);
        fechaManager();
    }

    public List<Aluno> lista() {
        List<Aluno> alunos=manager.createQuery("from Aluno").getResultList();
        fechaManager();
        return alunos;
    }

    public Aluno buscaPorId(int id) {
        return manager.find(Aluno.class, id);
    }

    public void remove(Aluno aluno) {
        Aluno alunoARemover = buscaPorId(aluno.getIdAluno());
        manager.remove(alunoARemover);
       fechaManager();
    }

}
