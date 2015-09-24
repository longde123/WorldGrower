/*******************************************************************************
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.worldgrower.goal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.worldgrower.Constants;
import org.worldgrower.TestUtils;
import org.worldgrower.WorldObject;
import org.worldgrower.generator.ItemGenerator;

public class UTestArmorPropertyUtils {

	@Test
	public void testCalculateArmor() {
		WorldObject performer = TestUtils.createSkilledWorldObject(1);
		
		assertEquals(0, ArmorPropertyUtils.calculateArmor(performer));
		
		performer.setProperty(Constants.HEAD_EQUIPMENT, ItemGenerator.getIronHelmet(1f));
		performer.setProperty(Constants.TORSO_EQUIPMENT, ItemGenerator.getIronCuirass(1f));
		performer.setProperty(Constants.ARMS_EQUIPMENT, ItemGenerator.getIronGauntlets(1f));
		performer.setProperty(Constants.LEGS_EQUIPMENT, ItemGenerator.getIronGreaves(1f));
		performer.setProperty(Constants.FEET_EQUIPMENT, ItemGenerator.getIronBoots(1f));
		
		assertEquals(26, ArmorPropertyUtils.calculateArmor(performer));
	}
}
