package com.yygnb.demo.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: com.yygnb.demo.common.validator.OneOfValidator
 * @Description: <h1></h1>
 * @Date: 2022/8/3 22:43
 * @Author dscloudy 小云哥
 * @Version v1.0
 * @Since JDK 1.8
 * Date     UpdateBy        Description
 * 2022/8/3 22:43   dscloudy    Create File.
 */
public class OneOfValidator implements ConstraintValidator<OneOf, String> {

    private List<String> list;

    @Override
    public void initialize(OneOf constraintAnnotation) {
        list = Arrays.asList(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }
        return list.contains(s);
    }
}
