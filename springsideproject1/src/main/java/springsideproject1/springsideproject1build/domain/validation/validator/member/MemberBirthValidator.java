package springsideproject1.springsideproject1build.domain.validation.validator.member;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import springsideproject1.springsideproject1build.domain.entity.member.MemberDto;

import java.time.DateTimeException;
import java.time.LocalDate;

import static springsideproject1.springsideproject1build.domain.vo.WORD.DAYS;

@Component
public class MemberBirthValidator implements Validator {

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return MemberDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        MemberDto memberDto = (MemberDto) target;
        LocalDate maxDate = LocalDate.now();

        // date
        try {
            LocalDate inputDate = LocalDate.of(memberDto.getYear(), memberDto.getMonth(), memberDto.getDays());

            if (inputDate.isAfter(maxDate)) {
                errors.rejectValue(DAYS, "Restrict");
            }
        } catch (DateTimeException e) {
            errors.rejectValue(DAYS, "TypeButInvalid");
        }
    }
}
