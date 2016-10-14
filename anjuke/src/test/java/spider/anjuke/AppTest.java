package spider.anjuke;

import spider.anjuke.parse.ParseAnjuke;
import spider.anjuke.util.HttpUtil;
import junit.framework.TestCase;

public class AppTest extends TestCase {
	
	public void getInfo(){
		String url = "http://shanghai.anjuke.com/";
		String get = HttpUtil.get(url, null);
		ParseAnjuke anjuke = new ParseAnjuke();
		anjuke.getInfo(get);
	}
}
