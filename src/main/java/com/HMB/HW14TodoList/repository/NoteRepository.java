package com.HMB.HW14TodoList.repository;

import com.HMB.HW14TodoList.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
}
