package ru.df3.notes.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "item")
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class NoteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    @Column(name = "type", nullable = false)
    private  Type type;
    private enum Type { CHECKBOX, TEXT}

    @Column(name = "is_done")
    private boolean isDone;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}
