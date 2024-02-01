package com.suraShop.jss.repository;

import com.suraShop.jss.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IusuarioRepo extends JpaRepository<UsuarioEntity, Integer> {

    UsuarioEntity findBycedula(String cedula);
}
