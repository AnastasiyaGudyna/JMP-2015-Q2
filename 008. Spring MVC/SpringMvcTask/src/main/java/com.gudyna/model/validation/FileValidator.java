package com.gudyna.model.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gudyna.model.File;

public class FileValidator implements Validator
{
    @Override
    public boolean supports(Class<?> aClass)
    {
        return File.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors)
    {
        File file = (File) obj;
        if (file.getFile().getSize() == 0)
        {
            errors.rejectValue("file", "valid.file");
        }
    }

}
