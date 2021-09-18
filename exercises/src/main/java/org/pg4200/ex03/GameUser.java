package org.pg4200.ex03;

import java.util.Objects;

public class GameUser implements Comparable<GameUser> {

    private String userId;

    private int points;

    public GameUser(String userId, int points) {
        this.userId = Objects.requireNonNull(userId);
        this.points = points;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(GameUser o) {
        if (points > o.getPoints()) return 1;
        else if (points < o.getPoints()) return  -1;

        return userId.compareTo(o.userId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameUser)) return false;
        GameUser gameUser = (GameUser) o;
        return points == gameUser.points && Objects.equals(userId, gameUser.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, points);
    }
}
