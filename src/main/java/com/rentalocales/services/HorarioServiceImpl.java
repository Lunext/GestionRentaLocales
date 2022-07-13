package com.rentalocales.services;

import com.rentalocales.models.Horario;
import com.rentalocales.models.Local;
import com.rentalocales.repositories.HorarioRepository;
import com.rentalocales.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//@Component
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horariorepository;

    @Autowired
    LocalRepository localRepository;
    @Override
    public List<Horario> listHorarios() {
        return horariorepository.findAll();
    }

    @Override
    public Horario saveHorario(Horario horario) {


        return horariorepository.save(horario);



    }

    @Override
    public Horario getHorarioById(Integer id) {
        return horariorepository.findById(id).get();
    }

    @Override
    public Horario updateHorario(Horario horario) {
        return horariorepository.save(horario);
    }

    @Override
    public void deleteHorario(Integer id) {

         horariorepository.deleteById(id);

    }
}
