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
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("Start Application");
    }

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Optional<Note> getById(UUID id) {
        return noteRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void update(Note note) {
        noteRepository.save(note);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Stop Application");
    }
}
