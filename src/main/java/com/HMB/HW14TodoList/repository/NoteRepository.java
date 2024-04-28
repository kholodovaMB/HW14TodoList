package com.HMB.HW14TodoList.repository;

import com.HMB.HW14TodoList.entity.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class NoteRepository {
    private List<Note> notes = new ArrayList<>();

    public Note createNote(Note note){
        note.setId(UUID.randomUUID());
        this.notes.add(note);
        return note;
    }
    public List<Note> findAllNotes(){
        return this.notes;
    }
    public Optional<Note> findById (UUID id) {
        return Optional.ofNullable(this.notes.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Note with ID " + id + "not found")));
    }
    public void deleteById(UUID id) {
        Optional<Note> noteToDelete = findById(id);
        if (noteToDelete.isPresent()) {
            Note toDelete = noteToDelete.get();
            notes.remove(toDelete);
        }
    }

    public void update(Note note){
        Optional<Note> noteToUpdate = findById(note.getId());
        if (noteToUpdate.isPresent()) {
            this.notes.remove(noteToUpdate.get());
            this.notes.add(note);
        }
    }
}
