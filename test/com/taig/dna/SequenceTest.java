package com.taig.dna;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceTest
{
	protected Empty empty;

	protected Healthy healthy;

	@Before
	public void setUp()
	{
		this.empty = new Empty();
		this.healthy = new Healthy();
	}

	@Test( expected = NullPointerException.class )
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
		assertEquals( healthy.dna.length(), healthy.sequence.size() );
	}

	@Test
	public void getComplementOnEmptySequence()
	{
		assertTrue( empty.complementSequence.isEmpty() );
	}

	@Test
	public void getComplementOnHealthySequence()
	{
		assertNotSame( healthy.sequence, healthy.complementSequence );
		assertEquals( healthy.sequence.size(), healthy.complementSequence.size() );
	}

	@Test(expected = NullPointerException.class)
	public void matchWithNullArgument()
	{
		healthy.sequence.match( null );
	}

	@Test
	public void matchWithNotMatchingArgumentOnHealthySequence()
	{
		assertFalse( healthy.sequence.match( healthy.missingSegment ).find() );
	}

	@Test
	public void matchWithMatchingArgumentOnHealthySequence()
	{
		assertTrue( healthy.sequence.match( healthy.existingSegment ).find() );
	}

	@Test( expected = NullPointerException.class )
	public void containsWithNullArgument()
	{
		healthy.sequence.contains( null );
	}

	@Test
	public void containsWithNotMatchingArgumentOnHealthySequence()
	{
		assertFalse( healthy.sequence.contains( healthy.missingSegment ) );
	}

	@Test
	public void containsWithMatchingArgumentOnHealthySequence()
	{
		assertTrue( healthy.sequence.contains( healthy.existingSegment ) );
	}

	@Test( expected = NullPointerException.class )
	public void countWithNullArgument()
	{
		healthy.sequence.count( null );
	}

	@Test
	public void countWithNotMatchingArgumentOnHealthySequence()
	{
		assertEquals( 0, new Sequence( healthy.dna + healthy.dna ).count( healthy.missingSegment ) );
	}

	@Test
	public void countWithMatchingArgumentOnHealthySequence()
	{
		assertEquals( 2, new Sequence( healthy.dna + healthy.dna ).count( healthy.existingSegment ) );
	}

	@Test
	public void toFormattedStringOnEmptySequence()
	{
		assertEquals( empty.sequence.toFormattedString(), "" );
	}

	@Test
	public void toFormattedStringOnHealthySequence()
	{
		assertEquals(
				healthy.dna.toUpperCase() + " " + healthy.dna.toUpperCase(),
				new Sequence( healthy.dna + healthy.dna ).toFormattedString() );
	}

	@Test
	public void toStringOnEmptySequence()
	{
		assertEquals( empty.sequence.toString(), "" );
	}

	@Test
	public void toStringOnHealthySequence()
	{
		assertEquals( healthy.sequence.toString(), healthy.dna.toUpperCase() );
	}

	protected static class Empty
	{
		public String dna, complementDna;

		public Sequence sequence, complementSequence;

		public Empty()
		{
			this( "", "" );
		}

		protected Empty( String dna, String complement )
		{
			this.dna = dna;
			this.sequence = new Sequence( dna );
			this.complementDna = complement;
			this.complementSequence = new Sequence( complement );
		}
	}

	protected static class Healthy extends Empty
	{
		public String missingSegment;

		public String existingSegment;

		public Healthy()
		{
			super( "acgt", "tgca" );
			this.missingSegment = "at";
			this.existingSegment = "ac";
		}
	}
}