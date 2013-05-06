package com.taig.dna;

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
				return new Guanine();
			case 'A':
			case 'a':
				return new Adenine();
			case 'T':
			case 't':
				return new Thymine();
			case 'C':
			case 'c':
				return new Cytosine();
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

	public static class Guanine extends Nucleotide
	{
		public Guanine()
		{
			super( 'G' );
		}

		@Override
		public Nucleotide getComplement()
		{
			return new Cytosine();
		}
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
			return new Thymine();
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

	public static class Cytosine extends Nucleotide
	{
		public Cytosine()
		{
			super( 'C' );
		}

		@Override
		public Nucleotide getComplement()
		{
			return new Guanine();
		}
	}
}