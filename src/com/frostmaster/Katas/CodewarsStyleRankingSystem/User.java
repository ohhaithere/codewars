package com.frostmaster.Katas.CodewarsStyleRankingSystem;

import java.security.InvalidParameterException;

/**
 * Created by frostymaster on 26.11.2016.
 */
public class User {

    int rank;
    int progress;

    User(){
        rank = -8;
        progress = 0;
    }

    public void incProgress(int problemRank) throws Exception {
        if (rank < -8 || rank == 0 || rank > 8) {
            throw new Exception();
        }
       if(this.rank == problemRank)
            this.progress+=3;
        if((this.rank - problemRank)  == 1 )
            this.progress+=1;
        if(this.rank - problemRank > 1) {
            int diff = this.rank - problemRank;
            this.rank = this.rank + (10 * diff * diff);
        }
        if(rank == 100){
            this.progress -= 100;
            if(rank <= 8)
                rank++;
        }
    }

}
