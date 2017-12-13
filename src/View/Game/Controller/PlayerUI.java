package View.Game.Controller;

import java.text.NumberFormat;
import java.util.Locale;

import Utils.NamedColor;
import Utils.Param;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class PlayerUI {
	private Integer pID;
	private String pName;
	private Double _cash;
	private Double _assets;
	private ImageView _recent, _big;
	private NamedColor playerColor;
	private StringProperty _spCash;

	// UI Container
	private AnchorPane playerContainer;
	private Label pMoney, pStrikes, pValue, pNickname;

	/**
	 * @param pID
	 * @param pName
	 * @param playerColor
	 * @param playerContainer
	 * @param pMoney
	 * @param pStrikes
	 * @param pValue
	 * @param pNickname
	 */
	public PlayerUI(Integer pID, String pName, NamedColor playerColor, AnchorPane playerContainer, Label pMoney,
			Label pStrikes, Label pValue, Label pNickname, ImageView big) {
		this.pID = pID;
		this.pName = pName;
		this.playerColor = playerColor;
		this.playerContainer = playerContainer;
		this.pMoney = pMoney;
		this.pStrikes = pStrikes;
		this.pValue = pValue;
		this.pNickname = pNickname;
		this._big = big;
		this._assets = 0.0;
		// Set containers
		this.pNickname.setText(pName);
		this._cash = ((Integer) Param.get(Param.STARTING_CASH)).doubleValue();

		this._spCash = new SimpleStringProperty();
		this.pMoney.textProperty().bind(this._spCash);
		this._spCash.set(displayPrice(this._cash));
		this.pStrikes.setText("3");
		this.pValue.setText("$0");

		// Set images
		_big.setImage(new Image("/Resources/PSD/Players/" + playerColor + ".png"));
		this.playerContainer.setVisible(true);
	}

	public ImageView getRecentImage() {
		return _recent;
	}

	public ImageView getNewImage() {
		ImageView img = new ImageView(new Image("/Resources/PSD/Players/" + playerColor + ".png"));
		img.setFitHeight(30);
		img.setFitWidth(20);
		_recent = img;
		_recent.setOpacity(0.0);
		return img;
	}

	/**
	 * Partial constructor for comparision
	 * 
	 * @param playerName
	 */
	public PlayerUI(String playerName) {
		this.pName = playerName;
	}

	public void updateData(Double cash, Integer strikes, Double assetsWorth, Integer assetsAmount) {

		Timeline tl = new Timeline();

		// Check if needs to update cash
		if (cash != _cash) {
			Double cashDiff = cash - _cash;
			Double cashJumps = cashDiff / 1000;

			// Update will take 1 second
			for (int i = 0; i < 1000; i++) {
				tl.getKeyFrames().add(new KeyFrame(Duration.millis(1 * i), "update something", e -> {
					_cash += cashJumps;
					_spCash.set(displayPrice(_cash));
				}));

			}
			tl.play();

			Timeline tlColor = new Timeline();
			tlColor.getKeyFrames()
					.add(new KeyFrame(Duration.millis(0), new KeyValue(this.pMoney.textFillProperty(), Color.WHITE)));
			if (cash > _cash) {
				// We got more cash than we had
				tlColor.getKeyFrames().add(
						new KeyFrame(Duration.millis(1000), new KeyValue(this.pMoney.textFillProperty(), Color.GREEN)));

			} else {
				// We lost cash
				tlColor.getKeyFrames().add(
						new KeyFrame(Duration.millis(1000), new KeyValue(this.pMoney.textFillProperty(), Color.RED)));

			}
			tlColor.getKeyFrames().add(
					new KeyFrame(Duration.millis(2500), new KeyValue(this.pMoney.textFillProperty(), Color.WHITE)));

			tlColor.play();
		}

		// Check if needs to update strikes
		if (strikes != Integer.parseInt(pStrikes.getText())) {
			Timeline pStrikesTL = new Timeline();
			pStrikesTL.getKeyFrames()
					.add(new KeyFrame(Duration.millis(0), new KeyValue(this.pStrikes.textFillProperty(), Color.WHITE)));
			if (Integer.parseInt(pStrikes.getText()) > strikes || pStrikes.getText().length() != 0) {
				// We got more strikes now
				pStrikesTL.getKeyFrames().add(
						new KeyFrame(Duration.millis(1000), new KeyValue(this.pStrikes.textFillProperty(), Color.RED)));
			} else {
				pStrikesTL.getKeyFrames().add(new KeyFrame(Duration.millis(1000),
						new KeyValue(this.pStrikes.textFillProperty(), Color.GREEN)));
			}

			pStrikesTL.getKeyFrames().add(
					new KeyFrame(Duration.millis(2000), new KeyValue(this.pStrikes.textFillProperty(), Color.WHITE)));
			pStrikes.setText(strikes.toString());
			pStrikesTL.play();
		}

		//Check if player assets needs to be updated
		if(_assets != assetsWorth){
			Double assetsDiff = assetsWorth - _assets;
			Double assetsJumps = assetsDiff / 1000;

			// Update will take 1 second
			for (int i = 0; i < 1000; i++) {
				tl.getKeyFrames().add(new KeyFrame(Duration.millis(1 * i), "update something", e -> {
					_assets += assetsJumps;
					pValue.setText(displayPrice(_assets));
				}));

			}
			tl.play();

			Timeline tlColor = new Timeline();
			tlColor.getKeyFrames()
					.add(new KeyFrame(Duration.millis(0), new KeyValue(this.pValue.textFillProperty(), Color.WHITE)));
			if (assetsWorth > _assets) {
				// We got more cash than we had
				tlColor.getKeyFrames().add(
						new KeyFrame(Duration.millis(1000), new KeyValue(this.pValue.textFillProperty(), Color.GREEN)));

			} else {
				// We lost cash
				tlColor.getKeyFrames().add(
						new KeyFrame(Duration.millis(1000), new KeyValue(this.pValue.textFillProperty(), Color.RED)));

			}
			tlColor.getKeyFrames().add(
					new KeyFrame(Duration.millis(2500), new KeyValue(this.pValue.textFillProperty(), Color.WHITE)));

			tlColor.play();
		}
		pValue.setText(displayPrice(assetsWorth));
	}

	private String displayPrice(Double price) {
		// System.out.println("Displaying price " + price);
		return "$" + NumberFormat.getNumberInstance(Locale.US).format(price.intValue());
	}

	/**
	 * Set the glow of the player pane
	 * 
	 * @param glow
	 *            true/false
	 */
	public void glow(Boolean glow) {
		Double glowDouble = glow ? 1.0 : 0.0;
		this.playerContainer.setEffect(new Glow(glowDouble == 1.0 ? 0.5 : glowDouble));
	}

	/**
	 * @return the pID
	 */
	public Integer getpID() {
		return pID;
	}

	/**
	 * @param pID
	 *            the pID to set
	 */
	public void setpID(Integer pID) {
		this.pID = pID;
	}

	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}

	/**
	 * @param pName
	 *            the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}

	/**
	 * @return the _big
	 */
	public ImageView get_big() {
		return _big;
	}

	/**
	 * @param _big
	 *            the _big to set
	 */
	public void set_big(ImageView _big) {
		this._big = _big;
	}

	/**
	 * @return the playerColor
	 */
	public NamedColor getPlayerColor() {
		return playerColor;
	}

	/**
	 * @param playerColor
	 *            the playerColor to set
	 */
	public void setPlayerColor(NamedColor playerColor) {
		this.playerColor = playerColor;
	}

	/**
	 * @return the playerContainer
	 */
	public AnchorPane getPlayerContainer() {
		return playerContainer;
	}

	/**
	 * @param playerContainer
	 *            the playerContainer to set
	 */
	public void setPlayerContainer(AnchorPane playerContainer) {
		this.playerContainer = playerContainer;
	}

	/**
	 * @return the pMoney
	 */
	public Label getpMoney() {
		return pMoney;
	}

	/**
	 * @param pMoney
	 *            the pMoney to set
	 */
	public void setpMoney(Label pMoney) {
		this.pMoney = pMoney;
	}

	/**
	 * @return the pStrikes
	 */
	public Label getpStrikes() {
		return pStrikes;
	}

	/**
	 * @param pStrikes
	 *            the pStrikes to set
	 */
	public void setpStrikes(Label pStrikes) {
		this.pStrikes = pStrikes;
	}

	/**
	 * @return the pValue
	 */
	public Label getpValue() {
		return pValue;
	}

	/**
	 * @param pValue
	 *            the pValue to set
	 */
	public void setpValue(Label pValue) {
		this.pValue = pValue;
	}

	/**
	 * @return the pNickname
	 */
	public Label getpNickname() {
		return pNickname;
	}

	/**
	 * @param pNickname
	 *            the pNickname to set
	 */
	public void setpNickname(Label pNickname) {
		this.pNickname = pNickname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerUI other = (PlayerUI) obj;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		return true;
	}

}
