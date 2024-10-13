# 2024 KAKAO WINTER INTERNSHIP - 가장 많이 받은 선물

``` java
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] exchange = new int[friends.length][friends.length]; // 주고받은 선물 수
        int[][] giftIndex = new int[friends.length][3];  // 선물지수
        int[] nextMonthGift = new int[friends.length];    // 다음 달에 받을 선물 수
        
        // 주고받은 선물 수 구하기 (exchange)
        for(int i = 0; i < gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String giverName = st.nextToken();
            String takerName = st.nextToken();
            int giverIndex = -1, takerIndex = -1;
            
            for(int j = 0; j < friends.length; j++) {
                if(giverIndex != -1 && takerIndex != -1) break;
                
                if(friends[j].equals(giverName)) {
                    giverIndex = j;
                }
                
                if(friends[j].equals(takerName)) {
                    takerIndex = j;
                }
            }
            
            exchange[giverIndex][takerIndex]++;
            
        }
        
        // 선물지수 구하기 (giftIndex)
        for(int i = 0; i < friends.length; i++) {
            int giveCount = 0, takeCount = 0;
            for(int j = 0; j < friends.length; j++) {
                giveCount += exchange[j][i];
                takeCount += exchange[i][j];
            }
            
            giftIndex[i][0] = giveCount;
            giftIndex[i][1] = takeCount;
            giftIndex[i][2] = takeCount - giveCount;
        }
        
        // 다음 달에 받을 선물 수
        for(int i = 0; i < friends.length; i++) {
            for(int j = 0; j < friends.length; j++) {
                if( i == j ) continue; // 동일한 사람인 경우
                
                int giveCount = exchange[i][j];
                int takeCount = exchange[j][i];
                
                // 두 사람이 주고받은 기록이 있고, 두 사람 사이에 더 많은 선물을 주었으면
                if( (giveCount != 0 || takeCount != 0) && (giveCount > takeCount) ) {
                    nextMonthGift[i]++;
                } else if ( ( (giveCount == 0 && takeCount == 0) || (giveCount == takeCount) ) && (giftIndex[i][2] > giftIndex[j][2]) ) {
                    nextMonthGift[i]++;
                }
            }
            
        }
        
        // 다음 달에 가장 많은 선물받는 친구가 받을 선물 수
        int answer = 0;
        
        for(int i = 0; i < nextMonthGift.length; i++) {
            answer = Math.max(answer, nextMonthGift[i]);
        }
        
        return answer;
    }
}
```