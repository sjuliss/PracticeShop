package com.suraShop.jss.repository;

import com.suraShop.jss.Entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IproductosRepo extends JpaRepository<ProductosEntity, Integer> {

    List<ProductosEntity> findByFechaProdBetween(LocalDate fecha1, LocalDate fecha2);


}
