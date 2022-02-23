package com.internet_pharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.internet_pharmacy.service.InterfaceServOrder;
import com.internet_pharmacy.session.SesObject;

import javax.annotation.Resource;

@Controller
public class ControlOrder {

    @Autowired
    InterfaceServOrder interOrderServ;

    @Resource
    SesObject sessionObj;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {
        this.interOrderServ.confOrder();
        return "redirect:/main";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(Model model) {
        model.addAttribute("orders", this.interOrderServ.getOrdersForCurrentUser());
        model.addAttribute("logged", this.sessionObj.isLog());
        return "orders";
    }
}
