package com.argentinaPrograma.PortFolio.Model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter @Setter
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder(toBuilder = true)
public abstract class AbstractImageModel extends AbstractModel{
    
    @Column(length=60)
    private String imagen;
}
