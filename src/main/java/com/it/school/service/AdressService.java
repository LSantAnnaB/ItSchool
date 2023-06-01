package com.it.school.service;

import com.it.school.DTO.adress.AdressDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AdressService {

    public AdressDTO adressQuery(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        try {

            AdressDTO adress = restTemplate.getForEntity("https://viacep.com.br/ws/" + cep + "/json/", AdressDTO.class)
                    .getBody();
            return adress;

        } catch (HttpServerErrorException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
