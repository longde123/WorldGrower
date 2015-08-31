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
import static org.worldgrower.TestUtils.createIntelligentWorldObject;
import static org.worldgrower.goal.GroupPropertyUtils.createProfessionOrganization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.worldgrower.Constants;
import org.worldgrower.TestUtils;
import org.worldgrower.World;
import org.worldgrower.WorldImpl;
import org.worldgrower.WorldObject;
import org.worldgrower.attribute.IdList;
import org.worldgrower.attribute.IdRelationshipMap;
import org.worldgrower.profession.Professions;

public class UTestGroupPropertyUtils {

	@Test
	public void testIsWorldObjectPotentialEnemy() {
		WorldObject performer = createIntelligentWorldObject(1, Constants.GROUP, new IdList().add(3));
		WorldObject w1 = createIntelligentWorldObject(1, Constants.GROUP, new IdList());
		WorldObject w2 = createIntelligentWorldObject(1, Constants.GROUP, new IdList().add(4));
		WorldObject w3 = createIntelligentWorldObject(1, Constants.GROUP, new IdList().add(3).add(4));
		
		assertEquals(true, GroupPropertyUtils.isWorldObjectPotentialEnemy(performer, w1));
		assertEquals(true, GroupPropertyUtils.isWorldObjectPotentialEnemy(performer, w2));
		assertEquals(false, GroupPropertyUtils.isWorldObjectPotentialEnemy(performer, w3));
	}
	
	@Test
	public void testIsOrganizationNameInUse() {
		World world = new WorldImpl(0, 0, null, null);
		createProfessionOrganization(1, "TestOrg", Professions.FARMER_PROFESSION, world);
		
		assertEquals(true, GroupPropertyUtils.isOrganizationNameInUse("TestOrg", world));
		assertEquals(false, GroupPropertyUtils.isOrganizationNameInUse("TestOrg2", world));
	}
	
	@Test
	public void testFindOrganizationsUsingLeader() {
		World world = new WorldImpl(0, 0, null, null);
		WorldObject leader = createIntelligentWorldObject(1, Constants.GROUP, new IdList());
		world.addWorldObject(leader);
		
		IdList leaderGroup = leader.getProperty(Constants.GROUP);
		leaderGroup.add(createProfessionOrganization(1, "TestOrg", Professions.FARMER_PROFESSION, world));
		leaderGroup.add(createProfessionOrganization(2, "TestOrg2", Professions.FARMER_PROFESSION, world));
		
		List<WorldObject> organizations = GroupPropertyUtils.findOrganizationsUsingLeader(leader, world);
		assertEquals(1, organizations.size());
		assertEquals("TestOrg", organizations.get(0).getProperty(Constants.NAME));
	}
	
	@Test
	public void testFindOrganizationMembers() {
		World world = new WorldImpl(0, 0, null, null);
		WorldObject member = createIntelligentWorldObject(1, Constants.GROUP, new IdList());
		WorldObject nonMember = createIntelligentWorldObject(2, Constants.GROUP, new IdList());
		world.addWorldObject(member);
		world.addWorldObject(nonMember);
				
		WorldObject organization = createProfessionOrganization(1, "TestOrg", Professions.FARMER_PROFESSION, world);
		member.getProperty(Constants.GROUP).add(organization);
	
		assertEquals(Arrays.asList(member), GroupPropertyUtils.findOrganizationMembers(organization, world));
	
	}
	
	@Test
	public void testGetMostLikedLeaderId() {
		IdRelationshipMap idRelationshipMap = new IdRelationshipMap();
		idRelationshipMap.incrementValue(3, 100);
		idRelationshipMap.incrementValue(5, 200);
		WorldObject performer = TestUtils.createIntelligentWorldObject(1, Constants.RELATIONSHIPS, idRelationshipMap);
		List<WorldObject> organizations = new ArrayList<>();

		organizations.add(TestUtils.createIntelligentWorldObject(2, Constants.ORGANIZATION_LEADER_ID, 3));
		assertEquals(3, GroupPropertyUtils.getMostLikedLeaderId(performer, organizations).intValue());
		
		organizations.add(TestUtils.createIntelligentWorldObject(4, Constants.ORGANIZATION_LEADER_ID, 5));
		assertEquals(5, GroupPropertyUtils.getMostLikedLeaderId(performer, organizations).intValue());
	}
	
	@Test
	public void testGetMostLikedLeaderIdForNoLeader() {
		IdRelationshipMap idRelationshipMap = new IdRelationshipMap();
		idRelationshipMap.incrementValue(3, -100);
		WorldObject performer = TestUtils.createIntelligentWorldObject(1, Constants.RELATIONSHIPS, idRelationshipMap);
		List<WorldObject> organizations = new ArrayList<>();

		organizations.add(TestUtils.createIntelligentWorldObject(2, Constants.ORGANIZATION_LEADER_ID, 3));
		organizations.add(TestUtils.createIntelligentWorldObject(4, Constants.ORGANIZATION_LEADER_ID, null));
		assertEquals(null, GroupPropertyUtils.getMostLikedLeaderId(performer, organizations));
	}
}