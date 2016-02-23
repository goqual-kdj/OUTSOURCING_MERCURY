package com.goqual.mercury.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ladmusician on 2/22/16.
 */
public class Feed extends RealmObject {
    @PrimaryKey
    private int _feedid;

    private int id;

    public int get_feedid() {
        return _feedid;
    }

    public void set_feedid(int _feedid) {
        this._feedid = _feedid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
