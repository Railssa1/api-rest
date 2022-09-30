package br.com.projeto.helloworld.controller;

import br.com.projeto.helloworld.entity.Personagem;
import br.com.projeto.helloworld.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public ResponseEntity<List<Personagem>> getPersonagens(){
        return ResponseEntity.ok(personagemService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Personagem> getPersonagemById(@PathVariable Integer id){
        Personagem personagemPersitido = personagemService.findById(id);

        if(Objects.nonNull(personagemPersitido)){
            return ResponseEntity.ok(personagemPersitido);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarPersonagem(@PathVariable Integer id){
        Personagem personagemPersitido = personagemService.findById(id);

        if(Objects.nonNull(personagemPersitido)) {
            personagemService.delete(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Personagem> atualizaPersonagem(@PathVariable Integer id, @RequestBody Personagem personagem){
       Personagem personagemPersitido = personagemService.findById(id);

       if(Objects.nonNull(personagemPersitido)){
           personagemPersitido.setNome(personagem.getNome());
           personagemService.save(personagemPersitido);
           return ResponseEntity.ok(personagemPersitido);

       }
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Personagem> salvaPersonagem(@RequestBody Personagem personagem){
        personagemService.save(personagem);
        return ResponseEntity.ok(personagem);
    }
}
