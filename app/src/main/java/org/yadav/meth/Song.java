package org.yadav.meth;

import android.net.Uri;

public class Song {

    // attributes
    String title;
    Uri uri;
    Uri artworkUri;
    int duration;

    // constructors
    public Song(String title, Uri uri, Uri artworkUri, int duration) {
        this.title = title;
        this.uri = uri;
        this.artworkUri = artworkUri;
        this.duration = duration;
    }

    // getters
    public String getTitle() {
        return title;
    }

    public Uri getUri() {
        return uri;
    }

    public Uri getArtworkUri() {
        return artworkUri;
    }

    public int getDuration() {
        return duration;
    }


}
