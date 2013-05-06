package com.taig.dna;

import static org.junit.Assert.*;

import org.junit.Test;

public class SequenceTest
{
	@Test( expected = NullPointerException.class )
	public void constructSequenceWithNullStringArgument()
	{
		new Sequence( (String) null );
	}

	@Test( expected = IllegalArgumentException.class )
	public void constructSequenceWithInvalidStringResource()
	{
		new Sequence( "acxgt" );
	}

	@Test
	public void constructSequenceWithValidStringResource()
	{
		Sequence sequence = new Sequence( "acgt" );

		assertEquals( 4, sequence.size() );
		assertTrue( sequence.get( 0 ) instanceof Nucleotide.Purine.Adenine );
		assertTrue( sequence.get( 1 ) instanceof Nucleotide.Pyrimidine.Cytosine );
		assertTrue( sequence.get( 2 ) instanceof Nucleotide.Purine.Guanine );
		assertTrue( sequence.get( 3 ) instanceof Nucleotide.Pyrimidine.Thymine );
	}

	@Test
	public void getComplementWithEmptySequence()
	{
		Sequence sequence = new Sequence();

		assertEquals( sequence, sequence.getComplement() );
		assertTrue( sequence.getComplement().isEmpty() );
	}

	@Test
	public void getComplementWithHealthySequence()
	{
		Sequence sequence = new Sequence( "acgt" );

		assertEquals( sequence.getComplement(), new Sequence( "tgca" ) );
	}

	@Test
	public void toStringWithHealthySequence()
	{
		String sequence = "acgt";

		assertEquals( new Sequence( sequence ).toString(), sequence.toUpperCase() );
	}
}