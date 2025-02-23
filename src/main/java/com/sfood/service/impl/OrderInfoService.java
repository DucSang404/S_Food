package com.sfood.service.impl;

import com.sfood.dto.CustomerDTO;
import com.sfood.dto.OrderInfoDTO;
import com.sfood.entity.actor.CustomerEntity;
import com.sfood.entity.shipping.OrderInfoEntity;
import com.sfood.mapper.impl.CustomerMapper;
import com.sfood.mapper.impl.OrderInfoMapper;
import com.sfood.repository.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderInfoService {
    @Autowired
    private OrderInfoRepository orderInfoRepository;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private CustomerMapper customerMapper;
    public List<OrderInfoDTO> findOrderInfoByCustomerId(Long customerId) {
        List<OrderInfoEntity> lstOrderInfo = orderInfoRepository.findAllByCustomerId(customerId);
        List<OrderInfoDTO> lstOrderInfoDTO = new ArrayList<>();
        for(OrderInfoEntity entity : lstOrderInfo) {
            lstOrderInfoDTO.add(orderInfoMapper.toDTO(entity));
        }
        return lstOrderInfoDTO;
    }

    public void addOrderInfo(OrderInfoDTO dto, CustomerDTO customerDTO) {
        OrderInfoEntity entity = orderInfoMapper.toEntity(dto);
        CustomerEntity customer = customerMapper.toEntity(customerDTO);
        entity.setCustomer(customer);
        orderInfoRepository.save(entity);
    }

    public void updateOrderInfo(OrderInfoDTO dto, CustomerDTO customerDTO) {
        Optional<OrderInfoEntity> optionalEntity = orderInfoRepository.findById(dto.getId());
        if (optionalEntity.isPresent()) {
            OrderInfoEntity entity = optionalEntity.get();

            entity = orderInfoMapper.toEntity(dto);

            CustomerEntity customer = customerMapper.toEntity(customerDTO);
            entity.setCustomer(customer);

            orderInfoRepository.save(entity);
        } else {
            throw new RuntimeException("Error update order info");
        }
    }

    public List<OrderInfoDTO> getOrderInfo(Long userId) {
        List<OrderInfoEntity> lstEntity = orderInfoRepository.findAllByCustomerId(userId);
        List<OrderInfoDTO> lstDto = new ArrayList<>();

        for(OrderInfoEntity entity : lstEntity) {
            lstDto.add(orderInfoMapper.toDTO(entity));
        }

        return lstDto;
    }

    @Transactional
    public boolean updateDefaultAddress(Long addressId) {
        try {
            orderInfoRepository.findAll().forEach(o -> {
                o.setDefault(false);
            });
            OrderInfoEntity entity = orderInfoRepository.findById(addressId).orElseThrow(() -> new RuntimeException("Not found"));
            entity.setDefault(true);
            orderInfoRepository.save(entity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteOrderInfo(Long id) {
        OrderInfoEntity entity = orderInfoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OrderInfo not found with id:" + id));
        orderInfoRepository.delete(entity);
    }

}
