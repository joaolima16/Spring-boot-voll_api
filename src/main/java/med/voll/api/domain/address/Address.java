package med.voll.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {
    private String street;
    private String district;
    private String cep;
    private String city;
    private String uf;
    private String complement;
    private String number;
    public Address(DataAddress address) {
        this.street = address.street();
        this.district = address.district();
        this.cep = address.cep();
        this.city = address.city();
        this.uf = address.uf();
        this.complement = address.complement();
        this.number = address.number();
    }
    public void update(DataAddress address){
        if(address.street() != null){
            this.street = address.street();
        }
        if(address.district() != null){
            this.district = address.district();

        }
        if(address.cep() != null){
            this.cep = address.cep();
        }
        if(address.city() != null){
            this.city = address.city();
        }
        if(address.uf() != null){
            this.uf = address.uf();
        }
        if(address.complement() != null){
            this.complement = address.complement();
        }
        if(address.number() != null){
            this.number = address.number();
        }
    }



}
