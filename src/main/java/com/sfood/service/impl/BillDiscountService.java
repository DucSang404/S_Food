package com.sfood.service.impl;

import com.sfood.dto.BillDiscountDTO;
import com.sfood.entity.discount.BillDiscountEntity;
import com.sfood.mapper.impl.BillDiscountMapper;
import com.sfood.repository.BillDiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillDiscountService {
    @Autowired
    private BillDiscountRepository billDiscountRepository;
    @Autowired
    private BillDiscountMapper billDiscountMapper;
    public List<BillDiscountDTO> findAllValidBillDiscount() {
        List<BillDiscountEntity> entityList = billDiscountRepository.findAllValidBillDiscount();
        List<BillDiscountDTO> dtoList = new ArrayList<>();

        for(BillDiscountEntity entity : entityList) {
            dtoList.add(billDiscountMapper.toDTO(entity));
        }

        return dtoList;
    }
}
