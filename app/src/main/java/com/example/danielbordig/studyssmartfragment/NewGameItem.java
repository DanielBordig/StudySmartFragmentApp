/*
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Copyright © 2015.
 * "THE BEER-WARE LICENSE" (Revision 42):
 * <s133235@student.dtu> wrote this file. As long as you retain this notice you
 * can do whatever you want with this stuff. If we meet some day, and you think
 * this stuff is worth it, you can buy me a beer in return - Rudy Alex Kohn
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.example.danielbordig.studyssmartfragment;

import android.support.annotation.DrawableRes;

/**
 * Created on 27-12-2015, 10:01.
 * Project : R-TicTacToe
 *
 * @author rudz
 */
public class NewGameItem {

//    public final int itemId;
//    public final CharSequence itemName;
//    public final CharSequence description;
    public @DrawableRes
    final int resourceIcon;

    // constructor final int itemId, final CharSequence itemName, final CharSequence description,
    public NewGameItem(final @DrawableRes int resourceIcon) {
//        this.itemId = itemId;
//        this.itemName = itemName;
//        this.description = description;
        this.resourceIcon = resourceIcon;
    }
}
