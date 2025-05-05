package com.example.projetofinalbloco02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetofinalbloco02.model.Categoria;
import com.example.projetofinalbloco02.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria novaCategoria) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoria.setNome(novaCategoria.getNome());
                    categoria.setDescricao(novaCategoria.getDescricao());
                    categoria.setCodigo(novaCategoria.getCodigo());
                    categoria.setAtiva(novaCategoria.isAtiva());
                    return ResponseEntity.ok(categoriaRepository.save(categoria));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
    }

    @DeleteMapping
    public void deletarTudo() {
        categoriaRepository.deleteAll();
    }

	

}
