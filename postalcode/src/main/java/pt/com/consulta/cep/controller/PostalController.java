package pt.com.consulta.cep.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pt.com.consulta.cep.Refactory.PostalRepository;
import pt.com.consulta.cep.dto.request.PostalRequestDTO;
import pt.com.consulta.cep.dto.response.PostalResponseDTO;
import pt.com.consulta.cep.model.ApiMessage;
import pt.com.consulta.cep.model.Postal;

@RestController
@RequestMapping("api/postal")
@Api("API for retrieve Postal Code")
public class PostalController {

    @Autowired
    PostalRepository postalRepository;

    @GetMapping("/{postal}")
    @ApiOperation("Retrieve address for Postal Code.")
    public ResponseEntity<Object> getPostal(@PathVariable String postal){
        Postal postalObject = postalRepository.getByPostal(postal);
        if (postalObject != null) {
            return new ResponseEntity<> (new PostalResponseDTO(postalObject), HttpStatus.OK);
        } else {
            String url = "https://viacep.com.br/ws/"+ postal +"/json/";
            RestTemplate restTemplate = new RestTemplate();
            try {
                Postal postalResponse = restTemplate.getForObject(url, Postal.class);
                return new ResponseEntity<>(new PostalResponseDTO(postalResponse), HttpStatus.OK);
            }catch (HttpClientErrorException httpClientErrorException){
                return new ResponseEntity<> (new ApiMessage(httpClientErrorException.getMessage()), httpClientErrorException.getStatusCode());
            }
        }
    }
    @PostMapping
    @ApiOperation("Create a new address to save to the database")
    public ResponseEntity<Object> postPostal(@RequestBody PostalRequestDTO postalDto){
        if (postalDto.getPostal() == "" || postalDto.getPostal() == null) {
            return new ResponseEntity<> (new ApiMessage("Favor informar número Postal"), HttpStatus.BAD_REQUEST);
        }
        Postal postal = this.postalRepository.save(postalDto.build());
        return new ResponseEntity<>(postal, HttpStatus.CREATED);
    }
}
