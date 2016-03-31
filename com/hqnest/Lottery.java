package lottery.com.hqnest;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Lottery{

	public static void main(String[] args){
		try{
			int index = 0;
			String[] l = new String[9];
			Document doc = Jsoup.connect("http://kj.cp.ifeng.com/kaijiang/fcssq/index").get();

			Element lt = doc.getElementsByClass("kjCont").get(0);
			doc = Jsoup.parse(lt.toString());
			// id
			l[0] = doc.getElementById("lotteryResult_issueNoId").text();
			// time
			l[1] = doc.getElementById("lotteryResult_openTimeId").text();
			l[1] = Utils.getInstance().human2Timestamp(l[1]);
			// blue
			l[2] = doc.getElementsByClass("kj-blue").get(0).text();
			Elements reds = doc.getElementsByClass("kj-red");
			for(Element element : reds){
				l[3+index] = element.text();
				index++;
			}

			DBManager.getInstance().insertLottery(l);

		}catch(IOException e){

		}catch(Exception e){

		}
	}
}
