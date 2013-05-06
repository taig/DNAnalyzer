package com.taig.dna;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NucleotideTest
{
	@Test( expected = IllegalArgumentException.class )
	public void newInstanceWithInvalidAbbreviation()
	{
		Nucleotide.newInstance( 'X' );
	}

	@Test
	public void newInstanceWithValidAbbreviations()
	{
		assertTrue( Nucleotide.newInstance( 'A' ) instanceof Nucleotide.Purine.Adenine );
		assertTrue( Nucleotide.newInstance( 'C' ) instanceof Nucleotide.Pyrimidine.Cytosine );
		assertTrue( Nucleotide.newInstance( 'G' ) instanceof Nucleotide.Purine.Guanine );
		assertTrue( Nucleotide.newInstance( 'T' ) instanceof Nucleotide.Pyrimidine.Thymine );
	}
}