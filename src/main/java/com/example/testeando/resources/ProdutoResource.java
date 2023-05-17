package com.example.testeando.resources;

import com.example.testeando.domain.Categoria;
import com.example.testeando.domain.Produto;
import com.example.testeando.dto.CategoriaDTO;
import com.example.testeando.dto.ProdutoDTO;
import com.example.testeando.resources.utils.URL;
import com.example.testeando.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> listar(@PathVariable Integer id){
        Produto obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<ProdutoDTO>> findPage(
            @RequestParam(value = "nome", defaultValue = "") String  nome,
            @RequestParam(value = "categorias", defaultValue = "") String  categorias,
            @RequestParam(value = "page", defaultValue = "0") Integer  page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction){
        String nomeDecodeParam = URL.decodeParam(nome);
         List<Integer> ids = URL.decodeIntList(categorias);
        Page<Produto> list = service.search(nomeDecodeParam, ids, page, linesPerPage, orderBy, direction);
        Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }
}
