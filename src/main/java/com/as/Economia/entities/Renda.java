package com.as.Economia.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

@Entity
@Table(name = "tb_renda")
public class Renda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
   @Size(max = 50)
   @NotNull
    private String nome;
    private String descricao;
    @NotEmpty
    private Double valor;

    private int ano;
    private int mes;
  private LocalDate data;

    @ManyToOne
    private Plano plano;

    public Renda() {
        this.setAno(LocalDate.now(ZoneId.systemDefault()).getYear());
        this.setMes(LocalDate.now(ZoneId.systemDefault()).getMonthValue());
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "Renda{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                ", plano=" + plano +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Renda renda = (Renda) o;
        return ano == renda.ano && mes == renda.mes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, mes);
    }
}
