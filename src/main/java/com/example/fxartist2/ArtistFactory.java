package com.example.fxartist2;

import com.example.fxartist2.artists.Artist;
import com.example.fxartist2.artists.RedArtist;

public class ArtistFactory {

    public IArtist generateArtist(String artistName) {
        return switch (artistName.charAt(0)) {
            case 'a' -> new Artist();
            case 'b' -> new RedArtist();
            case 'y' -> new Artist();
            default -> new Artist();
        };
    }

}
