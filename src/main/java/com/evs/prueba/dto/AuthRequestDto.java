package com.evs.prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 3988784342333807863L;

    private String username;
    private String password;
}
