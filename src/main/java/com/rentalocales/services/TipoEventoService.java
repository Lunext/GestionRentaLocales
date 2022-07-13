package com.rentalocales.services;

import com.rentalocales.models.Horario;
import com.rentalocales.models.TipoEvento;

import java.util.List;

public interface TipoEventoService {

    public List<TipoEvento> listTiposEventos();
    public TipoEvento saveTipoEvento(TipoEvento tipoEvento);
    public TipoEvento getTipoEventoById(Integer id);
    public TipoEvento updateTipoEvento(TipoEvento tipoEvento);

    public void deleteTipoEvento(Integer id);
}
