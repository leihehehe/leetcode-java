package linkedList;

import java.util.*;

/**
 * Leetcode 355
 */
class DesignTwitter {

    int timestamp = 0;
    /**
     User ids and their Tweets
     */
    private Map<Integer,Tweet> userTweets;
    /**
     User ids and their followings
     */
    private Map<Integer, Set<Integer>> followings;

    private static PriorityQueue<Tweet> maxHeap;
    public DesignTwitter() {
        userTweets=new HashMap<>();
        followings = new HashMap<>();
        maxHeap= new PriorityQueue<>((o1, o2) -> -o1.timestamp + o2.timestamp);
    }

    public void postTweet(int userId, int tweetId) {
        timestamp++;
        Tweet tweet = new Tweet(tweetId,timestamp);
        if(userTweets.containsKey(userId)){
            tweet.next = userTweets.get(userId);
            userTweets.put(userId,tweet);
        }else{
            userTweets.put(userId,tweet);
        }
    }
    public List<Integer> getNewsFeed(int userId){

        maxHeap.clear();

        if (userTweets.containsKey(userId)) {
            maxHeap.offer(userTweets.get(userId));
        }

        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = userTweets.get(followingId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }

        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet head = maxHeap.poll();
            res.add(head.id);

            if (head.next != null) {
                maxHeap.offer(head.next);
            }
            count++;
        }
        return res;

    }


    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(followings.containsKey(followerId)){
            Set<Integer> followees = followings.get(followerId);
            if(!followees.contains(followeeId)) followees.add(followeeId);
        }else{
            Set<Integer> followees = new HashSet<>();
            followees.add(followeeId);
            followings.put(followerId,followees);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId) return;
        if(followings.containsKey(followerId)){
            Set<Integer> followees = followings.get(followerId);
            if(followees.contains(followeeId)) {
                followees.remove(followeeId);
                followings.put(followerId,followees);
            }

        }
    }
    /*
     * A linked list
     */
    private class Tweet {
        private int id;
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
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
