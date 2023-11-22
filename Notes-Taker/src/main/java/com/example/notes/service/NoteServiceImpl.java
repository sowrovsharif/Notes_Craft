package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public Note saveOrUpdate(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
