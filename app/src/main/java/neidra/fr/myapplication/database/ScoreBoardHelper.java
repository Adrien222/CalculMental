package neidra.fr.myapplication.database;

import android.content.Context;

public class ScoreBoardHelper extends DataBaseHelper {

    public ScoreBoardHelper(Context context) {
        super(context, "Score", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS scores ("+
                "id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScoreBoardDao.score + " INTEGER NOT NULL," +
                ScoreBoardDao.nickname + " VARCHAR(255) NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
