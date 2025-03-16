package com.sfood.service.impl;

import com.sfood.controller.web.BillDiscount;
import com.sfood.dto.CartItemDTO;
import com.sfood.dto.OrderDTO;
import com.sfood.dto.other_dto.CheckOutItem;
import com.sfood.dto.other_dto.CheckOutOrder;
import com.sfood.entity.cart.CartItemEntity;
import com.sfood.entity.item.FoodEntity;
import com.sfood.entity.order.OrderDetailsEntity;
import com.sfood.entity.order.OrderEntity;
import com.sfood.mapper.impl.CartItemMapper;
import com.sfood.mapper.impl.FoodMapper;
import com.sfood.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BillDiscountRepository billDiscountRepository;
    @Autowired
    private OrderInfoRepository orderInfoRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    public void processCheckOut(CheckOutOrder checkOutOrder) {
        OrderEntity order = new OrderEntity();
        order.setPaymentMethod(checkOutOrder.getPaymentMethod());
        order.setBillDiscount(checkOutOrder.getBillDiscountId() != null
                ? billDiscountRepository.findOne(checkOutOrder.getBillDiscountId()) : null);
        order.setOrderInfo(orderInfoRepository.findOne(checkOutOrder.getOrderInfoId()));

        order = orderRepository.save(order);


        for(int i = 0; i < checkOutOrder.getCartItems().size(); i++) {
            CartItemDTO item = (checkOutOrder.getCartItems().get(i));

            FoodEntity food = foodRepository.findOne(checkOutOrder.getFoodIdList().get(i));

            OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
            orderDetailsEntity.setOrder(order);
            orderDetailsEntity.setFood(food);
            orderDetailsEntity.setQuantity(item.getQuantity());
            orderDetailsRepository.save(orderDetailsEntity);

            CartItemEntity cartItem = cartItemRepository.findByFoodIdAndCartId(food.getId(), checkOutOrder.getCartId());
            if(cartItem != null) {
                if(cartItem.getQuantity() > item.getQuantity()) {
                    cartItem.setQuantity(cartItem.getQuantity() - item.getQuantity());
                    cartItemRepository.save(cartItem);
                }
                else {
                    cartItemRepository.delete(cartItem);
                }
            }

        }

    }
}
