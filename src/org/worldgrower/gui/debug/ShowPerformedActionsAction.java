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
package org.worldgrower.gui.debug;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import org.worldgrower.World;
import org.worldgrower.WorldObject;

public class ShowPerformedActionsAction extends AbstractAction {
	private WorldObject target;
	private World world;
	
	public ShowPerformedActionsAction(WorldObject target, World world) {
		super();
		this.target = target;
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PerformedActionsDialog dialog = new PerformedActionsDialog(target, world);
		dialog.showMe();
	}
}