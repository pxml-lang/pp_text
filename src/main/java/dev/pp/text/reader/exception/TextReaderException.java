package dev.pp.text.reader.exception;

import dev.pp.text.error.TextError;
import dev.pp.text.error.TextErrorOrWarning;
import dev.pp.text.annotations.NotNull;
import dev.pp.text.annotations.Nullable;
import dev.pp.text.token.TextToken;

import java.io.IOException;

public class TextReaderException extends IOException {


    private final @Nullable java.lang.String id;
    private final @Nullable TextToken token;


    public TextReaderException (
        @Nullable java.lang.String id,
        @NotNull java.lang.String message,
        @Nullable TextToken token,
        @Nullable Exception cause ) {

        super ( message, cause );

        this.id = id;
        this.token = token;
    }


    public @Nullable java.lang.String getId() { return id; }

    public @Nullable TextToken getToken() { return token; }

/*
    public static @NotNull String toString (
        @NotNull String id,
        @NotNull String message,
        @Nullable TextLocation location ) {

        StringBuilder sb = new StringBuilder();

        sb.append ( message );

        sb.append ( " [" );
        sb.append ( id );
        sb.append ( "]" );

        sb.append ( StringConstants.OS_NEW_LINE );

        if ( location != null ) sb.append ( location );

        return sb.toString();
    }
*/

    public @NotNull TextError toTextError() { return new TextError ( id, getMessage(), token ); }

    public @NotNull java.lang.String toString() {

        return TextErrorOrWarning.toString ( "Error", id, getMessage(), token );
    }
}
