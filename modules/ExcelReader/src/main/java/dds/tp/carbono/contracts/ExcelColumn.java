package dds.tp.carbono.contracts;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExcelColumn {
    int index();
}
