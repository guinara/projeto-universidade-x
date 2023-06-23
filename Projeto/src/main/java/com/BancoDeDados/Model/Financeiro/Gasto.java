package com.BancoDeDados.Model.Financeiro;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="gasto")
public class Gasto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name= "idgasto",length = 11)
    int idgasto;
    @Column(name= "ano",length = 11)
    int ano;
    @Column(name= "tipo")
    String tipo;
    @Column(name= "jan",length = 11)
    double jan;
    @Column(name= "fev",length = 11)
    double fev;
    @Column(name= "mar",length = 11)
    double mar;
    @Column(name= "abr",length = 11)
    double abr;
    @Column(name= "mai",length = 11)
    double mai;
    @Column(name= "jun",length = 11)
    double jun;
    @Column(name= "jul",length = 11)
    double jul;
    @Column(name= "ago",length = 11)
    double ago;
    @Column(name= "set",length = 11)
    double set;
    @Column(name= "out",length = 11)
    double out;
    @Column(name= "nov",length = 11)
    double nov;
    @Column(name= "dez",length = 11)
    double dez;
    public int getIdgasto() {
        return idgasto;
    }

    public void setIdgasto(int idgasto) {
        this.idgasto = idgasto;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getJan() {
        return jan;
    }

    public void setJan(double jan) {
        this.jan = jan;
    }

    public double getFev() {
        return fev;
    }

    public void setFev(double fev) {
        this.fev = fev;
    }

    public double getMar() {
        return mar;
    }

    public void setMar(double mar) {
        this.mar = mar;
    }

    public double getAbr() {
        return abr;
    }

    public void setAbr(double abr) {
        this.abr = abr;
    }

    public double getMai() {
        return mai;
    }

    public void setMai(double mai) {
        this.mai = mai;
    }

    public double getJun() {
        return jun;
    }

    public void setJun(double jun) {
        this.jun = jun;
    }

    public double getJul() {
        return jul;
    }

    public void setJul(double jul) {
        this.jul = jul;
    }

    public double getAgo() {
        return ago;
    }

    public void setAgo(double ago) {
        this.ago = ago;
    }

    public double getSet() {
        return set;
    }

    public void setSet(double set) {
        this.set = set;
    }

    public double getOut() {
        return out;
    }

    public void setOut(double out) {
        this.out = out;
    }

    public double getNov() {
        return nov;
    }

    public void setNov(double nov) {
        this.nov = nov;
    }

    public double getDez() {
        return dez;
    }

    public void setDez(double dez) {
        this.dez = dez;
    }
}
