import org.apache.http.cookie.Cookie;
import org.json.JSONObject;
import util.HttpDelegate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by huy on 15. 7. 7..
 */
public class UserSessionExample {

  public static void main(String[] args) throws IOException, URISyntaxException {
    HttpDelegate httpDelegate = new HttpDelegate();
    int shopId = 319;

    httpDelegate.signIn("huy@zoyi.co", "qweqweqwe");

    JSONObject funnelsDay = httpDelegate.insightsFunnels(20, "2015-05-01", "2015-06-01", "day");
    System.out.println(funnelsDay.toString(2));

    JSONObject funnelsHour = httpDelegate.insightsFunnels(20, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour");
    System.out.println(funnelsHour.toString(2));

    JSONObject vendorsDay = httpDelegate.insightsVendors(20, "2015-05-01", "2015-06-01", "day");
    System.out.println(vendorsDay.toString(2));

    JSONObject vendorsHour = httpDelegate.insightsVendors(20, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour");
    System.out.println(vendorsHour.toString(2));
  }
}
