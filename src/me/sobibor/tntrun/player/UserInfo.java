package me.sobibor.tntrun.player;

public class UserInfo {
    private int wins;
    private int money;

    public UserInfo(int wins, int money) {
        this.wins = wins;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getWins() {
        return wins;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setWins(int wins) {
      this.wins = wins;
    }
}
