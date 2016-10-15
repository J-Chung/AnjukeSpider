package spider.anjuke.parse;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import spider.anjuke.model.AnjukeHouseInfo;

public class ParseAnjuke {

	public ArrayList<AnjukeHouseInfo> getInfo(String url) {

		System.out.println("===============================正在解析HTML============================================");

		ArrayList<AnjukeHouseInfo> infos = new ArrayList<AnjukeHouseInfo>();

		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 获取网页body内HTML
		Element body = doc.body();
		// 小区信息
		Elements areaName = body.select("a.items-name");
		// 地址
		Elements adresss = body.select("a.list-map");
		// 价格信息
		Elements prices = body.select("div.favor-pos");

		String[] str = { "价", "元", "万", "售价待定", "低", "[", "]", " " };// 判断

		if (areaName.size() == adresss.size() && areaName.size() == prices.size() && adresss.size() == prices.size()) {

			for (int i = 0; i < areaName.size(); i++) {

				AnjukeHouseInfo info = new AnjukeHouseInfo();

				// System.out.println(areaName.get(i).text());
				// 设置小区名
				info.setFloor_area(areaName.get(i).text());

				String adr = adresss.get(i).text();
				// System.out.println(adr);
				// 设置地址
				info.setHouseInfo(adresss.get(i).text());

				if (prices.get(i).text().indexOf(str[0]) > 0 && prices.get(i).text().indexOf(str[1]) > 0) {
					String price = (prices.get(i).text().split(str[0])[1]).split(str[1])[0];
					// System.out.println(price);
					info.setHousePrice(price);
				} else if (prices.get(i).text().indexOf(str[0]) > 0 && prices.get(i).text().indexOf(str[2]) > 0) {
					String price = (prices.get(i).text().split(str[0])[1]).split(str[2])[0];
					// System.out.println(price);
					info.setHousePrice(price);
				} else if (prices.get(i).text().indexOf(str[4]) > 0 && prices.get(i).text().indexOf(str[1]) > 0) {
					String price = (prices.get(i).text().split(str[4])[1]).split(str[1])[0];
					// System.out.println(price);
					info.setHousePrice(price);
				} else if (prices.get(i).text().indexOf(str[4]) > 0 && prices.get(i).text().indexOf(str[1]) > 0) {
					String price = (prices.get(i).text().split(str[4])[1]).split(str[1])[0];
					// System.out.println(price);
					info.setHousePrice(price);
				} else {
					String price = prices.get(i).text().split(" ")[0];
					// System.out.println(price);
					info.setHousePrice(price);
				}
				// System.out.println(prices.get(i).text());
				info.setProvince("江苏");
				info.setCity("苏州");
				info.setType("新房");
				infos.add(info);
			}

		}

		// System.out.println(areaName.size());
		// System.out.println(adresss.size());
		// System.out.println(prices.size());

		return infos;
	}
}
