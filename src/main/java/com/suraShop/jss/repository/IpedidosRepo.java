package com.suraShop.jss.repository;

import com.suraShop.jss.Entity.PedidosEntity;
import com.suraShop.jss.Entity.PedidosIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IpedidosRepo extends JpaRepository<PedidosEntity, PedidosIdEntity> {

    @Override
    Optional<PedidosEntity> findById(PedidosIdEntity pedidosIdEntity);

    List<PedidosEntity> findByfechaPedidoBetween(LocalDate fecha1, LocalDate fecha2);


}
