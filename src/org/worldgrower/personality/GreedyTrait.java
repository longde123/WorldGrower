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
package org.worldgrower.personality;

public class GreedyTrait extends AbstractPersonalityTrait {

	@Override
	public String getAdjective(int relationshipValue) {
		if (getValue() > 0) {
			if (relationshipValue < 0) {
				return "miserly";
			} else if (relationshipValue < 250) {
				return "stingy";
			} else if (relationshipValue < 500) {
				return "greedy";
			} else {
				return "insatiable";
			}
		} else {
			if (relationshipValue < 0) {
				return "compassionate";
			} else if (relationshipValue < 250) {
				return "kind";
			} else if (relationshipValue < 500) {
				return "charitable";
			} else {
				return "generous";
			}
		}
	}
}