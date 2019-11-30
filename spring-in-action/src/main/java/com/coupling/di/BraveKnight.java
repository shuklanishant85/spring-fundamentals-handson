package com.coupling.di;

public class BraveKnight {

	private Quest quest;

	/**
	 * @param quest
	 * 
	 *            BraveKnight doesn’t create his own quest. Instead, he’s given
	 *            a quest at construction time as a constructor argument. This
	 *            is a type of dependency injection known as constructor
	 *            injection.
	 * 
	 */
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}

	public void embarkOnQuest() {
		quest.embark();
	}

}
