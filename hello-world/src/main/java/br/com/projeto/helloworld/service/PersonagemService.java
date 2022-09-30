package br.com.projeto.helloworld.service;

import br.com.projeto.helloworld.entity.Personagem;
import br.com.projeto.helloworld.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> findAll(){
        return personagemRepository.findAll();
    }

    public Personagem findById(Integer id){
        return personagemRepository.findById(id).orElse(null);
    }

    public void delete(Integer id){
        personagemRepository.deleteById(id);
    }

    public void save(Personagem personagem){
        personagemRepository.save(personagem);
    }

}
