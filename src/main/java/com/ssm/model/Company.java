package com.ssm.model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Created by wuyd on 2017/4/6.
 */
@JsonAutoDetect
public class Company {
    private String companyname;
    private int starttime;
    private int payment;
    private String telephone;
    private int workernumber;
    private int income;
    private int vip;
    private String username;
    private String password;
    private String price;

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getWorkernumber() {
        return workernumber;
    }

    public void setWorkernumber(int workernumber) {
        this.workernumber = workernumber;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
