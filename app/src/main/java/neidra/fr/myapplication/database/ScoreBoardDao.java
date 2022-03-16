package neidra.fr.myapplication.database;

import android.content.ContentValues;
import android.database.Cursor;

import neidra.fr.myapplication.model.Entities.Score;

public class ScoreBoardDao  extends BaseDao<Score>{

    public ScoreBoardDao(DataBaseHelper helper) {
        super(helper);
    }

    static String score = "premierElement";
    static String nickname = "deuxiemeElement";

    @Override
    protected String getTableName() {
        return "scores";
    }

    @Override
    protected void putValues(ContentValues values, Score entity) {
        values.put(score,entity.getScore());
        values.put(nickname,entity.getNickname());
    }

    @Override
    protected Score getEntity(Cursor cursor) {
        Score score = new Score();
        cursor.moveToFirst();
        int indexScore = cursor.getColumnIndex(ScoreBoardDao.score);
        int indexNickname = cursor.getColumnIndex(nickname);
        score.setScore(cursor.getInt(indexScore));
        score.setNickname(cursor.getString(indexNickname));
        return score;
    }
}
