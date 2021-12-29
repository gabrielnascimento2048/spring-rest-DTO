package pt.com.consulta.cep.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.com.consulta.cep.model.Postal;

@Data // getters and setters
@AllArgsConstructor // constrcutor no argurments
@NoArgsConstructor // constructor with arguments
public class PostalRequestDTO {
 // no conect Database
    private String postal;
    private String logadouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;
    private String ibge;


    public Postal build(){

        Postal postal = new Postal()
                .setPostal(this.postal)
                .setLocalidade(this.localidade)
                .setLogadouro(this.logadouro)
                .setComplemento(this.complemento)
                .setBairro(this.bairro)
                .setUf(this.uf)
                .setIbge(this.ibge)
                .setUnidade(this.unidade);
        return postal;
    }
}
