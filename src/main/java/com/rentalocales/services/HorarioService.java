package com.rentalocales.services;

import com.rentalocales.models.Horario;
import com.rentalocales.models.Local;

import java.util.List;

public interface HorarioService {

    public List<Horario> listHorarios();
    public Horario saveHorario(Horario horario);
    public Horario getHorarioById(Integer id);
    public Horario updateHorario(Horario horario);

    public void deleteHorario(Integer id);
}
