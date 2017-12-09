package Utils;

import java.awt.Color;

public enum NamedColor {
	  BLUE(Color.BLUE, "Blue"),
	  RED(Color.RED, "Red"),
	  YELLOW(Color.YELLOW, "Yellow"),
	  GREEN(Color.GREEN, "Green");

	  private final Color awtColor;
	  private final String colorName;

	  private NamedColor(Color awtColor, String name) {
	    this.awtColor = awtColor;
	    this.colorName = name;
	  }

	  public Color getAwtColor() {
	    return awtColor;
	  }

	  public String getColorName() {
	    return colorName;
	  }
	}
