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
package org.worldgrower.deity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.worldgrower.gui.ImageIds;

public class UTestDeity {

	@Test
	public void testGetDeityByDescription() {
		assertEquals(Deity.ARES, Deity.getDeityByDescription("Ares"));
	}
	
	@Test
	public void testGetAllDeityNames() {
		assertEquals(13, Deity.getAllDeityNames().size());
		assertEquals("Aphrodite", Deity.getAllDeityNames().get(0));
	}
	
	@Test
	public void testGetAllDeityExplanations() {
		assertEquals(13, Deity.getAllDeityExplanations().size());
		assertEquals("Aphrodite is the Goddess of love, beauty, desire, sex and pleasure.", Deity.getAllDeityExplanations().get(0));
	}
	
	@Test
	public void testGetAllImageIds() {
		assertEquals(13, Deity.getAllImageIds().size());
		assertEquals(ImageIds.APHRODITE_SYMBOL, Deity.getAllImageIds().get(0));
	}
	
}
