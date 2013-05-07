package com.taig.dna;

import java.util.ArrayList;
import java.util.Collection;
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
	public Matcher match( String regex )
	{
		return Pattern.compile( regex, Pattern.CASE_INSENSITIVE ).matcher( toString() );
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
}