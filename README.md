# kona-web-rest-example


```
public class UserSessionExample {

  public static void main(String[] args) throws IOException, URISyntaxException {
    HttpDelegate httpDelegate = new HttpDelegate();
    int shopId = 1;

    httpDelegate.signIn("email", "password");

    JSONObject funnelsDay = httpDelegate.insightsFunnels(shopId, "2015-05-01", "2015-06-01", "day");
    System.out.println(funnelsDay.toString(2));

    JSONObject funnelsHour = httpDelegate.insightsFunnels(shopId, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour");
    System.out.println(funnelsHour.toString(2));

    JSONObject vendorsDay = httpDelegate.insightsVendors(shopId, "2015-05-01", "2015-06-01", "day");
    System.out.println(vendorsDay.toString(2));

    JSONObject vendorsHour = httpDelegate.insightsVendors(shopId, "2015-07-01T00:00:00", "2015-07-06T23:59:59", "hour");
    System.out.println(vendorsHour.toString(2));
  }
}

```
