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
package org.worldgrower.conversation;

import java.util.Arrays;
import java.util.List;

import org.worldgrower.Constants;
import org.worldgrower.World;
import org.worldgrower.WorldObject;
import org.worldgrower.actions.Actions;
import org.worldgrower.goal.ArenaPropertyUtils;
import org.worldgrower.goal.RelationshipPropertyUtils;
import org.worldgrower.history.HistoryItem;

public class StartArenaFightConversation implements Conversation {

	private static final int YES = 0;
	private static final int NO = 1;
	private static final int WAIT = 2;
	
	@Override
	public Response getReplyPhrase(ConversationContext conversationContext) {
		WorldObject target = conversationContext.getTarget();
		World world = conversationContext.getWorld();
		
		final int replyId;
		int peopleScheduledForFight = ArenaPropertyUtils.getPeopleScheduledForArenaFight(target, world).size();
		if (peopleScheduledForFight == 1) {
			replyId = YES;
		} else if (peopleScheduledForFight == 0) {
			replyId = WAIT;
		} else {
			replyId = NO;
		}
		
		return getReply(getReplyPhrases(conversationContext), replyId);
	}

	@Override
	public List<Question> getQuestionPhrases(WorldObject performer, WorldObject target, HistoryItem questionHistoryItem, World world) {
		return Arrays.asList(
			new Question(null, "I would like to fight in the arena. Can I fight?")
			);
	}

	@Override
	public List<Response> getReplyPhrases(ConversationContext conversationContext) {
		return Arrays.asList(
			new Response(YES, "yes, you can start right away"),
			new Response(NO, "no, there is already another fight"),
			new Response(WAIT, "yes, but you'll have to wait until an opponent comes forth")
			);
	}
	
	@Override
	public void handleResponse(int replyIndex, ConversationContext conversationContext) {
		WorldObject performer = conversationContext.getPerformer();
		WorldObject target = conversationContext.getTarget();
		World world = conversationContext.getWorld();
		
		List<WorldObject> peopleScheduledForFight = ArenaPropertyUtils.getPeopleScheduledForArenaFight(target, world);
		if (replyIndex == YES) {
			WorldObject opponent = peopleScheduledForFight.get(0);
			
			performer.setProperty(Constants.ARENA_OPPONENT_ID, opponent.getProperty(Constants.ID));
			opponent.setProperty(Constants.ARENA_OPPONENT_ID, performer.getProperty(Constants.ID));
			
			WorldObject topLeftArena = world.findWorldObject(Constants.ID, target.getProperty(Constants.ARENA_IDS).getIds().get(0));
			int arenaX = topLeftArena.getProperty(Constants.X);
			int arenaY = topLeftArena.getProperty(Constants.Y);
			
			performer.setProperty(Constants.X, arenaX+1);
			performer.setProperty(Constants.Y, arenaY+1);
			
			opponent.setProperty(Constants.X, arenaX+6);
			opponent.setProperty(Constants.Y, arenaY+6);
		} else if (replyIndex == WAIT) {
			performer.setProperty(Constants.ARENA_OPPONENT_ID, -1);
		} else if (replyIndex == NO) {
			RelationshipPropertyUtils.changeRelationshipValue(performer, target, -5, Actions.TALK_ACTION, Conversations.createArgs(this), world);
		}
	}

	@Override
	public boolean isConversationAvailable(WorldObject performer, WorldObject target, WorldObject subject, World world) {
		return ArenaPropertyUtils.worldObjectOwnsArena(target)
				&& ArenaPropertyUtils.personIsArenaFighter(performer, target)
				&& !ArenaPropertyUtils.personIsScheduledToFightInArena(performer, target);
	}
	
	@Override
	public String getDescription(WorldObject performer, WorldObject target, World world) {
		return "looking to start an arena fight";
	}
}