package com.internet_pharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.internet_pharmacy.service.InterfaceServBasket;
import com.internet_pharmacy.session.SesObject;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/basket")
public class ControlBasket {

    @Autowired
    InterfaceServBasket interBasketServ;

    @Resource
    SesObject sessionObj;

    @RequestMapping(value = "/add/{medicineId}")
    public String addMedicineToBasket(@PathVariable Integer medicineId) {
        this.interBasketServ.addMedicineToBasket(medicineId);
        return "redirect:/main";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String basket(Model model) {
        model.addAttribute("basket",
                this.sessionObj.getBasket());
        model.addAttribute("sum", this.sessionObj.getBasket().getSum());
        model.addAttribute("logged", this.sessionObj.isLog());

        return "basket";
    }
}