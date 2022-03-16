package neidra.fr.myapplication.model.Entities;

public class Score extends BaseEntity {
    int score;
    String nickname;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
