package com.taig.dna;

import org.junit.Test;

import static com.taig.dna.Nucleotide.Purine.Adenine;
import static com.taig.dna.Nucleotide.Purine.Guanine;
import static com.taig.dna.Nucleotide.Pyrimidine.Cytosine;
import static com.taig.dna.Nucleotide.Pyrimidine.Thymine;
import static org.junit.Assert.assertTrue;

public class NucleotideTest
{
	@Test(expected = IllegalArgumentException.class)
	public void newInstanceWithInvalidAbbreviation()
	{
		Nucleotide.newInstance( 'X' );
	}

	@Test
	public void newInstanceWithValidAbbreviations()
	{
		assertTrue( Nucleotide.newInstance( Adenine.ABBREVIATION ) instanceof Adenine );
		assertTrue( Nucleotide.newInstance( Cytosine.ABBREVIATION ) instanceof Cytosine );
		assertTrue( Nucleotide.newInstance( Guanine.ABBREVIATION ) instanceof Guanine );
		assertTrue( Nucleotide.newInstance( Thymine.ABBREVIATION ) instanceof Thymine );
	}
}