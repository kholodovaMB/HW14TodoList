package com.HMB.HW14TodoList.dto;

import com.HMB.HW14TodoList.entity.Note;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {
    private UUID id;
    private String title;
    private String content;

    public NoteDTO(Note note) {
        this.id = note.getId();
        this.title = note.getTitle();
        this.content = note.getContent();
    }

    public static NoteDTO fromNote(Note note) {
        NoteDTO dto = new NoteDTO();
        dto.setId(note.getId());
        dto.setTitle(note.getTitle());
        dto.setContent(note.getContent());
        return dto;
    }
    public Note toEntity() {
        Note note = new Note();
        note.setId(this.id);
        note.setTitle(this.title);
        note.setContent(this.content);
        return note;
    }
}
