package com.sfood.mapper.impl;

import com.sfood.dto.OrderDTO;
import com.sfood.entity.order.OrderEntity;
import com.sfood.mapper.GenericMapper;
import com.sfood.repository.BillDiscountRepository;
import com.sfood.repository.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements GenericMapper<OrderEntity, OrderDTO> {
    @Autowired
    private OrderDetailsMapper orderDetailsMapper;
    @Autowired
    private BillDiscountRepository billDiscountRepository;
    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Override
    public OrderDTO toDTO(OrderEntity entity) {
        OrderDTO dto = new OrderDTO();
        dto.setId(entity.getId());
        dto.setPaymentMethod(entity.getPaymentMethod());
        dto.setLstOrderDetails(orderDetailsMapper.toDTOList(entity.getLstOrderDetails()));
        dto.setBillDiscountId(entity.getBillDiscount().getId());
        dto.setOrderInfoId(entity.getOrderInfo().getId());
        return dto;
    }

    @Override
    public OrderEntity toEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        entity.setId(dto.getId());
        entity.setPaymentMethod(dto.getPaymentMethod());
        entity.setLstOrderDetails(orderDetailsMapper.toEntityList(dto.getLstOrderDetails()));
        entity.setBillDiscount(billDiscountRepository.findOne(dto.getBillDiscountId()));
        entity.setOrderInfo(orderInfoRepository.findOne(dto.getOrderInfoId()));
        return entity;
    }
}
