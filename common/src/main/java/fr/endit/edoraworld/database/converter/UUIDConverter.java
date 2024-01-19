package fr.endit.edoraworld.database.converter;

import java.util.UUID;

import jakarta.persistence.AttributeConverter;

public class UUIDConverter implements AttributeConverter<UUID, String> {
    @Override
    public String convertToDatabaseColumn(UUID attribute) {
        return attribute.toString();
    }

    @Override
    public UUID convertToEntityAttribute(String dbData) {
        return UUID.fromString(dbData);
    }

}
