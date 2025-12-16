package steks;

import java.util.Stack;

import javax.swing.JOptionPane;

public class Uzd1 {

	public static void main(String[] args) {
		String izvele, vards = "";
		Stack<String> mansSteks = new Stack<>();
		
		String[] darbibas = {"Ievadīt vārdu", "Noteikt vārda garumu", "Apskatīt pēdējo burtu", "Apgriezt vārdu", "Apturēt"};
				
		do {
			
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Darbību saraksts", 
					JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele == null)
				izvele = "Apturēt";
			
			switch(izvele) {
			case "Ievadīt vārdu":
				if(mansSteks.isEmpty()) {
					do {
						vards = JOptionPane.showInputDialog("Ievadi vārdu");
					}while(vards.contains(" "));

					for(int i = 0; i<vards.length(); i++) {
						mansSteks.push(Character.toString(vards.charAt(i)));
					}
				}else 
					JOptionPane.showMessageDialog(null, "Stekā jau atrodas vārds!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				break;
				
			case "Noteikt vārda garumu":
				if(!mansSteks.isEmpty())
					JOptionPane.showMessageDialog(null, "Stekā esošā vārda garums: "+mansSteks.size(), "Paziņojuma", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Steks ir tukšs!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);

				break;
				
			case "Apskatīt pēdējo burtu":
				if(!mansSteks.isEmpty())
					JOptionPane.showMessageDialog(null, "Stekā esošā vārda pēdējais burts: "+mansSteks.peek(), "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null,  "Steks ir tukšs!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "Apgriezt vārdu":
				if(!mansSteks.isEmpty()) {
				
					vards = "";
					int garums = mansSteks.size();
					for(int i=0; i<garums; i++) {
						vards += mansSteks.pop();
					}
					
					JOptionPane.showMessageDialog(null, "Apgrieztais vārds: "+vards, "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
					
				}else
					JOptionPane.showMessageDialog(null,  "Steks ir tukšs!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma apturēta!");
				break;
			}
		}while (!izvele.equals("Apturēt"));
	}
}
