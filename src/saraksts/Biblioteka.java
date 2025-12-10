package saraksts;

import java.util.LinkedList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Biblioteka {
	
	static String virknesParbaude(String zinojums, String nokl) {
		String ievade;
		do {
			ievade = JOptionPane.showInputDialog(null, zinojums, nokl);
			if(ievade == null)
				return null;
			
			ievade = ievade.trim();
			
		}while(!Pattern.matches("^[\\p{L} ]+$", ievade));
		return ievade;
	}
	
	static int skaitlaParbaude(String zinojums, int tips) {
		String ievade;
		int skaitlis;
		while(true) {
			ievade = JOptionPane.showInputDialog(null, zinojums, "Skaitļa ievade", JOptionPane.INFORMATION_MESSAGE);
			
			if(ievade == null)
				return -1;
			
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis < 1) {
					JOptionPane.showMessageDialog(null, "Ievadīts negatīvs skaitlis!", "Nekorekti dati", 
							JOptionPane.WARNING_MESSAGE);
				}
				
				return skaitlis;
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ievadīts nekorekts datu tips!", "Kļūda", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	static double skaitlaParbaude(String zinojums, double tips) {
		String ievade;
		double skaitlis;
		while(true) {
			ievade = JOptionPane.showInputDialog(null, zinojums, "Skaitļa ievade", JOptionPane.INFORMATION_MESSAGE);
			
			if(ievade == null)
				return -1;
			
			try {
				skaitlis = Double.parseDouble(ievade);
				if(skaitlis < 1) {
					JOptionPane.showMessageDialog(null, "Ievadīts negatīvs skaitlis!", "Nekorekti dati", 
							JOptionPane.WARNING_MESSAGE);
				}
				
				return skaitlis;
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Ievadīts nekorekts datu tips!", "Kļūda", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	static int meklet(LinkedList<Gramata> saraksts, String nosaukums) {
		for(int i=0; i<saraksts.size(); i++) {
			if(saraksts.get(i).getNosaukums().equalsIgnoreCase(nosaukums))
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String nosaukums, autors, izdevnieciba, izvelne;
		
		int id = 1, lppSk, indekss, skaits;
		double cena;
		LinkedList<Gramata> plaukts = new LinkedList<>();
		LinkedList<Gramata> panemtie = new LinkedList<>();
		
		String[] darbibas = {"Pievienot grāmatu", "Ņonemt grāmatu", "Apskatīt grāmatu", "Iznomāt grāmatu", "Apturēt"};
		
		do {
			izvelne = (String)JOptionPane.showInputDialog(null, 
					"Izvēlies darbību", "Darbību saraksts", JOptionPane.INFORMATION_MESSAGE, null, darbibas, darbibas[0]);
			
			
			if(izvelne == null)
				izvelne = "Apturēt";
			
			switch(izvelne) {
			case "Pievienot grāmatu":
				nosaukums = virknesParbaude("Ieraksti gŗmatas nosaukumu", "Zaļā pasaka");
				
				if(nosaukums == null)
				break;
				//Parbaudīt vai tāda grāmata jau nav ielikta plauktā
				
				for(int i=0; i<plaukts.size(); i++) {
					if(plaukts.get(i).getNosaukums().equalsIgnoreCase(nosaukums));
					boolean parb = true;
					JOptionPane.showMessageDialog(null, "Grāmata jau ielikta plauktā!", "Brīdinājums", 
							JOptionPane.WARNING_MESSAGE);	
					
				}
				
			
				
				autors = virknesParbaude("Ieraksti autora nosaukumu", "Inta Paraudziņa");
				
				if(autors == null)
				break;
				
				izdevnieciba = virknesParbaude("Norādi izdevniecības nosaukumu", "Jumprava");
				
				if(izdevnieciba == null)
				break;
				
				skaits = skaitlaParbaude("Norādi eksemplāru skaitu", 1);
				
				if(skaits==-1)
					break;
				
				cena = skaitlaParbaude("Norādi grāmatas cenu", 0.1);
				if(cena == -1)
					break;
				
				lppSk = skaitlaParbaude("Norādi lappušu skaits", 1);
				if(lppSk == -1)
					break;
				
				plaukts.add(new Gramata(id, skaits, lppSk, nosaukums, autors, izdevnieciba, cena));
				break;
				
			case "Noņemt grāmatu":
				if(plaukts.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nav plauktā neviena grāmata!", "Brīdinājums", 
							JOptionPane.WARNING_MESSAGE);
				}else {
					nosaukums = virknesParbaude("Kā sauc grāmatu, kuru vēlies noņemt?", "Baltā grāmata");
				if(nosaukums == null)
					break;
			
				indekss = meklet(plaukts, nosaukums);
				if(indekss == -1) 
					JOptionPane.showMessageDialog(null, "Meklētā grāmata nemaz plauktā neatrodas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				else {
					plaukts.remove(indekss);
					JOptionPane.showMessageDialog(null, "Grāmata dzēsta!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
				}
				}
			break;
			
			
			
			case "Apskatīt grāmatu":
				if(plaukts.isEmpty())
					JOptionPane.showMessageDialog(null, "Nav plauktā neviena grāmata!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				else {
				nosaukums = virknesParbaude("Kuru grāmatu aplūkot?", "Zaļā pasaka");
				if(nosaukums == null)
					break;
				
				indekss = meklet(plaukts, nosaukums);
				if(indekss == -1)
					JOptionPane.showMessageDialog(null,  "Meklētā grāmata nemaz plauktā neatrodas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
				else 
					plaukts.get(indekss).info();
				}
				break;
				
			case "Iznomāt grāmatu":
				if(plaukts.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nav plauktā neviena grāmata!", "Brīdinājums", 
							JOptionPane.WARNING_MESSAGE);
				}else {
					nosaukums = virknesParbaude("Kuru grāmatu iznomāt?", "Zaļā pasaka");
					if(nosaukums == null)
						break;
					
					indekss = meklet(plaukts, nosaukums);
					if(indekss == -1)
						JOptionPane.showMessageDialog(null, "Meklētā grāmata nemaz plauktā neatrodas!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
					else
						
						plaukts.get(indekss).panemtGramatu();
					
					// uzglabāt paņemto grāmatu linkedlist
				}
				break;
			
					
				// ieviest jaunu iespēju, izvēlēties no paņemtajām grāmatām, kuru Tu vēlies
				//  atgriezt
				
			case "Apturēt":
				JOptionPane.showMessageDialog(null, "Programma tiek apturēta!", "Paziņojums",  JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}while(!izvelne.equals("Apturēt"));
		}
	}
