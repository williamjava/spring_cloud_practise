package com.gui.star_compute_service.executor;

import java.util.concurrent.LinkedBlockingQueue;

public class BuyQueue<T> extends LinkedBlockingQueue {
    private int residue;

    public BuyQueue(int residue){
        this.residue = residue;
    }
}
