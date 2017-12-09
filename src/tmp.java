
public class tmp {
public static void main(String[] args) {
	System.out.print("_tiles");
	for(int i=0; i<40; i++){
		System.out.print(".addItem(tile"+(i<10?"0"+i:i)+")");
	}
	System.out.print(";");
}
}
