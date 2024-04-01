package com.campusjaider.audiovisualmanagement.persistence.converter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Converter {
    public static <T, U> U convertTo(T entityOrigin, Class<U> entityFinalClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        U entidadDestino = entityFinalClass.getDeclaredConstructor().newInstance();
        Field[] fieldsEntityOrigin = entityOrigin.getClass().getDeclaredFields();
        for (Field fieldOrigin : fieldsEntityOrigin) {
            fieldOrigin.setAccessible(true);
            Object valor = fieldOrigin.get(entityOrigin);
            if (valor != null) {
                try {
                    Field campoDestino = entityFinalClass.getDeclaredField(fieldOrigin.getName());
                    campoDestino.setAccessible(true);
                    campoDestino.set(entidadDestino, valor);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                }
            }
        }
        return entidadDestino;
    }
}
