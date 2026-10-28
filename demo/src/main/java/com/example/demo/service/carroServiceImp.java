package com.example.demo.service;

import com.example.demo.model.Carro;
import com.example.demo.model.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
@Service
public class carroServiceImp implements carroService{
    @Autowired
    private CarroRepository carroRepository;

    @Override
    public Iterable<Carro> buscarTodos() {
        return carroRepository.findAll();

    }

    @Override
    public Carro buscarPorPlaca(String placa) {
        Optional<Carro> carro = carroRepository.findById(placa);
        return null;
    }

    @Override
    public void inserir(String placa, String modelo, String marca) {
        Carro carro = new Carro(placa, modelo, marca);
        carroRepository.save(carro);
    }


    @Override
    public void deletar(String placa) {
        if (carroRepository.existsById(placa)) {
            carroRepository.deleteById(placa);
        }
    }

    @Override
    public void atualizar(String placa, String modelo, String marca) {
        Optional<Carro> resultado = carroRepository.findById(placa);

        if (resultado.isPresent()) {
            Carro carro = resultado.get();
            carro.setMarca(marca);
            carro.setPlaca(placa);
            carroRepository.save(carro);
        }
    }
}
