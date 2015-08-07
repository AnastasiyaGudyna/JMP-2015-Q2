package com.gudyna.model.validation;

import com.gudyna.model.Member;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MemberValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Member.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"surname","required");

        Member member = (Member) obj;
        if (member.getAge()<0 || member.getAge()>150)
        {
            errors.rejectValue("age", "age.not.in.range");
        }
    }
}
