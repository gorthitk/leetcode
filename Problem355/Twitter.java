import java.util.*;

public class Twitter {
	Map<Integer, User> users;
	Map<Integer, List<Integer>> userTweets;
	Map<Integer, Tweet> tweets;
	int time = 0;
	public Twitter() {
		users = new HashMap<>();
		tweets = new HashMap<>();
		userTweets = new HashMap<>();
	}

	public void postTweet(int userId, int tweetId) {
		users.putIfAbsent(userId, new User(userId));
		userTweets.putIfAbsent(userId, new ArrayList<>());
		userTweets.get(userId).add(tweetId);
		tweets.put(tweetId, new Tweet(tweetId, time));
		time++;
	}

	public List<Integer> getNewsFeed(int userId) {
		if (!users.containsKey(userId)) return new ArrayList<>();
		PriorityQueue<Tweet> queue = new PriorityQueue<>(new Comparator<Tweet>() {

			@Override
			public int compare(Tweet o1, Tweet o2) {
				return o2.time - o1.time;
			}
		});

		addToQueue(userId, queue);
		for (Integer followeeId : users.get(userId).follows) {
			addToQueue(followeeId, queue);
		}

		List<Integer> newsFeed = new ArrayList<>();
		while (!queue.isEmpty() && newsFeed.size() < 10) {
			newsFeed.add(queue.poll().tweetId);
		}
		return newsFeed;
	}

	private void addToQueue(int userId, PriorityQueue<Tweet> queue) {
		for (Integer tweetId : userTweets.getOrDefault(userId, new ArrayList<>())) {
			queue.add(tweets.get(tweetId));
		}
	}
	public void follow(int followerId, int followeeId) {
		if (followerId == followeeId) return;
		users.putIfAbsent(followerId, new User(followerId));
		users.putIfAbsent(followeeId, new User(followeeId));
		users.get(followerId).follows.add(followeeId);
	}

	public void unfollow(int followerId, int followeeId) {
		users.putIfAbsent(followerId, new User(followerId));
		users.putIfAbsent(followeeId, new User(followeeId));
		users.get(followerId).follows.remove(new Integer(followeeId));
	}

	class User {
		int userId;
		HashSet<Integer> follows = new HashSet<Integer>();

		public User(int userId) {
			super();
			this.userId = userId;
		}

		
	}

	class Tweet {
		int tweetId;
		int time;
		public Tweet(int tweetId, int time) {
			super();
			this.tweetId = tweetId;
			this.time = time;
		}
	}
}
