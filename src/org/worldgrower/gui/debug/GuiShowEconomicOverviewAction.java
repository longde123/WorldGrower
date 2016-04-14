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
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;

import org.worldgrower.World;
import org.worldgrower.actions.Actions;
import org.worldgrower.actions.OperationStatistics;
import org.worldgrower.generator.Item;
import org.worldgrower.profession.Professions;

public class GuiShowEconomicOverviewAction extends AbstractAction {
	private World world;
	
	public GuiShowEconomicOverviewAction(World world) {
		super();
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame();
		
		JTable table = new JTable(new WorldModel(world));
		table.setBounds(50, 50, 200, 700);
		frame.add(new JScrollPane(table));
		
		Timer timer = new Timer(500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				table.repaint();
			}
			
		});
		
		timer.start();
		
		frame.setBounds(100,  100, 300, 800);
		frame.setVisible(true);
	}
	
	private static class WorldModel extends AbstractTableModel {

		private World world;
		
		public WorldModel(World world) {
			super();
			this.world = world;
		}

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public int getRowCount() {
			return 17 + Item.values().length - 1;
		}

		@Override
		public String getColumnName(int columnIndex) {
			if (columnIndex == 0) {
				return "Name";
			} else if (columnIndex == 1) {
				return "Count";
			} else {
				return null;
			}
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if (columnIndex == 0) {
				if (rowIndex == 0) {
					return "CutWoodAction";
				} else if (rowIndex == 1) {
					return "CutWoodAction by non-professionals";
				} else if (rowIndex == 2) {
					return "HarvestFood";
				} else if (rowIndex == 3) {
					return "HarvestFood by non-professionals";
				} else if (rowIndex == 4) {
					return "EatFood";
				} else if (rowIndex == 5) {
					return "MineStone";
				} else if (rowIndex == 6) {
					return "MineStone by non-professionals";
				} else if (rowIndex == 7) {
					return "MineOre";
				} else if (rowIndex == 8) {
					return "MineOre by non-professionals";
				} else if (rowIndex == 9) {
					return "MineGold";
				} else if (rowIndex == 10) {
					return "MineGold by non-professionals";
				} else if (rowIndex == 11) {
					return "HarvestCotton";
				} else if (rowIndex == 12) {
					return "HarvestCotton by non-professionals";
				} else if (rowIndex == 13) {
					return "BuildHouseAction";
				} else if (rowIndex == 14) {
					return "BuildHouseAction by non-professionals";
				} else if (rowIndex == 15) {
					return "ConstructBedAction";
				} else if (rowIndex == 16) {
					return "ConstructBedAction by non-professionals";
				} else {
					return Item.values()[rowIndex - 16].name() + " (current price/default price)";
				}
			} else if (columnIndex == 1) {
				if (rowIndex == 0) {
					return OperationStatistics.getRecentOperationsCount(Actions.CUT_WOOD_ACTION, world);
				} else if (rowIndex == 1) {
					return OperationStatistics.getRecentOperationsByNonProfessionalsCount(Actions.CUT_WOOD_ACTION, Professions.LUMBERJACK_PROFESSION, world);
				} else if (rowIndex == 2) {
					return OperationStatistics.getRecentOperationsCount(Actions.HARVEST_FOOD_ACTION, world);
				} else if (rowIndex == 3) {
					return OperationStatistics.getRecentOperationsByNonProfessionalsCount(Actions.HARVEST_FOOD_ACTION, Professions.FARMER_PROFESSION, world);
				} else if (rowIndex == 4) {
					return OperationStatistics.getRecentOperationsCount(Actions.EAT_ACTION, world);
				} else if (rowIndex == 5) {
					return OperationStatistics.getRecentOperationsCount(Actions.MINE_STONE_ACTION, world);
				} else if (rowIndex == 6) {
					return OperationStatistics.getRecentOperationsByNonProfessionalsCount(Actions.MINE_STONE_ACTION, Professions.MINER_PROFESSION, world);
				} else if (rowIndex == 7) {
					return OperationStatistics.getRecentOperationsCount(Actions.MINE_ORE_ACTION, world);
				} else if (rowIndex == 8) {
					return OperationStatistics.getRecentOperationsByNonProfessionalsCount(Actions.MINE_ORE_ACTION, Professions.MINER_PROFESSION, world);
				} else if (rowIndex == 9) {
					return OperationStatistics.getRecentOperationsCount(Actions.MINE_GOLD_ACTION, world);
				} else if (rowIndex == 10) {
					return OperationStatistics.getRecentOperationsByNonProfessionalsCount(Actions.MINE_GOLD_ACTION, Professions.MINER_PROFESSION, world);
				} else if (rowIndex == 11) {
					return OperationStatistics.getRecentOperationsCount(Actions.HARVEST_COTTON_ACTION, world);
				} else if (rowIndex == 12) {
					return OperationStatistics.getRecentOperationsByNonProfessionalsCount(Actions.HARVEST_COTTON_ACTION, Professions.WEAVER_PROFESSION, world);
				} else if (rowIndex == 13) {
					return OperationStatistics.getRecentOperationsCount(Actions.BUILD_HOUSE_ACTION, world);
				} else if (rowIndex == 14) {
					return OperationStatistics.getRecentOperationsByNonProfessionalsCount(Actions.BUILD_HOUSE_ACTION, Professions.CARPENTER_PROFESSION, world);
				} else if (rowIndex == 15) {
					return OperationStatistics.getRecentOperationsCount(Actions.CONSTRUCT_BED_ACTION, world);
				} else if (rowIndex == 16) {
					return OperationStatistics.getRecentOperationsByNonProfessionalsCount(Actions.CONSTRUCT_BED_ACTION, Professions.CARPENTER_PROFESSION, world);
				} else {
					Item item = Item.values()[rowIndex - 16];
					return OperationStatistics.getPrice(item, world) + "/" + item.getPrice();
				}
			} else {
				return null;
			}
		}
	}
}