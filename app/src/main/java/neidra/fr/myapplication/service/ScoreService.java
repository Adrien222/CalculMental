package neidra.fr.myapplication.service;

import neidra.fr.myapplication.database.ScoreBoardDao;
import neidra.fr.myapplication.model.Entities.Score;

public class ScoreService {

    private ScoreBoardDao scoreBoardDao;

    public ScoreService(ScoreBoardDao scoreBoardDao) {
        this.scoreBoardDao = scoreBoardDao;
    }

    public Long getCalculCount(){
        return scoreBoardDao.count();
    }

    public void storeInDb(Score score){
        scoreBoardDao.create(score);
    }
}
