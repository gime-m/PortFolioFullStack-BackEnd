package com.argentinaPrograma.PortFolio.DTO.GetPutDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@SuperBuilder (toBuilder = true)
@NoArgsConstructor
public final class GetPutPersonaTema{
    private long personaId;
    private long temaId;
}
