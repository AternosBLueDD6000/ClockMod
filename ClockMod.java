package BLueDD.hud.mod.impl;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import BLueDD.hud.mod.HudMod;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class ClockMod extends HudMod{
	
	public ClockMod() {
		super("Clock", 6, 8);
	}

	@Override
    public int getWidth() {
        return fr.getStringWidth(getTime());
    }

	@Override
    public int getHieght() {
        return fr.FONT_HEIGHT;
    }
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		fr.drawString(getTime(), drag.getxPosition() + 1, drag.getyPosition() + 1, -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	public void draw() {
		Gui.drawRect(getX() - 2, getY() - 1, getX() + getWidth(), getY() + getHieght(), new Color(0,0,0,170).getRGB());
		fr.drawString(getTime(), drag.getxPosition() + 1, drag.getyPosition() + 1, -1);
		super.draw();
	}
	
	private String getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a");
        LocalDateTime localtime = LocalDateTime.now();
        return dtf.format(localtime);
    }
	
}
