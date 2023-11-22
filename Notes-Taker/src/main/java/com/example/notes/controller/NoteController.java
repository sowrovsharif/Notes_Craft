package com.example.notes.controller;

import com.example.notes.model.Note;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public String getAllNotes(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());
        model.addAttribute("newNote", new Note());
        return "notes";
    }

    @GetMapping("/{id}")
    public String getNoteById(@PathVariable Long id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "notes";
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute Note note) {
        noteService.saveOrUpdate(note);
        return "redirect:/notes";
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "redirect:/notes";
    }
}
