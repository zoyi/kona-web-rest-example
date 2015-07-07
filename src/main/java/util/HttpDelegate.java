package util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huy on 15. 7. 7..
 */
public class HttpDelegate {
  private final String API_URL = "https://walkinsights.com/api/v1";

  private final String USER_SIGN_IN = "/users/sign_in";
  private final String USER_SIGN_OUT = "/users/sign_out";

  private final String INSIGHTS_FUNNELS = "/shops/%d/insights/funnels";
  private final String INSIGHTS_VENDORS = "/shops/%d/insights/vendors";

  private final String KONA_SESSION = "_kona_session";

  private DefaultHttpClient httpClient;
  private List<Cookie> cookies;

  public List<Cookie> signIn(String email, String password) throws IOException {
    HttpClient client = getHttpClient();
    HttpPost post = new HttpPost(API_URL + USER_SIGN_IN);

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("user[email]", email));
    params.add(new BasicNameValuePair("user[password]", password));

    post.addHeader("content-type", "application/x-www-form-urlencoded");
    post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));

    HttpResponse response = client.execute(post);

    setCookies(httpClient.getCookieStore().getCookies()); // Save Session

    return httpClient.getCookieStore().getCookies();
  }

  public JSONObject insightsFunnels(Integer shopId, String from, String to, String unit) throws IOException, URISyntaxException {
    BasicCookieStore cookieStore = new BasicCookieStore();
    cookieStore.addCookies(cookies.toArray(new Cookie[cookies.size()]));
    HttpClient client = getHttpClient(cookieStore);

    URI uri = new URIBuilder(String.format(API_URL + INSIGHTS_FUNNELS, shopId))
        .addParameter("from", from)
        .addParameter("to", to)
        .addParameter("unit", unit).build();
    HttpGet get = new HttpGet(uri);

    HttpResponse response = client.execute(get);

    return JSON.parse(response.getEntity().getContent());
  }

  public JSONObject insightsVendors(Integer shopId, String from, String to, String unit) throws IOException, URISyntaxException {
    BasicCookieStore cookieStore = new BasicCookieStore();
    cookieStore.addCookies(cookies.toArray(new Cookie[cookies.size()]));
    HttpClient client = getHttpClient(cookieStore);

    URI uri = new URIBuilder(String.format(API_URL + INSIGHTS_VENDORS, shopId))
        .addParameter("from", from)
        .addParameter("to", to)
        .addParameter("unit", unit).build();
    HttpGet get = new HttpGet(uri);

    HttpResponse response = client.execute(get);

    return JSON.parse(response.getEntity().getContent());
  }

  private HttpClient getHttpClient() {
    return getHttpClient(null);
  }

  private HttpClient getHttpClient(BasicCookieStore defaultCookieStore) {
    httpClient = new DefaultHttpClient();
    if (defaultCookieStore == null) {
      defaultCookieStore = new BasicCookieStore();
    }
    httpClient.setCookieStore(defaultCookieStore);
    return httpClient;
  }

  public List<Cookie> getCookies() {
    return cookies;
  }

  public void setCookies(List<Cookie> cookies) {
    this.cookies = cookies;
  }
}
