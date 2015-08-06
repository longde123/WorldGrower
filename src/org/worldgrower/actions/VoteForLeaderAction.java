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
package org.worldgrower.actions;

import java.io.ObjectStreamException;

import org.worldgrower.ArgumentRange;
import org.worldgrower.Constants;
import org.worldgrower.ManagedOperation;
import org.worldgrower.Reach;
import org.worldgrower.World;
import org.worldgrower.WorldObject;

public class VoteForLeaderAction implements ManagedOperation {

	@Override
	public void execute(WorldObject performer, WorldObject target, int[] args, World world) {
		int voteId = args[0];
		target.getProperty(Constants.VOTES).incrementValue(voteId, 1);
	}

	@Override
	public boolean isValidTarget(WorldObject performer, WorldObject target, World world) {
		return VotingPropertyUtils.isVotingBox(target);
	}

	@Override
	public int distance(WorldObject performer, WorldObject target, int[] args, World world) {
		int targetVotingStageDistance = VotingPropertyUtils.votingBoxAcceptsVotes(target) ? 0 : 1;
		boolean performerAlreadyVoted = world.getHistory().findHistoryItems(performer, target, this).size() > 0;
		int performerAlreadyVotedDistance = performerAlreadyVoted ? 1 : 0;
		return Reach.evaluateTarget(performer, args, target, 1) + targetVotingStageDistance + performerAlreadyVotedDistance;
	}
	
	@Override
	public ArgumentRange[] getArgumentRanges() {
		return new ArgumentRange[] { new ArgumentRange(0, 100) };
	}
	
	@Override
	public String getDescription(WorldObject performer, WorldObject target, int[] args, World world) {
		return "voting for leader";
	}

	@Override
	public String getSimpleDescription() {
		return "vote for leader";
	}
	
	public Object readResolve() throws ObjectStreamException {
		return readResolveImpl();
	}
}
