package dev.pp.text.error;

import dev.pp.text.annotations.NotNull;
import dev.pp.text.annotations.Nullable;
import dev.pp.text.location.TextLocation;
import dev.pp.text.token.TextToken;
import dev.pp.text.utilities.string.StringConstants;
import dev.pp.text.utilities.string.StringUtilities;

import java.io.File;

public abstract class TextErrorOrWarning {


    private static @NotNull java.lang.String toString (
        @Nullable java.lang.String label,
        @Nullable java.lang.String id,
        @NotNull java.lang.String message,
        @Nullable TextLocation location ) {

        StringBuilder sb = new StringBuilder();

        if ( label != null ) {
            sb.append ( label );
            sb.append ( ":" );
            sb.append ( StringConstants.OS_NEW_LINE );
        }

        sb.append ( message );

        if ( id != null ) {
            sb.append ( " [" );
            sb.append ( id );
            sb.append ( "]" );
        }

        sb.append ( StringConstants.OS_NEW_LINE );

        if ( location != null ) sb.append ( location );

        return sb.toString();
    }

    public static @NotNull java.lang.String toString (
        @Nullable java.lang.String label,
        @Nullable java.lang.String id,
        @NotNull java.lang.String message,
        @Nullable TextToken token ) {

        return toString ( label, id, message, token != null ? token.getLocation() : null );
    }

    public static @NotNull java.lang.String toLogString (
        @Nullable java.lang.String label,
        @Nullable java.lang.String id,
        @NotNull java.lang.String message,
        @Nullable TextLocation location ) {

        StringBuilder sb = new StringBuilder();

        TextLocation location_ = location != null ? location : TextLocation.UNKNOWN_LOCATION;
        sb.append ( location_.toLogString () );

        sb.append ( "," );
        if ( label != null ) {
            sb.append ( label.charAt ( 0 ) );
        } else {
            sb.append ( "E" );
        }

        sb.append ( ",id " );
        sb.append ( id );

        sb.append ( ",\"" );
        sb.append ( StringUtilities.replaceQuoteWith2Quotes ( message ) );
        sb.append ( '"' );

        return sb.toString();
    }

    public static @NotNull java.lang.String toLogString (
        @Nullable java.lang.String label,
        @Nullable java.lang.String id,
        @NotNull java.lang.String message,
        @Nullable TextToken token ) {

        return toLogString ( label, id, message, token != null ? token.getLocation() : null );
    }


    protected final @Nullable java.lang.String id;
    protected final @NotNull java.lang.String message;
    protected final @Nullable TextToken token;


    protected TextErrorOrWarning ( @Nullable java.lang.String id, @NotNull java.lang.String message, @Nullable TextToken token ) {

        this.id = id;
        this.message = message;
        this.token = token;
    }


    public @Nullable java.lang.String getId() { return id; }

    public @NotNull java.lang.String getMessage() { return message; }

    public @Nullable TextToken getToken() { return token; }


    public @Nullable java.lang.String getTokenText() { return token != null ? token.getText() : null; }

    public @Nullable TextLocation getLocation() { return token != null ? token.getLocation() : null; }

    public @Nullable File getFileOfLocation() {

        TextLocation location = getLocation();
        if ( location == null ) {
            return null;
        } else {
            return location.getResourceAsFile();
        }
    }

    public @Nullable java.lang.String getTextLine() throws Exception {

        TextLocation location = getLocation ();
        if ( location == null ) {
            return null;
        } else {
            return location.getTextLine();
        }
    }

    public @Nullable java.lang.String getTextLineWithInlineMarker () throws Exception {

        TextLocation location = getLocation ();
        if ( location == null ) {
            return null;
        } else {
            return location.getTextLineWithInlineMarker();
        }
    }

    public abstract @NotNull java.lang.String getLabel();

    public abstract @NotNull java.lang.String toLogString ();

    // public abstract @NotNull String getLabel();
}
