package priorityQueue;

import java.util.*;

/**
 * Leetcode 355
 */
class DesignTwitter {
/*
     * know your followees -> you need know their posts
        - you need a hashMap -> Map<id, >
     */

    int timestamp = 0;
    /**
     User ids and their Tweets
     */
    private Map<Integer,Tweet> userTweets;
    /**
     User ids and their followings
     */
    private Map<Integer, Set<Integer>> followings;

    private static PriorityQueue<Tweet> queue;
    public DesignTwitter() {
        userTweets=new HashMap<>();
        followings = new HashMap<>();
        queue= new PriorityQueue<>((o1, o2) -> o2.timestamp-o1.timestamp);
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
        queue.clear();
        //put yourself's tweets in the queue.
        if (userTweets.containsKey(userId)) {
            queue.offer(userTweets.get(userId));
        }

        Set<Integer> followingList = followings.get(userId);
        if (followingList != null && followingList.size() > 0) {
            for (Integer followingId : followingList) {
                Tweet tweet = userTweets.get(followingId);
                if (tweet != null) {
                    queue.offer(tweet);
                }
            }
        }

        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while (!queue.isEmpty() && count < 10) {
            Tweet head = queue.poll();
            res.add(head.id);

            if (head.next != null) {
                queue.offer(head.next);
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

    public Tweet mergeKTweets(Tweet[] tweets,int l, int r){
        if(l==r) return tweets[l];
        if(l>r) return null;
        int mid = l-(r+l)/2;
        return mergeTwoTweets(mergeKTweets(tweets,l,mid),mergeKTweets(tweets,mid+1,r));
    }
    public Tweet mergeTwoTweets(Tweet tweet1, Tweet tweet2){
        Tweet t1 = tweet1;
        Tweet t2 = tweet2;
        Tweet dummyTweet = new Tweet(-1,-1);
        Tweet res = dummyTweet;
        while(t1!=null && t2!=null){
            if(t1.timestamp>t2.timestamp){
                res.next = t1;
                t1=t1.next;
            }else{
                res.next = t2;
                t2=t2.next;
            }
            res = res.next;
        }
        res.next = t1==null? t2:t1;
        return dummyTweet.next;
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
