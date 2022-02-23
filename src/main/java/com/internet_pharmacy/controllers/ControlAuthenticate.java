package com.internet_pharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.internet_pharmacy.exceptions.ExpectAuthenticateValidator;
import com.internet_pharmacy.exceptions.ExceptLoginAlreadyUse;
import com.internet_pharmacy.model.view.URegister;
import com.internet_pharmacy.service.InterfaceServAuthenticate;
import com.internet_pharmacy.session.SesObject;
import com.internet_pharmacy.validators.ValidatLog;
import com.internet_pharmacy.validators.ValidatReg;

import javax.annotation.Resource;

@Controller
public class ControlAuthenticate {

    @Autowired
    InterfaceServAuthenticate interAuthenticateServ;

    @Resource
    SesObject sessionObj;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginModel(Model model) {
        model.addAttribute("logged", this.sessionObj.isLog());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login, @RequestParam String password) {
        try {
            ValidatLog.validateLogin(login);
            ValidatLog.validatePass(password);
        } catch (ExpectAuthenticateValidator except) {
            return "redirect:/login";
        }

        this.interAuthenticateServ.authenticate(login, password);

        if(this.sessionObj.isLog()) {
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.sessionObj.setUser(null);
        return "redirect:/main";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("logged", this.sessionObj.isLog());
        model.addAttribute("ruser", new URegister());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute URegister userRegister) {
        try {
            ValidatReg.validateName(userRegister.getName());
            ValidatReg.validateSurname(userRegister.getSurname());
            ValidatLog.validateLogin(userRegister.getLogin());
            ValidatLog.validatePass(userRegister.getPassword());
            checkPasswords(userRegister.getPassword(), userRegister.getPassword2());
            this.interAuthenticateServ.register(userRegister);
        } catch (ExpectAuthenticateValidator | ExceptLoginAlreadyUse except) {
            return "redirect:/register";
        }

        return "redirect:/main";
    }

    private void checkPasswords(String password1, String password2) {
        if(password1 == null || !password1.equals(password2)) {
            throw new ExpectAuthenticateValidator("Incorrect passwords !");
        }
    }
}