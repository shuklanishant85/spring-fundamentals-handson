package com.test.coupling.di;

import org.junit.Test;
import org.mockito.Mockito;

import com.coupling.di.Quest;

public class BraveKnightTest {
	
	@Test
	public void testEmbark(){
		Quest quest = Mockito.mock(Quest.class);
		quest.embark();
		Mockito.verify(quest);
	}

}
