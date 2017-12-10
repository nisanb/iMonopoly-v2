package View.Game.Controller;

import Utils.NamedColor;
import Utils.Param;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class PlayerUI {
		private Integer pID;
		private String pName;
		private ImageView _small, _big;
		private NamedColor playerColor;
		
		//UI Container
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
			
			//Set containers
			this.pNickname.setText(pName);
			this.pMoney.setText(Param.get(Param.STARTING_CASH).toString());
			this.pStrikes.setText("3");
			this.pValue.setText("$0");
			
			//Set images
			_small = new ImageView(new Image("/Resources/PSD/Players/"+playerColor+".png"));
			_small.setFitHeight(30);
			_small.setFitWidth(20);
			_big.setImage(new Image("/Resources/PSD/Players/"+playerColor+".png"));
			this.playerContainer.setVisible(true);
		}
		
		public PlayerUI(String playerName){
			this.pName=playerName;	
		}
		
		public void glow(Boolean glow){
			Double glowDouble = glow?1.0:0.0;
			this.playerContainer.setEffect(new Glow(glowDouble==1.0?0.5:glowDouble));
		}

		/**
		 * @return the pID
		 */
		public Integer getpID() {
			return pID;
		}

		/**
		 * @param pID the pID to set
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
		 * @param pName the pName to set
		 */
		public void setpName(String pName) {
			this.pName = pName;
		}

		/**
		 * @return the _small
		 */
		public ImageView get_small() {
			return _small;
		}

		/**
		 * @param _small the _small to set
		 */
		public void set_small(ImageView _small) {
			this._small = _small;
		}

		/**
		 * @return the _big
		 */
		public ImageView get_big() {
			return _big;
		}

		/**
		 * @param _big the _big to set
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
		 * @param playerColor the playerColor to set
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
		 * @param playerContainer the playerContainer to set
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
		 * @param pMoney the pMoney to set
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
		 * @param pStrikes the pStrikes to set
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
		 * @param pValue the pValue to set
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
		 * @param pNickname the pNickname to set
		 */
		public void setpNickname(Label pNickname) {
			this.pNickname = pNickname;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((pName == null) ? 0 : pName.hashCode());
			return result;
		}

		/* (non-Javadoc)
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
