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
package org.worldgrower.gui;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JTextPane;

import org.worldgrower.conversation.ConversationFormatter;
import org.worldgrower.conversation.Response;
import org.worldgrower.generator.Item;
import org.worldgrower.generator.ItemType;
import org.worldgrower.gui.conversation.ConversationArgumentFormatter;
import org.worldgrower.gui.conversation.JTextPaneConversationFormatterImpl;
import org.worldgrower.gui.conversation.TextConversationArgumentFormatter;
import org.worldgrower.gui.util.JTextPaneUtils;

public class ImageSubstituter implements ConversationArgumentFormatter {

	private final TooltipImages tooltipImages = new TooltipImages();
	private final ImageInfoReader imageInfoReader;
	
	private static final List<Item> ITEMS_TO_SUBSTITUTE = getItemsToSubstitute();
	
	public ImageSubstituter(ImageInfoReader imageInfoReader) {
		super();
		this.imageInfoReader = imageInfoReader;
	}

	public String substituteImagesInHtml(String tooltip) {
		String changedTooltip = tooltip;
		for(Entry<String, ImageIds> mapping : getTextToImageMapping().entrySet()) {
			changedTooltip = tooltipImages.substituteImages(changedTooltip, mapping.getKey(), mapping.getValue(), imageInfoReader::smallImageTag);
		}
		return changedTooltip;
	}
	
	public void subtituteImagesInTextPane(JTextPane textPane, String text) {
		JTextPaneMapper textPaneMapper = new JTextPaneMapper(textPane, imageInfoReader);
		String changedText = text;
		for(Entry<String, ImageIds> mapping : getTextToImageMapping().entrySet()) {
			changedText = tooltipImages.substituteImages(changedText, mapping.getKey(), mapping.getValue(), textPaneMapper::addImage);
		}
		textPaneMapper.addText(changedText);
	}
	
	public void subtituteImagesInTextPane(JTextPane textPane, Response response) {
		response.getResponsePhrase(new JTextPaneConversationFormatterImpl(textPane, new TextConversationArgumentFormatter(), imageInfoReader));
	}

	private static List<Item> getItemsToSubstitute() {
		return Item.getItems(ItemType.FOOD, ItemType.RESOURCE, ItemType.INGREDIENT, ItemType.WEAPON, ItemType.ARMOR, ItemType.DRINK, ItemType.TOOL);
	}
	
	private Map<String, ImageIds> getTextToImageMapping() {
		Map<String, ImageIds> textToImageMapping = new HashMap<>();
		for(Item resourceItem : ITEMS_TO_SUBSTITUTE) {
			textToImageMapping.put(resourceItem.getDescription(), resourceItem.getImageId());
		}
		textToImageMapping.put("gold", ImageIds.SMALL_GOLD_COIN);
		return textToImageMapping;
	}
	
	private static class JTextPaneMapper {
		private final JTextPane textPane;
		private final ImageInfoReader imageInfoReader;
		
		public JTextPaneMapper(JTextPane textPane, ImageInfoReader imageInfoReader) {
			super();
			this.textPane = textPane;
			this.imageInfoReader = imageInfoReader;
		}

		public String addImage(ImageIds imageId) {
			return "[" + imageId.name() + "]";
		}
		
		public void addText(String text) {
			final String remainingText = text;
			int currentIndex = 0;
			int previousIndex = 0;
			
			while (currentIndex < remainingText.length()) {
				
				if (remainingText.charAt(currentIndex) == '[') {
					int startIndexOfImage = currentIndex;
					int endImageIndex = remainingText.indexOf(']', startIndexOfImage);
					String imageIdString = remainingText.substring(startIndexOfImage+1, endImageIndex);
					ImageIds imageId = ImageIds.valueOf(imageIdString);
					
					//example text: 1 [WOOD] wood added to inventory
					JTextPaneUtils.appendTextUsingLabel(textPane, remainingText.substring(previousIndex, startIndexOfImage));
					Image image = imageInfoReader.getImage(imageId, null);
					JTextPaneUtils.appendIcon(textPane, image);
					
					currentIndex = endImageIndex;
					previousIndex = currentIndex+1;
				}
				if (remainingText.charAt(currentIndex) == '\n') {
					JTextPaneUtils.appendTextUsingLabel(textPane, remainingText.substring(previousIndex, currentIndex));
					JTextPaneUtils.insertNewLine(textPane);
					previousIndex = currentIndex;
				}
				
				currentIndex++;
			}
			JTextPaneUtils.appendTextUsingLabel(textPane, remainingText.substring(previousIndex));
		}
	}

	@Override
	public String formatObject(ConversationFormatter conversationFormatter, Object object) {
		if (object instanceof Item) {
			Item item = (Item) object;
			if (ITEMS_TO_SUBSTITUTE.contains(item)) {
				ImageIds imageId = item.getImageId();
				if (item == Item.GOLD) {
					imageId = ImageIds.SMALL_GOLD_COIN;
				}
				return tooltipImages.formatImage(item.getDescription(), imageId, imageInfoReader::smallImageTag);
			} else {
				return item.getDescription();
			}
		} else {
			TextConversationArgumentFormatter textConversationArgumentFormatter = new TextConversationArgumentFormatter();
			return textConversationArgumentFormatter.formatObject(conversationFormatter, object);
		}
	}
}
