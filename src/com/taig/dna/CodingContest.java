package com.taig.dna;

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
	 * Execute the command line application that prints the solutions to all given tasks.
	 *
	 * @param arguments Either no arguments at all (use pipe input or default fallback instead) or a DNA sequence on index
	 *                  0.
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
			Sequence sequence = new Sequence( dna );
		}
		catch( Exception exception )
		{
			System.out.println( "Error: " + exception.getMessage() + "." );
			System.exit( -1 );
		}
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