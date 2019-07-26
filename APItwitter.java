import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class APItwitter {
    private final static String CONSUMER_KEY = "bJy3qxmj6ObumdRJLmn5ffvvF";
    private final static String CONSUMER_KEY_SECRET = "3OAZHbjLSjUQuEgb2cIQfFUAHUfxTcVjLy3Aao5WbUdeTZh78c";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("malaaaaammmmm");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "l6Ny7RPxhDeaAiIX8lneMWg8B06N8Oe4sO6BOtPPugCXL";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1850339179-yUWkRhyHuhshP84FxX48n3Nm0ndrxXSAROLK1B6";
    }

    public static void main(String[] args) throws Exception {
	new APItwitter().start();
    }
}