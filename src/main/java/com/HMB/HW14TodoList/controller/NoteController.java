package com.HMB.HW14TodoList.controller;

import com.HMB.HW14TodoList.dto.NoteDTO;
import com.HMB.HW14TodoList.entity.Note;
import com.HMB.HW14TodoList.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public ModelAndView listNotes() {
        ModelAndView allNotes = new ModelAndView("note/list");
        List<Note> notes = noteService.listAll();
        List<NoteDTO> noteDTOs = notes.stream()
                .map(NoteDTO::new)
                .collect(Collectors.toList());
        allNotes.addObject("notes", noteDTOs);
        return allNotes;
    }

    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam("id") UUID id) {
        ModelAndView editNote = new ModelAndView("note/edit");
        Note note = noteService.getById(id).orElse(null);
        editNote.addObject("note", new NoteDTO(note));
        return editNote;
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute("note") NoteDTO noteDTO) {
        noteService.update(noteDTO.toEntity());
        return "redirect:/note/list";
    }

    @GetMapping("/create")
    public ModelAndView createNoteForm() {
        return new ModelAndView("note/create");
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute("note") NoteDTO noteDTO) {
        noteService.add(noteDTO.toEntity());
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") UUID id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
