package com.taig.dna;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceTest
{
	@Test(expected = NullPointerException.class)
	public void constructSequenceWithNullStringArgument()
	{
		new Sequence( (String) null );
	}

	@Test(expected = IllegalArgumentException.class)
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
	public void getComplementOnEmptySequence()
	{
		Sequence sequence = new Sequence();

		assertEquals( sequence, sequence.getComplement() );
		assertTrue( sequence.getComplement().isEmpty() );
	}

	@Test
	public void getComplementOnHealthySequence()
	{
		Sequence sequence = new Sequence( "acgt" );

		assertEquals( sequence.getComplement(), new Sequence( "tgca" ) );
	}

	@Test(expected = NullPointerException.class)
	public void matchWithNullArgument()
	{
		new Sequence().match( null );
	}

	@Test
	public void matchWithNotMatchingArgumentOnHealthySequence()
	{
		assertFalse( new Sequence( "acgt" ).match( "ca" ).find() );
	}

	@Test
	public void matchWithMatchingArgumentOnHealthySequence()
	{
		assertTrue( new Sequence( "acgt" ).match( "ac" ).find() );
	}

	@Test( expected = NullPointerException.class )
	public void containsWithNullArgument()
	{
		new Sequence().contains( null );
	}

	@Test
	public void containsWithNotMatchingArgumentOnHealthySequence()
	{
		assertFalse( new Sequence( "acgt" ).contains( "at" ) );
	}

	@Test
	public void containsWithMatchingArgumentOnHealthySequence()
	{
		assertTrue( new Sequence( "acgt" ).contains( "cg" ) );
	}

	@Test( expected = NullPointerException.class )
	public void countWithNullArgument()
	{
		new Sequence().count( null );
	}

	@Test
	public void countOnHealthySequence()
	{
		assertEquals( 3, new Sequence( "acgtacgtacgt" ).count( "ac" ) );
	}

	@Test
	public void toStringOnHealthySequence()
	{
		String sequence = "acgt";

		assertEquals( new Sequence( sequence ).toString(), sequence.toUpperCase() );
	}
}