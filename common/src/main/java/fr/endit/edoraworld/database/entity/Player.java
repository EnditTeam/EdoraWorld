package fr.endit.edoraworld.database.entity;

import java.util.UUID;

import org.jetbrains.annotations.Nullable;

import fr.endit.edoraworld.database.converter.UUIDConverter;
import fr.endit.edoraworld.enUwUm.Nation;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NamedQuery(name = "Player.findByUUID", query = "from Player where uuid = :uuid")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @NonNull
    @Convert(converter = UUIDConverter.class)
    @Column
    private UUID uuid;

    @Column
    @Enumerated(EnumType.STRING)
    @Nullable
    private Nation nation;
}
