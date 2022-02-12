package com.company.kyu4;

//Reference: https://www.codewars.com/kata/51fda2d95d6efda45e00004e

public class RankingSystem {
    public int rank = -8;
    public int progress = 0;

    public static void user(){}

    public void incProgress(int activityRank){
        if(activityRank < -8 || activityRank == 0 || activityRank > 8)
            throw new IllegalArgumentException();
        int d;
        if(this.rank < 0 && activityRank > 0)
            activityRank--;
        else if(this.rank > 0 && activityRank < 0)
            activityRank++;

        if (activityRank == this.rank)
            this.progress += 3;
        else if(activityRank == this.rank - 1)
            this.progress += 1;
        else if(activityRank > this.rank){
            d = activityRank - this.rank;
            progress += 10 * d * d;
        }
        updateRank();
        checkMaxProgress();
    }
    private void checkMaxProgress(){
        if(this.rank == 8)
            this.progress = 0;
    }
    private void updateRank(){
        while(this.progress >= 100 && rank < 8){
            if(++this.rank == 0)
                this.rank++;
            this.progress -= 100;
        }

    }
}
