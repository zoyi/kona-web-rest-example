import org.apache.http.HttpResponse;
import org.apache.http.cookie.Cookie;
import org.json.JSONObject;
import util.HttpDelegate;
import util.JSON;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by huy on 15. 7. 7..
 */
public class UserSessionExample {

  public static void main(String[] args) throws IOException, URISyntaxException {
    int shopId = 1;
    /*

      By Session

     */
    HttpDelegate httpDelegate = new HttpDelegate();
    httpDelegate.signIn("email", "password");
    JSONObject funnelsDay = httpDelegate.insightsFunnels(shopId, "2015-05-01", "2015-06-01", "day");
    JSONObject funnelsHour = httpDelegate.insightsFunnels(shopId, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour");
    JSONObject vendorsDay = httpDelegate.insightsVendors(shopId, "2015-05-01", "2015-06-01", "day");
    JSONObject vendorsHour = httpDelegate.insightsVendors(shopId, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour");

    /*

      By Authentication Token In Url

     */
    HttpDelegate authTokenInUrlHttpDelegate = new HttpDelegate();
    JSONObject authTokenInUrl = authTokenInUrlHttpDelegate.signIn("email", "password").getJSONObject("user");
    authTokenInUrlHttpDelegate.insightsFunnelsByAuthTokenInUrl(shopId, "2015-05-01", "2015-06-01", "day",
        authTokenInUrl.getString("email"), authTokenInUrl.getString("authentication_token"));
    authTokenInUrlHttpDelegate.insightsFunnelsByAuthTokenInUrl(shopId, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour",
        authTokenInUrl.getString("email"), authTokenInUrl.getString("authentication_token"));
    authTokenInUrlHttpDelegate.insightsFunnelsByAuthTokenInUrl(shopId, "2015-05-01", "2015-06-01", "day",
        authTokenInUrl.getString("email"), authTokenInUrl.getString("authentication_token"));
    authTokenInUrlHttpDelegate.insightsFunnelsByAuthTokenInUrl(shopId, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour",
        authTokenInUrl.getString("email"), authTokenInUrl.getString("authentication_token"));

    /*

      By Authentication Token In Header

     */
    HttpDelegate authTokenInHeaderHttpDelegate = new HttpDelegate();
    JSONObject authTokenInHeader = authTokenInHeaderHttpDelegate.signIn("email", "password").getJSONObject("user");
    authTokenInHeaderHttpDelegate.insightsFunnelsByAuthTokenInHeader(shopId, "2015-05-01", "2015-06-01", "day",
        authTokenInHeader.getString("email"), authTokenInHeader.getString("authentication_token"));
    authTokenInHeaderHttpDelegate.insightsFunnelsByAuthTokenInHeader(shopId, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour",
        authTokenInHeader.getString("email"), authTokenInHeader.getString("authentication_token"));
    authTokenInHeaderHttpDelegate.insightsFunnelsByAuthTokenInHeader(shopId, "2015-05-01", "2015-06-01", "day",
        authTokenInHeader.getString("email"), authTokenInHeader.getString("authentication_token"));
    authTokenInHeaderHttpDelegate.insightsFunnelsByAuthTokenInHeader(shopId, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour",
        authTokenInHeader.getString("email"), authTokenInHeader.getString("authentication_token"));
  }
}
