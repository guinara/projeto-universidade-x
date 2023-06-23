package com.BancoDeDados.jpa;

import com.BancoDeDados.Model.Funcionario.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class JpaProfessorDAO {
    @PersistenceContext
    EntityManager manager;

    public JpaProfessorDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("faculdade");
        this.manager = factory.createEntityManager();
        manager.getTransaction().begin();
    }
    public void fechaManager(){
        this.manager.getTransaction().commit();
        this.manager.close();
    }
    public void adiciona(Professor professor) {
        manager.persist(professor);
        fechaManager();
    }

    public void altera(Professor professor) {
        manager.merge(professor);
        fechaManager();
    }

    public List<Professor> lista() {
        List<Professor> professores=manager.createQuery("from Professor").getResultList();
        fechaManager();
        return professores;
    }

    public Professor buscaPorId(int id) {
        return manager.find(Professor.class, id);
    }

    public void remove(Professor professor) {
        Professor professorARemover = buscaPorId(professor.getIdprofessor());
        manager.remove(professorARemover);
        fechaManager();
    }

}
