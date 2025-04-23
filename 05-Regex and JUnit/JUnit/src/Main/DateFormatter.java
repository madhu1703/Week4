import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public String formatDate(String inputDate) throws ParseException {
        if (inputDate == null) {
            throw new IllegalArgumentException("Input date cannot be null");
        }

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFormat.setLenient(false);

        Date date = inputFormat.parse(inputDate);

        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        return outputFormat.format(date);
    }
}

