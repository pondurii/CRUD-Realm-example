package com.brillio.realmnosqlite;

import io.realm.RealmObject;
import io.realm.annotations.Index;

/**
 * Created by ponduri on 7/9/16.
 */
public class University extends RealmObject {
    @Index
    public int id;
    public String name;
}