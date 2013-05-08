package com.taig.dna;

import org.junit.Test;
import static org.junit.Assert.*;

public class CodingContestTest
{
	public CodingContest contest( String dna )
	{
		return new CodingContest( new Sequence( dna.replaceAll( "\\s", "" ) ) );
	}

	@Test
	public void hasRiskOfTiberiusSyndromeOnUnaffectedSequence()
	{
		assertFalse( contest( "AGGG TCTT GGAA TCCT AAGT" ).hasBrownEyes().getResult() );
	}

	@Test
	public void hasRiskOfTiberiusSyndromeOnAffectedSequence()
	{
		throw new UnsupportedOperationException();
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