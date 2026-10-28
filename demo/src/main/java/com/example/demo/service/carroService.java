package com.example.demo.service;

import com.example.demo.model.Carro;
import org.springframework.stereotype.Service;

@Service
public interface carroService {
    Iterable<Carro> buscarTodos();
    Carro buscarPorPlaca(String placa);
    void inserir(String placa, String modelo, String marca);
    void deletar(String placa);
    void atualizar(String placa, String modelo, String marca);
}
