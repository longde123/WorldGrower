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

import org.worldgrower.Constants;
import org.worldgrower.OperationInfo;
import org.worldgrower.World;
import org.worldgrower.WorldObject;
import org.worldgrower.actions.Actions;
import org.worldgrower.conversation.Conversations;

public class SwindleMoneyGoal implements Goal {

	public SwindleMoneyGoal(List<Goal> allGoals) {
		allGoals.add(this);
	}

	@Override
	public OperationInfo calculateGoal(WorldObject performer, World world) {
		if (FacadeUtils.performerIsSuccessFullyDisguised(performer)) {
			int disguisedPersonId = performer.getProperty(Constants.FACADE).getProperty(Constants.ID);
			WorldObject disguisedPerson = world.findWorldObject(Constants.ID, disguisedPersonId);
			Integer disguisedPersonMateId = disguisedPerson.getProperty(Constants.MATE_ID);
			if (disguisedPersonMateId != null) {
				WorldObject disguisedPersonMate = GoalUtils.findNearestPersonLookingLike(performer, disguisedPersonMateId, world);
				if (isSwindleTarget(disguisedPersonMate)) {
					return new OperationInfo(performer, disguisedPersonMate, Conversations.createArgs(Conversations.DEMAND_MONEY_CONVERSATION), Actions.TALK_ACTION);
				}
			}
		} else {
			List<WorldObject> targets = world.findWorldObjectsByProperty(Constants.STRENGTH, w -> isSwindleTarget(w));
			if (targets.size() > 0) {
				WorldObject target = targets.get(0);
				int targetMateId = target.getProperty(Constants.MATE_ID);
				WorldObject targetMate = GoalUtils.findNearestPersonLookingLike(performer, targetMateId, world);
				if (Goals.FIND_SECLUDED_LOCATION_GOAL.isGoalMet(performer, world)) {
					return new OperationInfo(performer, performer, new int[] {targetMate.getProperty(Constants.ID)}, Actions.DISGUISE_MAGIC_SPELL_ACTION);
				} else {
					return Goals.FIND_SECLUDED_LOCATION_GOAL.calculateGoal(performer, world);
				}
			}
		}
		return null;
	}
	
	private boolean isSwindleTarget(WorldObject w) {
		if (w.getProperty(Constants.GOLD) > 100) {
			if (w.getProperty(Constants.MATE_ID) != null) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void goalMetOrNot(WorldObject performer, World world, boolean goalMet) {
	}

	@Override
	public boolean isGoalMet(WorldObject performer, World world) {
		return performer.getProperty(Constants.GOLD) > 200;
	}
	
	@Override
	public boolean isUrgentGoalMet(WorldObject performer, World world) {
		return isGoalMet(performer, world);
	}

	@Override
	public String getDescription() {
		return "swindling people out of money";
	}

	@Override
	public int evaluate(WorldObject performer, World world) {
		return performer.getProperty(Constants.GOLD);
	}

}
