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

import java.util.List;

import org.worldgrower.Args;
import org.worldgrower.Constants;
import org.worldgrower.OperationInfo;
import org.worldgrower.World;
import org.worldgrower.WorldObject;
import org.worldgrower.actions.Actions;

public class MarkHouseAsSellableGoal implements Goal {
	
	public MarkHouseAsSellableGoal(List<Goal> allGoals) {
		allGoals.add(this);
	}

	@Override
	public OperationInfo calculateGoal(WorldObject performer, World world) {
		List<WorldObject> houses = performer.getProperty(Constants.HOUSES).mapToWorldObjects(world, w -> !w.hasProperty(Constants.SELLABLE) || !w.getProperty(Constants.SELLABLE));
		if (houses.size() > 1) {
			WorldObject house = houses.get(1);
			return new OperationInfo(performer, house, Args.EMPTY, Actions.MARK_AS_SELLABLE_ACTION);
		}
		return null;
	}
	
	@Override
	public final boolean isUrgentGoalMet(WorldObject performer, World world) {
		return isGoalMet(performer, world);
	}
	
	@Override
	public final void goalMetOrNot(WorldObject performer, World world, boolean goalMet) {
	}

	@Override
	public final boolean isGoalMet(WorldObject performer, World world) {
		return HousePropertyUtils.allHousesButFirstSellable(performer, world);
	}

	@Override
	public String getDescription() {
		return "marking houses as sellable";
	}
	
	@Override
	public final int evaluate(WorldObject performer, World world) {
		return 0;
	}


}
