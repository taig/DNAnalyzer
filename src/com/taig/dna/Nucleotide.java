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
	protected final char group;

	protected final char molecule;

	protected Nucleotide( char group, char molecule )
	{
		this.group = group;
		this.molecule = molecule;
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
		switch( Character.toUpperCase( abbreviation ) )
		{
			case Adenine.ABBREVIATION:
				return new Adenine();
			case Cytosine.ABBREVIATION:
				return new Cytosine();
			case Guanine.ABBREVIATION:
				return new Guanine();
			case Thymine.ABBREVIATION:
				return new Thymine();
			default:
				throw new IllegalArgumentException( "Cannot create nucleotide from '" + abbreviation + "'." );
		}
	}

	/**
	 * Get the nucleotide's subgroup's abbreviation (e.g. 'R' for Purine).
	 *
	 * @return The nucleotide's subgroup's abbreviation.
	 */
	public char getGroup()
	{
		return group;
	}

	/**
	 * Get the nucleotide's abbreviation (e.g. 'A' for Adenine).
	 *
	 * @return The nucleotide's abbreviation.
	 */
	public char getMolecule()
	{
		return molecule;
	}

	/**
	 * Get the nucleotide's complementary nucleotide.
	 *
	 * @return The complementary nucleotide.
	 */
	public abstract Nucleotide getComplement();

	/**
	 * @param object The object that should be checked for equality with this nucleotide.
	 * @return <code>true</code> if the given object and this nucleotide have the same abbreviation letter, otherwise
	 *         <code>false</code>.
	 */
	@Override
	public boolean equals( Object object )
	{
		if( object instanceof Nucleotide )
		{
			return molecule == ( (Nucleotide) object ).getMolecule();
		}

		return false;
	}

	/**
	 * Represents the nucleotide with it's abbreviation letter (uppercase).
	 *
	 * @return The nucleotide's abbreviation letter (uppercase).
	 */
	@Override
	public String toString()
	{
		return String.valueOf( molecule );
	}

	public static abstract class Purine extends Nucleotide
	{
		public static final char ABBREVIATION = 'R';

		protected Purine( char molecule )
		{
			super( ABBREVIATION, molecule );
		}

		public static class Adenine extends Purine
		{
			public static final char ABBREVIATION = 'A';

			public Adenine()
			{
				super( ABBREVIATION );
			}

			@Override
			public Nucleotide getComplement()
			{
				return new Thymine();
			}
		}

		public static class Guanine extends Purine
		{
			public static final char ABBREVIATION = 'G';

			public Guanine()
			{
				super( ABBREVIATION );
			}

			@Override
			public Nucleotide getComplement()
			{
				return new Cytosine();
			}
		}
	}

	public static abstract class Pyrimidine extends Nucleotide
	{
		public static final char ABBREVIATION = 'Y';

		protected Pyrimidine( char molecule )
		{
			super( ABBREVIATION, molecule );
		}

		public static class Cytosine extends Pyrimidine
		{
			public static final char ABBREVIATION = 'C';

			public Cytosine()
			{
				super( ABBREVIATION );
			}

			@Override
			public Nucleotide getComplement()
			{
				return new Guanine();
			}
		}

		public static class Thymine extends Pyrimidine
		{
			public static final char ABBREVIATION = 'T';

			public Thymine()
			{
				super( ABBREVIATION );
			}

			@Override
			public Nucleotide getComplement()
			{
				return new Adenine();
			}
		}
	}
}