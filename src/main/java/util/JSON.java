package util;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by huy on 15. 7. 7..
 */
public class JSON {
  public static JSONObject parse(InputStream body) throws IOException {
    BufferedReader rd = new BufferedReader(new InputStreamReader(body));
    StringBuffer result = new StringBuffer();
    String line = "";
    while ((line = rd.readLine()) != null) {
      result.append(line);
    }

    return new JSONObject(result.toString());
  }
}
