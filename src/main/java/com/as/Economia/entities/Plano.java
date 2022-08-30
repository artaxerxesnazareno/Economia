package com.as.Economia.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate data;
    private Double total;
    private Double cinquenta;
    private Double quarenta;
    private Double dez;

    @OneToMany
    List<Renda> rendas;

    public Plano() {
        this.setData(LocalDate.now(ZoneId.systemDefault()));

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getCinquenta() {
        return cinquenta;
    }

    public void setCinquenta(Double cinquenta) {
        this.cinquenta = cinquenta;
    }

    public Double getQuarenta() {
        return quarenta;
    }

    public void setQuarenta(Double quarenta) {
        this.quarenta = quarenta;
    }

    public Double getDez() {
        return dez;
    }

    public void setDez(Double dez) {
        this.dez = dez;
    }

    @Override
    public String toString() {
        return "Plano{" +
                "Id=" + Id +
                ", data=" + data +
                ", total=" + total +
                ", cinquenta=" + cinquenta +
                ", quarenta=" + quarenta +
                ", dez=" + dez +
                ", rendas=" + rendas +
                '}';
    }
}
