package com.as.Economia.services;

import com.as.Economia.entities.Plano;
import com.as.Economia.entities.Renda;
import com.as.Economia.repositories.PlanoRepository;
import com.as.Economia.repositories.RendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlanoService {
    private Plano plano;
    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private RendaRepository rendaRepository;

    List<Renda> rendas =null;

    public void salvar(Renda renda) {
         rendas = rendaRepository.findAll();

        List<Plano> planos = planoRepository.findAll();
        if (planos.isEmpty()) {
            plano = new Plano();
            planoRepository.save(plano);
            System.out.println("1 Plano salvo");
        }

        if (rendas.contains(renda)) {
            rendas.add(renda);

            planoSetValores(plano);
            renda.setPlano(plano);
            planoUpdate(plano);
            rendaRepository.save(renda);
            System.out.println("2 Plano salvo");
        } else if (rendas.isEmpty()) {
            rendas.add(renda);

            planoSetValores(plano);
            renda.setPlano(plano);
            rendaRepository.save(renda);
            System.out.println("3 Plano salvo");

        } else {
            rendas.add(renda);
            plano = new Plano();
            planoRepository.save(planoSetValores(plano));
            renda.setPlano(plano);
            rendaRepository.save(renda);
            System.out.println("4 Plano salvo");
        }
    }

    public Plano planoSetValores(Plano plano) {

        plano.setTotal(total(rendas));
        plano.setCinquenta(total(rendas) * 0.5);
        plano.setQuarenta(total(rendas) * 0.4);
        plano.setDez(total(rendas) * 0.1);
        return plano;
    }

    private Double total(List<Renda> rendas) {
        Double total = 0.0;
        for (Renda renda :
                rendas) {
            if (renda.getAno() == LocalDate.now().getYear() && renda.getMes() == LocalDate.now().getMonthValue()) {
                total += renda.getValor();
            }

        }
        System.out.println("Total é: " + total);
        return total;
    }

    public ResponseEntity planoUpdate(Plano plano) {

        return planoRepository.findById(plano.getId()).map( planoUpdate ->{
            planoUpdate.setTotal(plano.getTotal());
            planoUpdate.setQuarenta(plano.getQuarenta());
            planoUpdate.setCinquenta(plano.getCinquenta());
            planoUpdate.setDez(plano.getDez());
            Plano update = planoRepository.save(planoUpdate);
            return ResponseEntity.ok().body(update);
        }).orElse(ResponseEntity.notFound().build());
    }

public Plano showPlano(){
        List<Plano> planos = planoRepository.findAll();
    for (int i = 0; i < planos.size(); i++){
        if (planos.get(i).getData().getYear() == LocalDate.now().getYear() && planos.get(i).getData().getMonthValue() == LocalDate.now().getMonthValue()){
            return planoRepository.getReferenceById(planos.get(i).getId());
        }
    }
    return null;
}
}
