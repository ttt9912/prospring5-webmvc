package ch.rest.serialization;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.exolab.castor.mapping.ValidityException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/*
 * Custom Castor field handler for LocalDate <-> String conversion
 */
public class DateTimeFieldHandler extends GeneralizedFieldHandler {

    private static String dateFormatPattern;

    @Override
    public void setConfiguration(final Properties config) throws ValidityException {
        // retrieved from oxm-mapping.xml
        dateFormatPattern = config.getProperty("date-format");
    }

    @Override
    public Object convertUponGet(final Object value) {
        final LocalDate date = (LocalDate) value;
        return format(date);
    }

    @Override
    public Object convertUponSet(final Object value) {
        String dateString = (String) value;
        return parse(dateString);
    }

    @Override
    public Class getFieldType() {
        return LocalDate.class;
    }

    protected static String format(final LocalDate date) {
        if (date == null) {
            return "";
        }

        return DateTimeFormatter.ofPattern(dateFormatPattern)
                .format(date);
    }

    protected static LocalDate parse(final String dateString) {
        if (dateString == null) {
            return null;
        }

        final DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(dateFormatPattern);
        return (LocalDate) formatter.parse(dateString);
    }
}
