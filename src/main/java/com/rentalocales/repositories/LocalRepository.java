package com.rentalocales.repositories;

import com.rentalocales.models.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Local, Integer > {

    @Query("select l from Local l where"+
    " CONCAT(l.id,l.localName,l.city)"
    + " like %?1% ")
    public List<Local> findAll(String keyWord);



}
