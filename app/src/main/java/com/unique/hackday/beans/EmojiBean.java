package com.unique.hackday.beans;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2015/3/22.
 */
public class EmojiBean {
    private int x;
    private int y;
    private int length;
    private int height;
    private Bitmap bitmap;

    public EmojiBean(){

    }

    public EmojiBean(int x, int y, int length, int height, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.height = height;
        this.bitmap = bitmap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
