package com.sfood.api;

import com.sfood.dto.CustomerDTO;
import com.sfood.dto.OrderInfoDTO;
import com.sfood.service.impl.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderInfoAPI {
    @Autowired
    private OrderInfoService orderInfoService;

    @ModelAttribute("user")
    public CustomerDTO getUserFromSession(HttpSession session) {
        return (CustomerDTO) session.getAttribute("user");
    }

    @PostMapping("/add-order-info")
    public ResponseEntity<String> addOrderInfo(@RequestBody OrderInfoDTO orderInfoDTO,
                                               @ModelAttribute("user") CustomerDTO user) {
        orderInfoService.addOrderInfo(orderInfoDTO, user);
        return ResponseEntity.ok("Address added successfully!");
    }

    @PutMapping("/update-order-info")
    public ResponseEntity<String> updateOrderInfo(@RequestBody OrderInfoDTO orderInfoDTO,
                                                  @ModelAttribute("user") CustomerDTO user) {
        orderInfoService.updateOrderInfo(orderInfoDTO, user);
        return ResponseEntity.ok("Address updated successfully!");
    }

    @GetMapping("/get-order-info")
    public ResponseEntity<List<OrderInfoDTO>> getOrderInfo(@ModelAttribute("user") CustomerDTO user) {
        List<OrderInfoDTO> orderInfoList = orderInfoService.getOrderInfo(user.getId());
        orderInfoList.sort(((o1, o2) -> Boolean.compare(o2.isDefault(), o1.isDefault())));
        return ResponseEntity.ok(orderInfoList);
    }

    @PutMapping("/update-default-address")
    public ResponseEntity<String> updateDefaultAddress(@RequestBody Map<String, Long> request) {
        Long addressId = request.get("id");

        boolean success = orderInfoService.updateDefaultAddress(addressId);

        return success
                ? ResponseEntity.ok("Default address updated successfully")
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update address");
    }

    @DeleteMapping("/delete-order-info/{id}")
    public ResponseEntity<Void> deleteOrderInfo(@PathVariable("id") Long id) {
        try {
            orderInfoService.deleteOrderInfo(id);
            return ResponseEntity.noContent().build();
        }  catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
