package com.it.school.DTO.adress;

import com.it.school.model.Adress;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdressDTO {

  private String cep;

  private String logradouro;

  private String uf;

  private String bairro;

  private boolean erro;

  public AdressDTO(Adress adress) {
    this.cep = adress.getCep();
    this.logradouro = adress.getLogradouro();
    this.uf = adress.getUf();
    this.bairro = adress.getBairro();

  }

}
