package com.rentalocales.services;

import com.rentalocales.models.Local;
import com.rentalocales.repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalServiceImpl implements LocalService{

    @Autowired
    private LocalRepository repository;

    @Override
    public List<Local> listLocals(String keyWord) {

        if(keyWord!=null){
            return repository.findAll(keyWord);
        }

        return repository.findAll();
    }

    @Override
    public Local saveLocal(Local local) {
        return repository.save(local);
    }

    @Override
    public Local getLocalById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Local updateLocal(Local local) {
        return repository.save(local);
    }

    @Override
    public void deleteLocal(Integer id) {

        repository.deleteById(id);

    }
}
