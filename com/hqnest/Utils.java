package lottery.com.hqnest;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils{

	private static Utils instance = new Utils();
	private Utils(){

	}
	public static Utils getInstance(){
		return instance;
	}
	public String human2Timestamp(String time){
		try {
      		DateFormat formatter;
      		formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");
      		Date date = (Date) formatter.parse(time.trim());
      		java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
      		return String.valueOf(timeStampDate.getTime()/1000);
    	} catch (ParseException e) {
      		return time;
    	}
	}
}