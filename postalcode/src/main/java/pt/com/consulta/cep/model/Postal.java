package pt.com.consulta.cep.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Postal {

  @Id
private String postal;

private String logadouro;
private String complemento;
private String bairro;
private String localidade;
private String uf;
private String unidade;
private String ibge;

}
