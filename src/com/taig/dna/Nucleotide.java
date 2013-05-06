package com.taig.dna;

import static com.taig.dna.Nucleotide.Purine.Adenine;
import static com.taig.dna.Nucleotide.Purine.Guanine;
import static com.taig.dna.Nucleotide.Pyrimidine.Cytosine;
import static com.taig.dna.Nucleotide.Pyrimidine.Thymine;

/**
 * Representation of <a href="https://en.wikipedia.org/wiki/Nucleotide">nucleotides</a> (the basic module of DNA
 * sequences).
 * <p/>
 * Currently limited to {@link Guanine}, {@link Adenine}, {@link Thymine} and {@link Cytosine}.
 */
public abstract class Nucleotide
{
	protected final char abbreviation;

	protected Nucleotide( char abbreviation )
	{
		this.abbreviation = abbreviation;
	}

	/**
	 * Create a nucleotide with its abbreviation (e.g. 'G' to instantiate {@link Guanine}).
	 *
	 * @param abbreviation The nucleotide's abbreviation.
	 * @return The nucleotide object that matches the given abbreviation.
	 * @throws IllegalArgumentException If the given abbreviation is not a valid nucleotide.
	 */
	public static Nucleotide newInstance( char abbreviation )
	{
		switch( abbreviation )
		{
			case 'G':
			case 'g':
				return new Purine.Guanine();
			case 'A':
			case 'a':
				return new Purine.Adenine();
			case 'T':
			case 't':
				return new Pyrimidine.Thymine();
			case 'C':
			case 'c':
				return new Pyrimidine.Cytosine();
			default:
				throw new IllegalArgumentException( "Cannot create nucleotide from '" + abbreviation + "'." );
		}
	}

	/**
	 * Get the nucleotide's abbreviation (e.g. 'A' for Adenine).
	 *
	 * @return The nucleotide's abbreviation.
	 */
	public char getAbbreviation()
	{
		return abbreviation;
	}

	/**
	 * Get the nucleotide's complementary nucleotide.
	 *
	 * @return The complementary nucleotide.
	 */
	public abstract Nucleotide getComplement();

	@Override
	public String toString()
	{
		return String.valueOf( abbreviation );
	}

	public static abstract class Purine extends Nucleotide
	{
		protected Purine( char abbreviation )
		{
			super( abbreviation );
		}

		public static class Adenine extends Nucleotide
		{
			public Adenine()
			{
				super( 'A' );
			}

			@Override
			public Nucleotide getComplement()
			{
				return new Pyrimidine.Thymine();
			}
		}

		public static class Guanine extends Nucleotide
		{
			public Guanine()
			{
				super( 'G' );
			}

			@Override
			public Nucleotide getComplement()
			{
				return new Pyrimidine.Cytosine();
			}
		}
	}

	public static abstract class Pyrimidine extends Nucleotide
	{
		protected Pyrimidine( char abbreviation )
		{
			super( abbreviation );
		}

		public static class Cytosine extends Nucleotide
		{
			public Cytosine()
			{
				super( 'C' );
			}

			@Override
			public Nucleotide getComplement()
			{
				return new Purine.Guanine();
			}
		}

		public static class Thymine extends Nucleotide
		{
			public Thymine()
			{
				super( 'T' );
			}

			@Override
			public Nucleotide getComplement()
			{
				return new Adenine();
			}
		}
	}
}