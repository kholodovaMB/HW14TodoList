package com.HMB.HW14TodoList.controller;

import com.HMB.HW14TodoList.entity.Note;
import com.HMB.HW14TodoList.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public ModelAndView listNotes() {
        ModelAndView allNotes = new ModelAndView("note/list");
        allNotes.addObject("notes", noteService.listAll());
        return allNotes;
    }
    @GetMapping("/edit")
    public ModelAndView editNoteForm(@RequestParam("id") UUID id) {
        ModelAndView editNote = new ModelAndView("note/edit");
        editNote.addObject("note", noteService.getById(id).orElse(null));
        return editNote;
    }

    @PostMapping("/edit")
    public String editNote(@ModelAttribute("note") Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @GetMapping("/create")
    public ModelAndView createNoteForm() {
        return new ModelAndView("note/create");
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute("note") Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }
    @PostMapping("/delete")
    public String deleteNote(@ModelAttribute("note") Note note) {
        noteService.deleteById(note.getId());
        return "redirect:/note/list";
    }

}
