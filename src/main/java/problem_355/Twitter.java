package main.java.problem_355;

import java.util.*;

public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        List<Integer> result1 = twitter.getNewsFeed(1);
        twitter.follow(1, 2);
        twitter.postTweet(2,6);
        List<Integer> result2 = twitter.getNewsFeed(1);
        twitter.unfollow(1, 2);
        List<Integer> result3 = twitter.getNewsFeed(1);
    }
    /** Initialize your data structure here. */
    int timestamp;
    Map<Integer, List<Tweet>> tweetMap;
    Map<Integer, Set<Integer>> followerMap;
    public Twitter() {
        timestamp = 0;
        tweetMap = new HashMap<>();
        followerMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> list = tweetMap.getOrDefault(userId, new ArrayList<>());
        Tweet tweet = new Tweet(timestamp, tweetId);
        list.add(tweet);
        tweetMap.put(userId, list);
        timestamp++;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if(tweetMap.containsKey(userId)) {
            List<Tweet> list = tweetMap.get(userId);
            if(followerMap.containsKey(userId)) {
                for(Integer followeeId : followerMap.get(userId)) {
                    if(tweetMap.containsKey(followeeId)) {
                        list.addAll(tweetMap.get(followeeId));
                    }
                }
            }
            PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(list);
            int limit = 0;
            while(!maxHeap.isEmpty()) {
                result.add(maxHeap.poll().tweetId);
                limit++;
            }
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followerMap.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        followerMap.put(followerId, set);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followerMap.get(followerId);
        set.remove(followeeId);
        followerMap.put(followerId, set);
    }

    class Tweet implements Comparable<Tweet> {
        int timestamp;
        int tweetId;
        public Tweet(int timestamp, int tweetId) {
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
        @Override
        public int compareTo(Tweet that) {
            return that.timestamp - this.timestamp;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
