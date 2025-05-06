package com.example.projetofinalbloco02.controller;

import com.example.projetofinalbloco02.model.Produto;
import com.example.projetofinalbloco02.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto novoProduto) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(novoProduto.getNome());
                    produto.setCodigoBarras(novoProduto.getCodigoBarras());
                    produto.setDescricao(novoProduto.getDescricao());
                    produto.setPreco(novoProduto.getPreco());
                    produto.setQuantidadeEstoque(novoProduto.getQuantidadeEstoque());
                    produto.setFabricante(novoProduto.getFabricante());
                    produto.setPrecisaReceita(novoProduto.isPrecisaReceita());
                    produto.setPrincipioAtivo(novoProduto.getPrincipioAtivo());
                    produto.setDosagem(novoProduto.getDosagem());
                    produto.setDataValidade(novoProduto.getDataValidade());
                    produto.setCategoria(novoProduto.getCategoria());
                    return ResponseEntity.ok(produtoRepository.save(produto));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }

    @DeleteMapping
    public void deletarTudo() {
        produtoRepository.deleteAll();
    }
}