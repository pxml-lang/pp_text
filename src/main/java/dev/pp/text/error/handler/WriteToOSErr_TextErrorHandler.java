package dev.pp.text.error.handler;

import dev.pp.text.annotations.NotNull;
import dev.pp.text.annotations.Nullable;
import dev.pp.text.error.TextError;
import dev.pp.text.error.TextWarning;
import dev.pp.text.token.TextToken;

import java.io.PrintStream;

public class WriteToOSErr_TextErrorHandler implements TextErrorHandler {

    private static final @NotNull PrintStream err = System.err;

    private TextError firstError = null;

    public void handleError ( @NotNull TextError error ) {

        if ( firstError == null ) firstError = error;

        // errorCount ++;

        println ( error.toString() );
        println();
    }

    public void handleError ( @Nullable java.lang.String id, @NotNull java.lang.String message, @Nullable TextToken token ) {

        handleError ( new TextError ( id, message, token ) );
    }

    public void handleWarning ( @NotNull TextWarning warning ) {

        println ( warning.toString() );
        println();
    }

    public void handleWarning ( @Nullable java.lang.String id, @NotNull java.lang.String message, @Nullable TextToken token ) {

        handleWarning ( new TextWarning ( id, message, token ) );
    }

/*
    private int errorCount = 0;
    private int warningCount = 0;

    private PXMLReaderError firstError = null;
    private PXMLReaderWarning firstWarning = null;

    public void start() {

        errorCount = 0;
        warningCount = 0;

        firstError = null;
        firstWarning = null;
    }
*/

//    public void stop() {

        /*
        if ( errorCount > 0 || warningCount > 0 ) {
            println();
            printCount ( errorCount, "non-canceling error" );
            printCount ( warningCount, "warning" );
        }

        if ( errorCount > 1 ) {
            println();
            println ( "First error:" );
            println ( firstError.toString() );

        } else if ( warningCount > 1 ) {
            println();
            println ( "First warning:" );
            println ( firstWarning.toString() );

        } else {
            println ( "Ok" );
        }
        */
//    }

/*
    private void printCount ( int count, String label ) {

        if ( count == 0 ) return;

        if ( count > 1 ) label = label + "s";
        println ( count + " " + label );
    }

    public void handleError ( @NotNull String id, @NotNull String message, @Nullable TextLocation location ) {

        handleError ( new PXMLReaderError ( id, message, location ) );
    }

    public void handleWarning ( @NotNull String id, @NotNull String message, @Nullable TextLocation location ) {

        handleWarning ( new PXMLReaderWarning ( id, message, location ) );
    }

    public void handleError ( @NotNull PXMLReaderError error ) {

        if ( firstError == null ) firstError = error;

        errorCount ++;

        print ( "Error: " );
        println ( error.toString() );
        println();
    }

    public void handleWarning ( @NotNull PXMLReaderWarning warning ) {

        if ( firstWarning == null ) firstWarning = warning;

        warningCount ++;

        print ( "Warning: " );
        println ( warning.toString() );
        println();
    }
*/

    public TextError firstError() { return firstError; }

    private void println ( java.lang.String string ) {
        err.println ( string );
    }

    private void println() {
        err.println();
    }
/*
    private void print ( String string ) {
        err.print ( string );
    }
*/
}
