package com.HMB.HW14TodoList.service;

import com.HMB.HW14TodoList.entity.Note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteServiceInterface {
    List<Note> listAll();
    Note add(Note note);
    Optional<Note> getById(UUID id);
    void deleteById(UUID id);
    void update(Note note);
}
