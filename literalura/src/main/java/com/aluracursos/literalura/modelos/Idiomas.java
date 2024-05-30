package com.aluracursos.literalura.modelos;

public enum Idiomas {
    ESPAÑOL("es"),
    INGLES("en"),
    FRANCES("fr"),
    PORTUGES("pt"),
    ITALIANO("it");

    private String idiomasDisponibles;

    Idiomas(String idiomasDisponibles) {
        this.idiomasDisponibles = idiomasDisponibles;
    }

    public static Idiomas fromString(String text) {
        for (Idiomas idioma : Idiomas.values()) {
            if (idioma.idiomasDisponibles.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ninguna idioma encontrada: " + text);
    }
}
