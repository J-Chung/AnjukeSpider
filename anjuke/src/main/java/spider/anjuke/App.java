package spider.anjuke;

import java.util.ArrayList;

import spider.anjuke.model.AnjukeHouseInfo;
import spider.anjuke.parse.ParseAnjuke;

public class App {
	public static void main(String[] args) {
		try {
			String url = "http://su.fang.anjuke.com";
			ParseAnjuke anjuke = new ParseAnjuke();
			boolean flag = false;
			for (int i = 2;; i++) {
				ArrayList<AnjukeHouseInfo> infos = anjuke.getInfo(url);
				for (AnjukeHouseInfo info : infos) {
					System.out.println(info + "\n\n");
				}
				flag = true;
				if (flag) {
					url = "http://su.fang.anjuke.com/loupan/all/p" + i + "/";
				}
			}
		} catch (Exception e) {
			System.out
					.println("------------------------------结---------------------束----------------------------------------");
		}

	}
}
