package com.HMB.HW14TodoList.service;

import com.HMB.HW14TodoList.entity.Note;
import com.HMB.HW14TodoList.repository.NoteRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService implements NoteServiceInterface{
    @Autowired private final NoteRepository notes;

    public NoteService(NoteRepository notes) {
        this.notes = notes;
    }

    @PostConstruct
    public void init() {
        System.out.println("Start Application");
    }

    @Override
    public List<Note> listAll() {
        return notes.findAllNotes();
    }

    @Override
    public Note add(Note note) {
        return notes.createNote(note);
    }

    public Optional<Note> getById(UUID id) {
        return notes.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        notes.deleteById(id);
    }

    @Override
    public void update(Note note) {
        notes.update(note);
    }
    @PreDestroy
    public void destroy() {
        System.out.println("Stop Application");
    }
}
