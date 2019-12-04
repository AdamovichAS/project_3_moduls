package com.github.adamovichas.project.model.dto;

import com.github.adamovichas.project.model.bet.Status;

public class BetDTO {

    private Long id;
    private String userLogin;
    private Long factorId;
    private double money;
    private Status status;

    public BetDTO(String userLogin, Long factorId, double money) {
        this.userLogin = userLogin;
        this.factorId = factorId;
        this.money = money;
    }

    public BetDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Long getFactorId() {
        return factorId;
    }

    public void setFactorId(Long factorId) {
        this.factorId = factorId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
