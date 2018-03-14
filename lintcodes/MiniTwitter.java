/**
 * Implement a simple twitter. Support the following method:

postTweet(user_id, tweet_text). Post a tweet.
getTimeline(user_id). Get the given user's most recently 10 tweets posted by himself, order by timestamp from most recent to least recent.
getNewsFeed(user_id). Get the given user's most recently 10 tweets in his news feed (posted by his friends and himself). Order by timestamp from most recent to least recent.
follow(from_user_id, to_user_id). from_user_id followed to_user_id.
unfollow(from_user_id, to_user_id). from_user_id unfollowed to to_user_id.

Example
postTweet(1, "LintCode is Good!!!")
>> 1
getNewsFeed(1)
>> [1]
getTimeline(1)
>> [1]
follow(2, 1)
getNewsFeed(2)
>> [1]
unfollow(2, 1)
getNewsFeed(2)
>> []

 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */


public class MiniTwitter {
    Map<Integer, List<Tweet>> selftweets = new HashMap<Integer, List<Tweet>>();
     Map<Integer, List<Tweet>> alltweets = new HashMap<Integer, List<Tweet>>();
    
    Map<Integer, List<Integer>> fans = new HashMap<Integer, List<Integer>>();
    public MiniTwitter() {
        // do intialization if necessary
    }

    /*
     * @param user_id: An integer
     * @param tweet_text: a string
     * @return: a tweet
     */
    public Tweet postTweet(int user_id, String tweet_text) {
        // write your code here
        Tweet t =  Tweet.create(user_id, tweet_text);
        addToSelf(user_id, t);
        addToAll(user_id, t);
        postToFans(user_id, t);
        return t;
    }
    
    public void addToSelf(int user_id, Tweet t){
        List<Tweet> ls = selftweets.get(user_id);
        if (ls == null){
            ls = new ArrayList<Tweet>();
            ls.add(t);
            selftweets.put(user_id, ls);
        }else{
            ls.add(t);
        }
    }
    
     public void addToAll(int user_id, Tweet t){
        List<Tweet> ls = alltweets.get(user_id);
        if (ls == null){
            ls = new ArrayList<Tweet>();
            ls.add(t);
            alltweets.put(user_id, ls);
        }else{
            ls.add(t);
        }
    }
    
    public void postToFans(int user_id, Tweet t){
        List<Integer> users = fans.get(user_id);
        if (users == null){
            return;
        }
        for (Integer user : users){
            addToAll(user, t);
        }
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new feeds recently and sort by timeline
     */
    public List<Tweet> getNewsFeed(int user_id) {
         List<Tweet> ls = alltweets.get(user_id);
         return get(ls);
    }

    /*
     * @param user_id: An integer
     * @return: a list of 10 new posts recently and sort by timeline
     */
    public List<Tweet> getTimeline(int user_id) {
        // write your code here
        List<Tweet> ls = selftweets.get(user_id);
        return get(ls);
    }
    
    public List<Tweet> get(List<Tweet> ls){
        if (ls == null || ls.isEmpty()){
             return new ArrayList<Tweet>();
         }
         
         List<Tweet> ret = new ArrayList<Tweet>();
         int end = ls.size() - 1;
         int start = end - 9;
         if (end < 9){
             start = 0;
         }
         for (int i=end; i>=start; i--){
             ret.add(ls.get(i));
         }
         return ret;
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int from_user_id, int to_user_id) {
        // write your code here
      /*  List<Integer> users = follows.get(from_user_id);
        if (users == null){
            users = new ArrayList<Integer>();
            users.add(to_user_id);
            follows.put(from_user_id, users);
        }else{
            users.add(to_user_id);
        }*/
        
        List<Integer> users = fans.get(to_user_id);
        if (users == null){
            users = new ArrayList<Integer>();
            users.add(from_user_id);
            fans.put(to_user_id, users);
        }else{
            users.add(from_user_id);
        }
        
        List<Tweet> tweets = getTimeline(to_user_id);
        if (tweets != null){
            for (int i=0; i<tweets.size(); i++){
                insert(alltweets, from_user_id, tweets.get(i));
            }
        }
    }
    
    public void insert(Map<Integer, List<Tweet>> alltweets, int from_user_id, Tweet t){
          List<Tweet> ts =   alltweets.get(from_user_id);
          if (ts == null){
              ts = new ArrayList<Tweet>();
              ts.add(t);
              alltweets.put(from_user_id, ts);
              return;
          }
          
          int i = 0;
          for ( i=0; i<ts.size(); i++){
              Tweet tt = ts.get(i);
              if (tt.id > t.id){
                 // index = i;
                  break;
              }
          }
          ts.add(i, t);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int from_user_id, int to_user_id) {
        // write your code here
        List<Integer> users = fans.get(to_user_id);
        if (users != null && users.contains(from_user_id)){
            //users.remove(from_user_id);
            Iterator it = users.iterator();
            while(it.hasNext()){
                int id = (int)it.next();
                if (id == from_user_id){
                    it.remove();
                    break;
                }
            }
        }
        
        List<Tweet> tweets = alltweets.get(from_user_id);
        if (tweets != null){
            Iterator it = tweets.iterator();
            while(it.hasNext()){
                Tweet t = (Tweet)it.next();
                if (t.user_id == to_user_id){
                    it.remove();
                }
            }
        }
        
    }
}
