package com.taig.dna;

import java.util.ArrayList;
import java.util.Collection;

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
	 * @throws IllegalArgumentException If one of the characters in the given sequence can not be converted to a {@link
	 *                                  Nucleotide} object.
	 */
	public Sequence( String sequence )
	{
		for( char abbreviation : sequence.toCharArray() )
		{
			Nucleotide.newInstance( abbreviation );
		}
	}
}