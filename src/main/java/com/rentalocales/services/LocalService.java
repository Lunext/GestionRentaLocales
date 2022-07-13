package com.rentalocales.services;

import com.rentalocales.models.Local;

import java.util.List;

public interface LocalService {

    public List<Local> listLocals(String keyWord);
    public Local saveLocal(Local local);
    public Local getLocalById(Integer id);
    public Local updateLocal(Local local);

    public void deleteLocal(Integer id);


}
