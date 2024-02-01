package com.suraShop.jss.service.Impl;

import com.suraShop.jss.Entity.PedidosEntity;
import com.suraShop.jss.dto.PedidosDto;
import com.suraShop.jss.mapping.PedidosMapping;
import com.suraShop.jss.repository.IpedidosRepo;
import com.suraShop.jss.service.IpedidosService;
import com.suraShop.jss.util.LocalDateFomatter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PedidosServiceImpl implements IpedidosService {

    private final IpedidosRepo ipedidosRepo;

    @Override
    public PedidosDto crearPedido(PedidosDto pedidosDto) {

        Optional<PedidosEntity> pedidosExiste = ipedidosRepo.findById(new PedidosMapping().PedidosIdDtoToPedidosIdEntity(pedidosDto.getIdPedido()));
        if(pedidosExiste.isEmpty()){
            PedidosEntity pedidosCrear = ipedidosRepo.saveAndFlush(new PedidosMapping().PedidosDtoToPedidosEntity(pedidosDto));
            if(Objects.nonNull(pedidosCrear)){
                PedidosDto pedidosResDto = new PedidosMapping().PedidosEntityToPedidosDto(pedidosCrear);
                return pedidosResDto;
            }
        }
        return null;
    }

    @Override
    public String eliminarPedido(PedidosDto pedidosDto) {

        Optional<PedidosEntity> pedidosExiste = ipedidosRepo.findById(new PedidosMapping().PedidosIdDtoToPedidosIdEntity(pedidosDto.getIdPedido()));

        if(!pedidosExiste.isEmpty()){
            ipedidosRepo.delete(new PedidosMapping().PedidosDtoToPedidosEntity(pedidosDto));
            return "El pedido fue borrado exitosamente";
        }
        return null;
    }

    @Override
    public List<PedidosDto> findAllByfechaPedido(String date1, String date2) {
        LocalDate fecha1 = new LocalDateFomatter().dateStringtoLocalDate(date1);
        LocalDate fecha2 = new LocalDateFomatter().dateStringtoLocalDate(date2);

        List<PedidosEntity> pedidosEntities = ipedidosRepo.findByfechaPedidoBetween(fecha1, fecha2);
        if(!pedidosEntities.isEmpty() && pedidosEntities.size()>0){
            List<PedidosDto> pedidosDtoList = new PedidosMapping().listPedidosEntityTolistPedidosDto(pedidosEntities);
            return pedidosDtoList;
        }
        return null;
    }


}
