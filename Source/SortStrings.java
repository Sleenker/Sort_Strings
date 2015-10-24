import java.util.ArrayList;
import java.util.StringTokenizer;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

/**
* Engineered and developed by Jhonny Trejos Barrios.
* Technology: Java.
* Version: Java Development Kit 1.8.0_31, Standard Edition.
* Development Environment: VIM 7.3
* Date: 24/10/2015, Time: 17:17:27.
* 
* Additional Info.
*
* Source Code Target:
*
*               [SORT STRINGS INTO A-Z AND Z-A MODES FROM A TXT FILE]
*
* Licenses: GNU GPL v3.0, Eclipse Public License 1.0, personal not for commercial purposes.
* Developer Contact: jtrejosb@live.com || jtrejosb@gmail.com || jtrejosb@icloud.com
* Mobile: --
*/

public class SortStrings
{
    File F;
    FileReader FR;
    BufferedReader BR;
    String line, aux;
    StringTokenizer token;
    ArrayList < String > dictionary = new ArrayList <>();

    public static void main( String[] args )
    {
        new SortStrings().sort_AZ();
        //new SortStrings().sort_ZA();
    }

    public void loadDictionary()
    {
        try
        {
            F = new File( "/YOURPATH/Dictionary.txt" );
            FR = new FileReader( F );
            BR = new BufferedReader( FR );

            while( ( line = BR.readLine() ) != null )
            {
                token = new StringTokenizer( line, " " );

                while( token.hasMoreTokens() )
                {
                    dictionary.add( token.nextToken() );
                }
            }

            System.out.println( "ORIGINAL STRINGS PLACES FROM FILE:\n" + dictionary );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    public void sort_AZ()
    {
        loadDictionary();

        // SORTING A - Z...
        for( int i = 0; i < dictionary.size() - 1; i++ )
        {
            for( int j = i + 1; j < dictionary.size(); j++ )
            {
                if( dictionary.get( i ).compareToIgnoreCase( dictionary.get( j ) ) > 0 )
                {
                    aux = dictionary.get( i );
                    dictionary.set( i, dictionary.get( j ) );
                    dictionary.set( j, aux );
                }
            }
        }

        System.out.println( "\nSORTED A-Z ORDER:\n" + dictionary );
    }

    public void sort_ZA()
    {
        loadDictionary();

        // SORTING Z - A...
        for( int i = 0; i < dictionary.size() - 1; i++ )
        {
            for( int j = i + 1; j < dictionary.size(); j++ )
            {
                if( dictionary.get( i ).compareToIgnoreCase( dictionary.get( j ) ) < 0 )
                {
                    aux = dictionary.get( i );
                    dictionary.set( i, dictionary.get( j ) );
                    dictionary.set( j, aux );
                }
            }
        }

        System.out.println( "\nSORTED Z-A ORDER:\n" + dictionary );
    }
}
