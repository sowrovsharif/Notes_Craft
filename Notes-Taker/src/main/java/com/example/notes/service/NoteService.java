package com.example.notes.service;

import com.example.notes.model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note saveOrUpdate(Note note);
    void deleteNote(Long id);
}
