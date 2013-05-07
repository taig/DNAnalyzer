package com.taig.dna;

import java.util.HashMap;
import java.util.Map;

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
	 * Check if the sequence has at least three distinct occurrences of the sequence <code>GGG</code>. If so, the person
	 * carrying the supplied DNA has increased risk to acquire Tiberius syndrome.
	 *
	 * @return <code>true</code> if the current DNA implies a high risk to acquire Tiberius syndrome, otherwise
	 *         <code>false</code>
	 */
	public boolean hasRiskOfTiberiusSyndrome()
	{
		return sequence.count( "GGG" ) >= 3;
	}

	/**
	 * Count the occurrences of all nucleotide types in this DNA sequence.
	 *
	 * @return The amount of occurrences of all nucleotide types in this DNA sequence.
	 */
	public Map<Class<? extends Nucleotide>, Integer> countNucleotides()
	{
		Map<Class<? extends Nucleotide>, Integer> count = new HashMap<Class<? extends Nucleotide>, Integer>();

		count.put( Nucleotide.Purine.Adenine.class, sequence.count( "A" ) );
		count.put( Nucleotide.Pyrimidine.Cytosine.class, sequence.count( "C" ) );
		count.put( Nucleotide.Purine.Guanine.class, sequence.count( "G" ) );
		count.put( Nucleotide.Pyrimidine.Thymine.class, sequence.count( "T" ) );

		return count;
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

			// Retrieve the DNA dna from the ...
			if( arguments.length == 1 )
			{
				// ... command line arguments.
				dna = arguments[0];
			}
			else if( arguments.length == 0 )
			{
				if( System.in.available() > 0 )
				{
					// ... piped input.
					StringBuilder input = new StringBuilder();

					for( int character = System.in.read(); character != -1; character = System.in.read() )
					{
						input.append( (char) character );
					}

					dna = input.toString();
				}
				else
				{
					// ... default fallback dna.
					dna = CONTEST_SEQUENCE;
				}
			}
			else
			{
				throw new IllegalArgumentException( "Invalid amount of parameters given" );
			}

			// Remove whitespace from the dna.
			dna = dna.replaceAll( "\\s", "" );

			// Create Sequence.
			CodingContest contest = new CodingContest( new Sequence( dna ) );

			// Exercise 1.1.
			printExercise(
					"1.1",
					"Is the person at risk to acquire Tiberius syndrome?",
					contest.hasRiskOfTiberiusSyndrome() );

			// Exercise 1.2.
			// unclear

			// Exercise 1.3.
			StringBuilder builder = new StringBuilder();

			for( Map.Entry<Class<? extends Nucleotide>, Integer> entry : contest.countNucleotides().entrySet() )
			{
				builder
						.append( entry.getKey().getSimpleName() )
						.append( ":\t" )
						.append( entry.getValue() )
						.append( "\n" );
			}

			if( builder.length() > 0 )
			{
				builder.deleteCharAt( builder.length() - 1 );
			}

			printExercise(
					"1.3",
					"How many of each nucleotides does this segment have?",
					builder );
		}
		catch( Exception exception )
		{
			System.out.println( "Error: " + exception.getMessage() + "." );
			System.exit( -1 );
		}
	}

	public static void printExercise( String id, String task, Object result )
	{
		System.out.println( "[" + id + "] " + task );

		for( String line : result.toString().split( "\n" ) )
		{
			System.out.println( "> " + line );
		}
	}

	public static void printExercise( String id, String task, boolean result )
	{
		printExercise( id, task, result ? "Yes" : "No" );
	}

	public static final String CONTEST_SEQUENCE = "ggaatttagggagttcccacattgcccagacgactcgtatagaattggtagttggccatg" +
												  "cgtccatatcacaaagacacagtccctggccgaccacactgtaaccacgaatatgcccta" +
												  "tcgtacgggttgggatgcacttttgagttatacgcgctcgaatctatgcccagtacacat" +
												  "ggtgccgacacctaactaggcagtgaggggcactcagacctgacatgagcggaagaaaga" +
												  "acccgcgggggccccacgacgtagcggcgacggctcaaccaatgccccgcccctttcata" +
												  "aggccaagcggactgggctttcgcccgagtctaaacccactgtatttaccattcatagtc" +
												  "aacagagggactttcaaaattcctaaactggttactgactaagaggaatcctcgcgctaa" +
												  "tgaagacaacctccatagaggtcaaatggcgcgcagttgacttcagtattgaccttcttc" +
												  "agggtcccccatctttgatacttcacttatggacccggccaccgtgagttgaatcccggc" +
												  "gtccctcgcgtccccaacacagacaatatttttacgtgtccaagggcggaaagtgacgag" +
												  "gtgagaactggcgccgcgagaccggcccgatttctaataggcgggatagagatctgcccg" +
												  "acgcatttcacttgtagtcactcacggtatgactgtgcatgcactgaccgtcgctggcgt" +
												  "gtctttaatttaagctaggcttgacgtggagtgcagaatgaccatgttcaaggtgcttcg" +
												  "gggctatatacttgggataaacgcgatcctgcggagtagcgtcgagaacaccgactgccg" +
												  "aatgtacaatccgcgtgacaatgccgaggctcgagatatcacttgaactgcgggcgaatc" +
												  "gattcgagagcccgatcgttaacaagtcgtcggctgtagccaataatatcttggttttag" +
												  "atcttgagtgtgggggcgtttacttaaccatccgaacgcg";
}