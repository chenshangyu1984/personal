package com.shangyu.personal.zendesk;

/**
 * Created by shangyu on 24/8/17.
 */
public class Result {
    private Player winner;

    public Result() {

    }

    public Result(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() {
        return this.winner;
    }
}
