package com.sfood.controller.web;

import com.sfood.dto.CustomerDTO;
import com.sfood.dto.OrderInfoDTO;
import com.sfood.service.impl.AddressService;
import com.sfood.service.impl.CustomerService;
import com.sfood.service.impl.OrderInfoService;
import com.sfood.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class InformationController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private AddressService addressService;

    @ModelAttribute("user")
    public CustomerDTO getUserFromSession(HttpSession session) {
        return (CustomerDTO) session.getAttribute("user");
    }

    @GetMapping("/information")
    public String informationPage(HttpServletRequest request, Model model) {
        Long customerId = JwtUtils.getIdUser(request);
        CustomerDTO customerDTO = customerService.findCustomerById(customerId);

        Date dateOfBirth = customerDTO.getDateOfBirth();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(dateOfBirth);

        List<OrderInfoDTO> lstOrderInfo = orderInfoService.findOrderInfoByCustomerId(customerId);
        lstOrderInfo.sort(((o1, o2) -> Boolean.compare(o2.isDefault(), o1.isDefault())));

        model.addAttribute("lstOrderInfo", lstOrderInfo);
        model.addAttribute("dob", formattedDate);
        model.addAttribute("cus", customerDTO);
        return "web/information";
    }

}
