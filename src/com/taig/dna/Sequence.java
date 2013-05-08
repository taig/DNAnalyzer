package com.taig.dna;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A list of {@link Nucleotide Nucleotides} that allows to perform domain specific operations in order to analyze the
 * DNA sequence.
 */
public class Sequence extends ArrayList<Nucleotide>
{
	public Sequence()
	{
		super();
	}

	public Sequence( int i )
	{
		super( i );
	}

	public Sequence( Collection<? extends Nucleotide> nucleotides )
	{
		super( nucleotides );
	}

	/**
	 * Create a Sequence with a String resource (e.g. "ggaa").
	 *
	 * @param sequence The DNA sequence represented as String.
	 * @throws NullPointerException     If the given String sequence is <code>null</code>.
	 * @throws IllegalArgumentException If one of the characters in the given sequence can not be converted to a {@link
	 *                                  Nucleotide} object.
	 */
	public Sequence( String sequence )
	{
		for( char abbreviation : sequence.toCharArray() )
		{
			add( Nucleotide.newInstance( abbreviation ) );
		}
	}

	/**
	 * Get the complement of the current Sequence.
	 *
	 * @return The complement of the current Sequence.
	 */
	public Sequence getComplement()
	{
		Sequence complement = new Sequence();

		for( Nucleotide nucleotide : this )
		{
			complement.add( nucleotide.getComplement() );
		}

		return complement;
	}

	/**
	 * Create a {@link Matcher} that operates on the DNA sequence.
	 *
	 * @param regex The regular expression that is used in order to create the {@link Matcher}.
	 * @return The created {@link Matcher} based on the given regular expression and the DNA sequence's current state.
	 * @throws NullPointerException If the given regular expression is <code>null</code>.
	 */
	public Matcher getMatcher( String regex )
	{
		return Pattern.compile( regex, Pattern.CASE_INSENSITIVE ).matcher( toString() );
	}

	/**
	 * Get an array of all Sequences that match the given regular expression.
	 *
	 * @param regex The regular expression to search for within the DNA sequence.
	 * @return An array of Sequences containing the DNA sequence's segments that match the given regular expression.
	 * @throws NullPointerException If the given regular expression is <code>null</code>.
	 */
	public Sequence[] getMatches( String regex )
	{
		Matcher matcher = getMatcher( regex );
		List<Sequence> matches = new ArrayList<Sequence>();

		while( matcher.find() )
		{
			matches.add( new Sequence( matcher.group( 0 ) ) );
		}

		return matches.toArray( new Sequence[matches.size()] );
	}

	/**
	 * Check if the given regular expression occurs in the DNA sequence or not.
	 *
	 * @param regex The regular expression to search for within the DNA sequence.
	 * @return <code>true</code> if the given regular expression exists within the DNA sequence at least one, otherwise
	 *         <code>false</code>.
	 * @throws NullPointerException If the given regular expression is <code>null</code>.
	 */
	public boolean contains( String regex )
	{
		return getMatcher( regex ).find();
	}

	/**
	 * Count the occurrences of the given regular expression within the DNA sequence.
	 *
	 * @param regex The regular expression whose occurrences in the DNA sequence will be counted.
	 * @return The occurrences of the given regular expression in the DNA sequence's current state.
	 * @throws NullPointerException If the given regular expression is <code>null</code>.
	 */
	public int count( String regex )
	{
		int occurrences = 0;
		Matcher matcher = getMatcher( regex );

		while( matcher.find() )
		{
			occurrences++;
		}

		return occurrences;
	}

	/**
	 * Convert the Sequence to a human readable String representation.
	 *
	 * @return The Sequence's current state represented as a human readable String resource.
	 */
	public String toFormattedString()
	{
		return toString().replaceAll( "(.{4})", "$1 " ).replaceAll( "(.{89}).", "$1\n" ).trim();
	}

	/**
	 * Convert the Sequence to a String representation without spaces consisting of the {@link Nucleotide Nucleotides}
	 * abbreviations (uppercase).
	 *
	 * @return The Sequence's current state represented as String resource.
	 */
	@Override
	public String toString()
	{
		StringBuilder sequence = new StringBuilder();

		for( Nucleotide nucleotide : this )
		{
			sequence.append( nucleotide );
		}

		return sequence.toString();
	}

	/**
	 * An alternative String representation to {@link java.util.Arrays#toString(Object[])} making use of {@link
	 * #toFormattedString()}.
	 *
	 * @param sequences The Sequences that will be glued to a String.
	 * @return The String representation of the given Sequences.
	 */
	public static String toString( Sequence[] sequences )
	{
		StringBuilder builder = new StringBuilder( "[" );

		for( Sequence sequence : sequences )
		{
			builder.append( sequence.toFormattedString() ).append( ", " );
		}

		return builder.delete( Math.max( 0, builder.length() - 2 ), builder.length() ).append( "]" ).toString();
	}
}