package com.taig.dna;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class CodingContestTest
{
	protected CodingContest empty;

	public CodingContest contest( String dna )
	{
		return new CodingContest( new Sequence( dna.replaceAll( "\\s", "" ) ) );
	}

	@Before
	public void setUp()
	{
		this.empty = contest( "" );
	}

	// At least three distinct occurrences of the sequence GGG.

	@Test
	public void hasRiskOfTiberiusSyndromeOnUnaffectedSequence()
	{
		assertFalse( contest( "AGGG TCTT GGAA TCCT AAGT" ).hasRiskOfTiberiusSyndrome().getResult() );
	}

	@Test
	public void hasRiskOfTiberiusSyndromeOnAffectedSequence()
	{
		assertTrue( contest( "AGGG TCGG GGAA TCCT GGGT" ).hasRiskOfTiberiusSyndrome().getResult() );
		assertTrue( contest( "AGGG TCGG GGGG TCCT GGGT" ).hasRiskOfTiberiusSyndrome().getResult() );
	}

	// Has a CAG segment followed by exactly one C or one G and is then not followed by T the next two slots.

	@Test
	public void hasBrownEyesOnUnaffectedSequence()
	{
		assertFalse( contest( "CATA GAAT" ).hasBrownEyes().getResult() );
		assertFalse( contest( "CAGA GAAT" ).hasBrownEyes().getResult() );
		assertFalse( contest( "CAGC TAAT" ).hasBrownEyes().getResult() );
		assertFalse( contest( "CAGG TTAT" ).hasBrownEyes().getResult() );
	}

	@Test
	public void hasBrownEyesOnAffectedSequence()
	{
		assertTrue( contest( "CAGC GAAT" ).hasBrownEyes().getResult() );
		assertTrue( contest( "CAGG ACAT" ).hasBrownEyes().getResult() );
	}

	@Test
	public void countNucleotidesOnEmptySequence()
	{
		for( Map.Entry<String, Integer> entry : empty.countNucleotides().getResult().entrySet() )
		{
			assertSame( 0, entry.getValue() );
		}
	}

	@Test
	public void countNucleotidesOnHealthySequence()
	{
		for( Map.Entry<String, Integer> entry : contest( "AAAA CCCC GGGG TTTT" ).countNucleotides().getResult().entrySet() )
		{
			assertSame( 4, entry.getValue() );
		}
	}

	@Test
	public void findFirstCtagOccurrenceOnEmptySequence()
	{
		assertSame( -1, empty.findFirstCtagOccurrence().getResultSet() );
		assertNull( empty.findFirstCtagOccurrence().getResult() );
	}

	@Test
	public void findFirstCtagOccurrenceOnHealthySequenceWithoutCtag()
	{
		assertSame( -1, contest( "AAGG CTAT GGAA" ).findFirstCtagOccurrence().getResultSet() );
		assertNull( contest( "AAGG CTAT GGAA" ).findFirstCtagOccurrence().getResult() );
	}

	@Test
	public void findFirstCtagOccurrenceOnHealthySequenceWithCtag()
	{
		assertSame( 5, contest( "AAGG CTAG GGAA" ).findFirstCtagOccurrence().getResult() );
	}

	@Test
	public void hasMorePurinesThanPyrimidinesOnEmptySequence()
	{
		assertFalse( empty.hasMorePurinesThanPyrimidines().getResult() );
		assertSame( 0, empty.hasMorePurinesThanPyrimidines().getResultSet()[0] );
		assertSame( 0, empty.hasMorePurinesThanPyrimidines().getResultSet()[1] );
	}

	@Test
	public void hasMorePurinesThanPyrimidinesOnHealthySequence()
	{
		assertFalse( contest( "AAAA TTTT GTCCC" ).hasMorePurinesThanPyrimidines().getResult() );
		assertTrue( contest( "AAAA TTTT GGGG" ).hasMorePurinesThanPyrimidines().getResult() );
	}

	@Test
	public void hasFromingenDischrypsiaEvidenceOnUnaffectedSequence()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void hasFromingenDischrypsiaEvidenceOnAffectedSequence()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void getComplementSequenceOnEmptySequence()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void getComplementSequenceOnHealthySequence()
	{
		throw new UnsupportedOperationException();
	}
}