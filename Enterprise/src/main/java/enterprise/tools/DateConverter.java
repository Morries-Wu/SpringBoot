package enterprise.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            /*字符串时间不为空才转换*/
            if (!"".equals(time)&&time != null) {
                return sdf.parse(time);
            }
            return null;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
