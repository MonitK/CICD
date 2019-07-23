package com.study.spring.mvc.recipes.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.study.spring.mvc.recipes.command.NotesCommand;
import com.study.spring.mvc.recipes.domain.Notes;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand>
{
	@Override
    public NotesCommand convert(Notes notes) {
        if (notes == null) {
            return null;
        }

        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(notes.getId());
        notesCommand.setRecipeNotes(notes.getRecipeNotes());
        return notesCommand;
    }
}
