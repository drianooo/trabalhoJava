package com.bd.sitebd.model;

import java.math.BigDecimal;
import java.util.Map;

public class Tool {

    public static Pet converterPet(Map<String, Object> registro) {

        return new Pet((Integer) registro.get("cd_Pet"),
                       (String) registro.get("nm_Pet"),
                       (String) registro.get("nm_Especie"),
                       (BigDecimal) registro.get("qt_Peso"),
                       (String) registro.get("nm_Tutor"),
                       (String) registro.get("cd_CpfTutor"));
    }

}
