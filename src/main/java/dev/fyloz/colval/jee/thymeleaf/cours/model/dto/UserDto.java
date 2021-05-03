package dev.fyloz.colval.jee.thymeleaf.cours.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @JsonProperty("data")
    private DataDto dataDTO;

    @JsonProperty("support")
    private SupportDto supportDTO;

    @Override
    public String toString() {
        return "UserDTO{" + "dataDTO=" + dataDTO + ", supportDTO=" + supportDTO + '}';
    }
}
