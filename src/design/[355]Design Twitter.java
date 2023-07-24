package design;

import java.sql.Timestamp;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Twitter {
    private static int timestamp;
    Map<Integer,User> userMap;
    public Twitter() {
        userMap = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId,user);
        }
        User user = userMap.get(userId);
        user.postTweet(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)){
            return res;
        }
        User user = userMap.get(userId);
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>((a,b)->b.timestamp-a.timestamp);
        for (int following : user.getFollowing()) {
            if (!userMap.containsKey(following)) {
                continue;
            }
            Tweet tweet = userMap.get(following).newestTwt;
            if(tweet!=null){
                priorityQueue.add(tweet);
            }

        }
        //这里容易漏掉，要取前10个
        while(!priorityQueue.isEmpty() && res.size()<10){
            Tweet tweet = priorityQueue.poll();
            if (tweet.next!=null) {
                priorityQueue.add(tweet.next);
            }
            res.add(tweet.getId());
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User user = new User(followerId);
            userMap.put(followerId,user);
        }
        if(!userMap.containsKey(followeeId)){
            User user = new User(followeeId);
            userMap.put(followeeId,user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            return;
        }
        if(!userMap.containsKey(followeeId)){
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }

    class Tweet{
        private int id;
        private int timestamp;
        private Tweet next;
        public Tweet(int id, int timestamp){
            this.id = id;
            this.timestamp = timestamp;
            next = null;
        }

        public int getId() {
            return id;
        }
    }
    class User{
        private int id;
        private Set<Integer> following;
        private Tweet newestTwt;
        public User(int id){
            this.id = id;
            following = new HashSet<>();
            newestTwt = null;
            follow(id);
        }
        public void postTweet(int tweetId){
            Tweet tweet = new Tweet(tweetId, ++timestamp);
            tweet.next = newestTwt;
            newestTwt = tweet;
        }
        public void follow(int id){
            following.add(id);
        }
        public void unfollow(int id){
            if(id==this.id){
                return;
            }
            following.remove(id);
        }

        public Set<Integer> getFollowing() {
            return following;
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
//leetcode submit region end(Prohibit modification and deletion)
