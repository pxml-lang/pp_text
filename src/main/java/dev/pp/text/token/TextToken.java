package dev.pp.text.token;

import dev.pp.text.annotations.NotNull;
import dev.pp.text.annotations.Nullable;
import dev.pp.text.location.TextLocation;
import dev.pp.text.utilities.string.StringTruncator;

public class TextToken {


    private final @NotNull java.lang.String text;
    private final @Nullable TextLocation location;


    public TextToken ( @NotNull java.lang.String text, @Nullable TextLocation location ) {
        if ( text.isEmpty() ) throw new IllegalArgumentException ( "'text' cannot be empty." );

        this.text = text;
        this.location = location;
    }

    public TextToken ( char c, @Nullable TextLocation location ) { this ( java.lang.String.valueOf ( c ), location ); }

    public TextToken ( @NotNull java.lang.String text ) { this ( text, null ); }


    public @NotNull java.lang.String getText () { return text; }

    public @Nullable TextLocation getLocation () { return location; }


    /* TODO
        public @Nullable TextLocation getEndLocation () {
            // compute from text and location
        }
    */

    public @Nullable java.lang.String getResourceName() { return location == null? null : location.getResourceName(); }


    @Override public java.lang.String toString() {
        return StringTruncator.truncateWithEllipses ( text ) +
        ( location != null ? " at " + location : "" ); }
}
