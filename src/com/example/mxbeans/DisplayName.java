package com.example.mxbeans;

import javax.management.DescriptorKey;
import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DisplayName {

    @DescriptorKey("displayname")
    String value();
}
