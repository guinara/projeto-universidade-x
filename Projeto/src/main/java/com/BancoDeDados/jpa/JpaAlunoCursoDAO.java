package com.BancoDeDados.jpa;


import com.BancoDeDados.Model.Aluno.AlunoCurso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaAlunoCursoDAO {
    @PersistenceContext
    EntityManager manager;

    public JpaAlunoCursoDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("faculdade");
        this.manager = factory.createEntityManager();
        manager.getTransaction().begin();
    }
    public void fechaManager(){
        this.manager.getTransaction().commit();
        this.manager.close();
    }
    public void adiciona(AlunoCurso alunoCurso) {
        manager.persist(alunoCurso);
        fechaManager();
    }

    public void altera(AlunoCurso alunoCurso) {
        manager.merge(alunoCurso);
        fechaManager();
    }

    public List<AlunoCurso> lista() {
        List<AlunoCurso> alunoCursos=manager.createQuery("from aluno_curso").getResultList();
        fechaManager();
        return alunoCursos;
    }

    public AlunoCurso buscaPorId(int id) {
        AlunoCurso alunoCursoAchado=(AlunoCurso)manager.find(AlunoCurso.class, id);
        return alunoCursoAchado;
    }

    public void remove(AlunoCurso alunoCurso) {
        AlunoCurso alunoCursoARemover = buscaPorId(alunoCurso.getIdAluno());
        manager.remove(alunoCursoARemover);
        fechaManager();
    }

}