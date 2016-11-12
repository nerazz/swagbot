package dbot.comm;

import static dbot.Poster.post;

import dbot.SQLPool;
import dbot.UserData;
import dbot.comm.items.Xpot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.handle.obj.IUser;

import java.sql.*;
import java.util.regex.*;

final class Buy {
	private static final Logger LOGGER = LoggerFactory.getLogger("dbot.comm.Buy");

	static void m(IUser buyer, String params) {
		Pattern pattern = Pattern.compile("([a-z]+)(\\s(.+))?");
		Matcher matcher = pattern.matcher(params);
		if (!matcher.matches()) return;
		switch (matcher.group(1)) {
			case "xpot":
				if (matcher.group(3) == null) return;
				pattern = Pattern.compile("([a-z]+)");
				matcher = pattern.matcher(matcher.group(3));
				if (!matcher.matches()) return;
				new Xpot(buyer, matcher.group(1));
				break;

			case "reminder":
				int price = 100;
				int anzahl = 1;
				params = "" + matcher.group(3);
				pattern = pattern.compile("\\d+");//sollte negative abfangen
				matcher = pattern.matcher(params);
				if (matcher.matches()) anzahl = Integer.parseInt(matcher.group());

				UserData data = new UserData(buyer, 129);//gems, reminder
				if (data.getGems() < (price * anzahl)) {
					post(buyer + ", du hast zu wenig :gem:.");
					return;
				}
				data.subGems(price * anzahl);
				data.addReminder(anzahl);
				LOGGER.info("{} bought {} Reminder", buyer.getName(), anzahl);
				if (anzahl > 1) {
					post(buyer + ", hier sind deine " + anzahl + " Reminder!");
				} else {
					post(buyer + ", hier ist dein Reminder!");
				}
				data.update();
				break;

			default:
				break;
			}
		}
}
