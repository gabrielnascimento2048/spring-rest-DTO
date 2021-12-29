package pt.com.consulta.cep.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pt.com.consulta.cep.model.Postal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostalResponseDTO {
    private String postal;
    private String logadouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;

    public PostalResponseDTO(Postal postal){
        this.postal = postal.getPostal();
        this.logadouro = postal.getLogadouro();
        this.complemento = postal.getComplemento();
        this.bairro = postal.getBairro();
        this.localidade = postal.getLocalidade();
        this.uf = postal.getUf();
        this.unidade = postal.getUnidade();
    }
}
