package com.internet_pharmacy.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.internet_pharmacy.model.Basket;
import com.internet_pharmacy.model.User;

@Component
@SessionScope
public class SesObject {
    private User user = null;
    final Basket basket = new Basket();

    public boolean isLog() {
        return this.user != null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Basket getBasket() {
        return basket;
    }
}
