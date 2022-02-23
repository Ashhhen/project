package com.internet_pharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.internet_pharmacy.service.InterfaceServMedicine;
import com.internet_pharmacy.session.SesObject;

import javax.annotation.Resource;

@Controller
public class ControlGeneral {

    @Autowired
    InterfaceServMedicine interMedicineServ;

    @Resource
    SesObject sessionObj;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("medicines", this.interMedicineServ.getAllMedicines());
        model.addAttribute("logged", this.sessionObj.isLog());
        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("logged", this.sessionObj.isLog());
        return "contact";
    }
}