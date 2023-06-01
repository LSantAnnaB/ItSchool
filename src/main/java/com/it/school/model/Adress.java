package com.it.school.model;

import com.it.school.DTO.adress.AdressDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Adress implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String cep;

  private String logradouro;

  private String uf;

  private String bairro;

  // private boolean erro;


  public Adress(AdressDTO adressDTO) {
    this.cep = adressDTO.getCep();
    this.logradouro = adressDTO.getLogradouro();
    this.uf = adressDTO.getUf();
    this.bairro = adressDTO.getBairro();
  }
}
