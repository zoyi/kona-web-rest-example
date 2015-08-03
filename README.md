## Setting up Intellij IDEA & gradle

To develop your application via Intellij IDEA, you need to install the following pieces of software.
- [Java Development Kit 7+ (JDK) (6 will not work!)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Intellij IDEA 14.+](https://www.jetbrains.com/idea/download/), the Community edition is sufficient. On Mac OS X, as of December 2014, JetBrains still recommends running Intellij IDEA under [Apple JDK 6](http://support.apple.com/kb/DL1572) (you have to install it in addition to the JDK listed above, it will be picked automatically by Intellij), due to [unresolved issues](https://intellij-support.jetbrains.com/entries/27854363-IDE-doesn-t-start-after-updating-to-Mac-OS-Yosemite-or-Mavericks) with Oracle JDK 7+.
- [Gradle 2.3+](http://gradle.org/gradle-download/), java library package manager

## Using libraries
- [org.apache.httpcomponents:httpclient:4.2.3](http://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient/4.2.3)
- [org.json:json:20140107](http://mvnrepository.com/artifact/org.json/json/20140107)

## Example Code
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
