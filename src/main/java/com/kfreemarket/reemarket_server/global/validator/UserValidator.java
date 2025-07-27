package com.kfreemarket.reemarket_server.global.validator;


import com.kfreemarket.reemarket_server.domain.user.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {

        User u = (User) obj;
        if(StringUtils.isEmpty(u.getMobileNumber())){
            errors.rejectValue("mobileNumber", "", "Mobile number is required");
        }
    }
}
