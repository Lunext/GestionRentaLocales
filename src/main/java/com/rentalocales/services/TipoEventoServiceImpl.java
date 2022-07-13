package com.rentalocales.services;

import com.rentalocales.models.TipoEvento;
import com.rentalocales.repositories.LocalRepository;
import com.rentalocales.repositories.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEventoServiceImpl implements  TipoEventoService {

    @Autowired
    private TipoEventoRepository repository;
    @Override
    public List<TipoEvento> listTiposEventos() {
        return repository.findAll();
    }

    @Override
    public TipoEvento saveTipoEvento(TipoEvento tipoEvento) {
        return repository.save(tipoEvento);
    }

    @Override
    public TipoEvento getTipoEventoById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public TipoEvento updateTipoEvento(TipoEvento tipoEvento) {
        return repository.save(tipoEvento);
    }

    @Override
    public void deleteTipoEvento(Integer id) {
        repository.deleteById(id);

    }
}
