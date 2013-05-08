package com.taig.dna;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodingContestTest
{
	public CodingContest contest( String dna )
	{
		return new CodingContest( new Sequence( dna.replaceAll( "\\s", "" ) ) );
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

	@Test
	public void hasBrownEyesOnUnaffectedSequence()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void hasBrownEyesOnAffectedSequence()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void countNucleotidesOnEmptySequence()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void countNucleotidesOnHealtySequence()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void findFirstCtagOccurrenceOnEmptySequence()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void findFirstCtagOccurrenceOnHealthySequenceWithoutCtag()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void findFirstCtagOccurrenceOnHealthySequenceWithCtag()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void hasMorePurinesThanPyrimidinesOnEmptySequence()
	{
		throw new UnsupportedOperationException();
	}

	@Test
	public void hasMorePurinesThanPyrimidinesOnHealthySequence()
	{
		throw new UnsupportedOperationException();
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