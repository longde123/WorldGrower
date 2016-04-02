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
import org.worldgrower.Reach;
import org.worldgrower.World;
import org.worldgrower.WorldObject;
import org.worldgrower.actions.Actions;

public class CreateWineGoal implements Goal {

	public CreateWineGoal(List<Goal> allGoals) {
		allGoals.add(this);
	}

	@Override
	public OperationInfo calculateGoal(WorldObject performer, World world) {
		if (performer.getProperty(Constants.INVENTORY).getQuantityFor(Constants.GRAPE) < 5) {
			List<WorldObject> targets = GoalUtils.findNearestTargets(performer, Actions.HARVEST_GRAPES_ACTION, w -> Reach.distance(performer, w) < 20  ,world);
			if (targets.size() > 0) {
				return new OperationInfo(performer, targets.get(0), Args.EMPTY, Actions.HARVEST_GRAPES_ACTION);
			} else {
				WorldObject target = BuildLocationUtils.findOpenLocationNearExistingProperty(performer, 2, 3, world);
		
				if (target != null) {
					return new OperationInfo(performer, target, Args.EMPTY, Actions.PLANT_GRAPE_VINE_ACTION);
				} else {
					return null;
				}
			}
		} else {
			return new OperationInfo(performer, performer, Args.EMPTY, Actions.BREW_WINE_ACTION);
		}
	}
	
	@Override
	public void goalMetOrNot(WorldObject performer, World world, boolean goalMet) {
	}

	@Override
	public boolean isGoalMet(WorldObject performer, World world) {
		return performer.getProperty(Constants.INVENTORY).getQuantityFor(Constants.WINE) > 5;
	}
	
	@Override
	public boolean isUrgentGoalMet(WorldObject performer, World world) {
		return isGoalMet(performer, world);
	}

	@Override
	public String getDescription() {
		return "planting grape vines";
	}

	@Override
	public int evaluate(WorldObject performer, World world) {
		return performer.getProperty(Constants.INVENTORY).getQuantityFor(Constants.WINE);
	}
}