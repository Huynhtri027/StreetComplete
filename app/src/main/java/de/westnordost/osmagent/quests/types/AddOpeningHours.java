package de.westnordost.osmagent.quests.types;

import android.app.DialogFragment;
import android.os.Bundle;

import de.westnordost.osmagent.quests.QuestImportance;
import de.westnordost.osmagent.quests.dialogs.OpeningHoursDialog;
import de.westnordost.osmapi.map.data.Element;

public class AddOpeningHours extends AbstractQuestType
{
    @Override
	protected String getTagFilters()
	{
		return " elements with ( shop and shop !~ no|vacant or" +
               " amenity ~ restaurant|cafe|ice_cream|fast_food|bar|pub|biergarten|cinema|nightclub|" +
                          "bank|atm|post_office|library|courthouse|embassy|" +
                          "car_wash|car_rental|marketplace|fuel|" +
		                  "dentist|doctors|clinic|pharmacy|veterinary or" +
               " amenity = bicycle_parking and bicycle_parking = building or" +
               " amenity = parking and parking = multi-storey or" +
               " amenity = recycling and recycling_type = centre or" +
               " tourism ~ zoo|theme_park|gallery|museum or" +
               " tourism = information and information = office or" +
               " leisure ~ golf_course|water_park|miniature_golf )" +
               " and !opening_hours";
	}

    @Override
    public int importance()
    {
        return QuestImportance.MINOR;
    }

	@Override
	public DialogFragment getDialog()
	{
		return new OpeningHoursDialog();
	}

	@Override
	public void applyAnswerTo(Bundle answer, Element element)
	{
		// TODO
	}
}