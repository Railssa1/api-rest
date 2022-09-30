package br.com.projeto.helloworld.repository;

import br.com.projeto.helloworld.entity.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Integer>{

    Personagem findByNome(String nome);
}
