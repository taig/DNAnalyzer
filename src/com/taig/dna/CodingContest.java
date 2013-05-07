package com.taig.dna;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import static com.taig.dna.Nucleotide.Purine.Adenine;
import static com.taig.dna.Nucleotide.Purine.Guanine;
import static com.taig.dna.Nucleotide.Pyrimidine.Cytosine;
import static com.taig.dna.Nucleotide.Pyrimidine.Thymine;

/**
 * A specially tailored class that aims to answer the contest's questions. Run the {@link #main(String...)} method to
 * execute this application.
 */
public class CodingContest
{
	protected Sequence sequence;

	public CodingContest( Sequence sequence )
	{
		this.sequence = sequence;
	}

	public Sequence getSequence()
	{
		return sequence;
	}

	public void setSequence( Sequence sequence )
	{
		this.sequence = sequence;
	}

	/**
	 * Check if the DNA sequence has at least three distinct occurrences of the sequence <code>GGG</code>. If so, the
	 * person carrying the supplied DNA has increased risk to acquire Tiberius syndrome.
	 *
	 * @return {@link Solution} to exercise 1.1.
	 */
	public Solution hasRiskOfTiberiusSyndrome()
	{
		return new Solution( 1, 1, "Is the person at risk to acquire Tiberius syndrome?" )
		{
			@Override
			public String getResult()
			{
				int occurrences = sequence.count( "GGG" );
				return ( occurrences >= 3 ? "Yes" : "No" ) +
					   " (" + occurrences + " occurrences, 3 occurrences indicate high risk)";
			}
		};
	}

	/**
	 * Check if the DNA sequence has a <code>CAG</code> segment followed by exactly one <code>C</code> or one
	 * <code>G</code> and is then not followed by by <code>T</code> the next two slots. If so, the person carrying the
	 * supplied DNA has brown eyes.
	 *
	 * @return {@link Solution} to exercise 1.2.
	 */
	public Solution hasBrownEyes()
	{
		return new Solution( 1, 2, "Does this person have brown eyes?" )
		{
			@Override
			public String getResult()
			{
				// TODO find out if "not followed by two Ts" is correct; assignment is not clear.
				return sequence.contains( "CAG[C|G][^T][^T]" ) ? "Yes" : "No";
			}
		};
	}

	/**
	 * Count the occurrences of all nucleotide types in this DNA sequence.
	 *
	 * @return {@link Solution} to exercise 1.3.
	 */
	public Solution countNucleotides()
	{
		return new Solution( 1, 3, "How many of each nucleotides does this segment have?" )
		{
			@Override
			public String getResult()
			{
				StringBuilder builder = new StringBuilder();

				Nucleotide[] nucleotides = {
						Nucleotide.newInstance( Adenine.ABBREVIATION ),
						Nucleotide.newInstance( Cytosine.ABBREVIATION ),
						Nucleotide.newInstance( Guanine.ABBREVIATION ),
						Nucleotide.newInstance( Thymine.ABBREVIATION )
				};

				for( Nucleotide nucleotide : nucleotides )
				{
					builder
							.append( nucleotide.getClass().getSimpleName() )
							.append( ":\t" )
							.append( sequence.count( String.valueOf( nucleotide.getMolecule() ) ) )
							.append( "\n" );
				}

				return builder.deleteCharAt( builder.length() - 1 ).toString();
			}
		};
	}

	/**
	 * @return {@link Solution} to exercise 1.4.
	 */
	public Solution findFirstCtagOccurrence()
	{
		return new Solution( 1, 4, "What's the location of the first occurrence of the sequence CTAG in the given segment?" )
		{
			@Override
			public String getResult()
			{
				return String.valueOf( sequence.toString().indexOf( "CTAG" ) + 1 );
			}
		};
	}

	/**
	 * Check whether the DNA sequence consists of more purine nucleotides than pyrimidine nucleotides or not.
	 *
	 * @return {@link Solution} to exercise 2.1.
	 */
	public Solution hasMorePurinesThanPyrimidines()
	{
		return new Solution( 2, 1, "Does this segment have more purines than pyrimidines?" )
		{
			@Override
			public String getResult()
			{
				int purines = sequence.count( Adenine.ABBREVIATION + "|" + Guanine.ABBREVIATION );
				int pyrimidines = sequence.count( Cytosine.ABBREVIATION + "|" + Thymine.ABBREVIATION );

				return ( purines > pyrimidines ? "Yes" : "No" )
					   + " (" + purines + " purines, " + pyrimidines + " pyrimidines)";
			}
		};
	}

	/**
	 * Check if the DNA sequence contains a segment that consists of four purines followed by four pyrimidines. If so, the
	 * person carrying the supplied DNA has a strong correlation with the early onset of Frømingen's dischrypsia.
	 *
	 * @return {@link Solution} to exercise 2.2.
	 */
	public Solution hasFromingenDischrypsiaEvidence()
	{
		return new Solution( 2, 2, "Does this DNA strand show evidence for the Fromingen's dischrypsia?" )
		{
			@Override
			public String getResult()
			{
				Matcher matcher = sequence.match(
						"([" + Adenine.ABBREVIATION + "|" + Guanine.ABBREVIATION + "]{4}" +
						"[" + Cytosine.ABBREVIATION + "|" + Thymine.ABBREVIATION + "]{4})" );

				List<String> matches = new ArrayList<String>();

				while( matcher.find() )
				{
					matches.add( new Sequence( matcher.group( 1 ) ).toFormattedString() );
				}

				if( matches.size() > 0 )
				{
					StringBuilder builder = new StringBuilder( "Yes (affected segment(s): " );

					for( String match : matches )
					{
						builder.append( match ).append( ", " );
					}

					return builder.delete( builder.length() - 2, builder.length() ).append( ")" ).toString();
				}
				else
				{
					return "No";
				}
			}
		};
	}

	/**
	 * Get the DNA sequence's complement.
	 *
	 * @return {@link Solution} to exercise 2.3.
	 */
	public Solution getComplementSequence()
	{
		return new Solution( 2, 3, "What's the complementary sequence for the entire nucleotide segment?" )
		{
			@Override
			public String getResult()
			{
				return sequence.getComplement().toFormattedString();
			}
		};
	}

	public Solution[] getSolutions()
	{
		return new Solution[] {
				hasRiskOfTiberiusSyndrome(),
				hasBrownEyes(),
				countNucleotides(),
				findFirstCtagOccurrence(),
				hasMorePurinesThanPyrimidines(),
				hasFromingenDischrypsiaEvidence(),
				getComplementSequence()
		};
	}

	/**
	 * Execute the command line application that prints the solutions to all given tasks.
	 *
	 * @param arguments Either no arguments at all (use pipe input or default fallback instead) or a DNA sequence on index
	 *                  <code>0</code>.
	 */
	public static void main( String... arguments )
	{
		try
		{
			String dna;

			// Retrieve the DNA dna from ...
			if( arguments.length == 1 )
			{
				// ... the command line arguments.
				dna = arguments[0];
			}
			else
			{
				InputStream input = null;

				try
				{
					if( arguments.length == 0 )
					{
						// ... piped input.
						input = System.in;
					}
					else if( arguments.length == 2 && arguments[0].equals( "-i" ) )
					{
						// ... file input.
						input = new FileInputStream( arguments[1] );
					}
					else
					{
						throw new IllegalArgumentException( "Invalid amount of parameters given" );
					}

					StringBuilder builder = new StringBuilder();

					for( int character = input.read(); character != -1; character = input.read() )
					{
						builder.append( (char) character );
					}

					dna = builder.toString();
				}
				finally
				{
					if( input != null )
					{
						input.close();
					}
				}
			}

			///////////////////////////////////////////////////////////////////////
			//                        Exercise solutions.                        //
			///////////////////////////////////////////////////////////////////////

			CodingContest contest = new CodingContest( new Sequence( dna.replaceAll( "\\s", "" ) ) );

			for( Solution solution : contest.getSolutions() )
			{
				System.out.println( solution );
			}
		}
		catch( Exception exception )
		{
			System.out.println( "Error: " + exception.getMessage() + "." );
			System.exit( -1 );
		}
	}

	protected abstract static class Solution
	{
		public int group;

		public int number;

		public String task;

		public Solution( int group, int number, String task )
		{
			this.group = group;
			this.number = number;
			this.task = task;
		}

		public abstract String getResult();

		@Override
		public String toString()
		{
			StringBuilder builder = new StringBuilder()
					.append( "[" ).append( group ).append( "." ).append( number ).append( "] " ).append( task );

			for( String line : getResult().split( "\n" ) )
			{
				builder.append( "\n> " ).append( line );
			}

			return builder.toString();
		}
	}
}