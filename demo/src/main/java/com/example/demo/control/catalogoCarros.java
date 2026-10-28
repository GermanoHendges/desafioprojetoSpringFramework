package com.example.demo.control;

import com.example.demo.model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.carroService;

@RestController
@RequestMapping("carros")
public class catalogoCarros{
    @Autowired
    private carroService carros;

    @GetMapping
    public ResponseEntity<Iterable<Carro>> buscaTodos(){
        return ResponseEntity.ok(carros.buscarTodos());
    }

    @GetMapping("/{placa}")
    public ResponseEntity<Carro> buscarCarroPorPlaca(@PathVariable String placa) {
        return ResponseEntity.ok(carros.buscarPorPlaca(placa));
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deletaCarro(String placa){
        carros.deletar(placa);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{placa}")
    public ResponseEntity<Void> atualizaCarro(String placa, String modelo, String marca){
        carros.atualizar(placa, modelo, marca);
        return ResponseEntity.ok().build();
    }






}