package com.argentinaPrograma.PortFolio.DTO.GetPutDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@SuperBuilder (toBuilder = true)
@NoArgsConstructor
public class GetTema {
    Long id;
    String nombre;
    String mainColor;   
}

