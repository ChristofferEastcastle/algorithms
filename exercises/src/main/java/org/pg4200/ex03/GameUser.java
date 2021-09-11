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
        return -1;
    }
}
