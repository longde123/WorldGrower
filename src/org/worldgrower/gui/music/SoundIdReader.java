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
package org.worldgrower.gui.music;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.worldgrower.gui.start.Game;

public class SoundIdReader {

	private final Map<SoundIds, Clip> sounds = new HashMap<>();
	
	public SoundIdReader() {
		readSound(SoundIds.CUT_WOOD, "/sound/workshop - wood clap - 8bit.wav.gz");
	}

	private void readSound(SoundIds soundIds, String path) {
		Clip audioClip;
		try {
			InputStream audioFilePath = new BufferedInputStream(new GZIPInputStream(Game.class.getResourceAsStream(path)));
			audioClip = BackgroundMusicUtils.readMusicFile(audioFilePath);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			throw new IllegalStateException("Problem reading " + path, e);
		}
		sounds.put(soundIds, audioClip);
	}
	
	public void playSoundEffect(SoundIds soundIds) {
		sounds.get(soundIds).setFramePosition(0);
		sounds.get(soundIds).start();
	}
}