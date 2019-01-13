package codeJeu;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import GUI.Clavier;
import GUI2.TableauJeu;
import GUI2.Texture;
import GUI2.fenetreObjets;

public class Piece {

	public static boolean confirmationPerteJeu = false;
	public static boolean confirmationGagnerJeu = false;

	private LevierPorte levierPorte;

	private boolean nord;
	private boolean sud;
	private boolean est;
	private boolean ouest;
	private Porte[] porte;

	private boolean passageSecret;

	private int xFirst = -200;
	private int yFirst = -200;

	private int xSecond = -200;
	private int ySecond = -200;

	/*
	 * 
	 * private int xFirst = 30; private int yFirst = 40;
	 * 
	 * private final int xSecond = 630; private final int ySecond = 410;
	 * 
	 */
	private final String passageSecretRoute = "/passageSecret1.png";
	private final int HEIGHT = 118, WIDHT = 87;
	Texture texture = TableauJeu.getInstance();

	private List<Personnage> personnages;

	// Creation de joueur pour pouvoir instances les deplacements des monstres selon
	// le joueur
	private Joueur joueur;

	// variables pour les passages secrets
	static int passage = 0;
	boolean passageHaute = false;
	boolean passageBas = false;

	// listePotions
	private ArrayList<Potion> listePotions = new ArrayList<Potion>();

	public Piece(boolean nord, boolean sud, boolean est, boolean ouest, boolean passageSecret,
			List<Personnage> personnage) {
		super();
		this.nord = nord;
		this.sud = sud;
		this.est = est;
		this.ouest = ouest;
		this.porte = new Porte[4];
		this.passageSecret = passageSecret;
		this.personnages = personnage;
		this.levierPorte = new LevierPorte(400, 50);
		if (passageSecret) {
			passage++;
			if (passage == 1) {
				passageHaute = true;
			} else if (passage == 2) {
				passageBas = true;
			}

		}

		if (nord) {
			porte[0] = new Porte(350, 1);
		}
		if (sud) {
			porte[1] = new Porte(350, 499);
		}
		if (est) {
			porte[2] = new Porte(719, 250);
		}
		if (ouest) {
			porte[3] = new Porte(1, 250);
		}

		levierPorte = new LevierPorte(680, 65);

	}
	// savoir si il y'a un passage secret

	public boolean isPassageSecret() {
		return passageSecret;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public List<Personnage> getPersonnage() {
		return personnages;
	}

	public void setPersonnage(List<Personnage> personnage) {
		this.personnages = personnage;
	}

	public boolean isNord() {
		return nord;
	}

	public boolean isSud() {
		return sud;
	}

	public boolean isEst() {
		return est;
	}

	public boolean isOuest() {
		return ouest;
	}

	public Porte[] getPorte() {
		return porte;
	}

	public int nombreMonstresDansLaPiece() {
		int nombreMonstres = 0;
		Iterator<Personnage> iterateur = personnages.iterator();
		while (iterateur.hasNext()) {
			Monstre personnage = (Monstre) personnages;
			if (personnage.getClass().equals("codeJeu.Monstre")) {
				nombreMonstres++;
			}
		}
		return nombreMonstres;
	}

	public void transporterPersonnage(Piece[][] toutesLesPieces) {
		for (int i = 0; i < toutesLesPieces.length; i++) {

			for (int j = 0; j < toutesLesPieces[i].length; j++) {
				// si dans la piece il y a un passage secret
				if (toutesLesPieces[i][j].isPassageSecret()) {

					// si le personnage principal n'est pas là
					Iterator<Personnage> iter = personnages.iterator();
					boolean isPer = false;
					while (iter.hasNext()) {
						Personnage per = iter.next();

						if (per.getClass().equals("codeJeu.Joueur")) {
							// le personnage principal est dans la sale
							isPer = true;
						}

					}

					// changer coordonées x et y de personnagge
					if (!isPer) {

						// changerCoordonneesPersonnage();
					}

				}

			}

		}
	}

	/*
	 * private void changerCoordonneesPersonnage() { throw new
	 * UnsupportedOperationException("Not supported yet."); //To change body of
	 * generated methods, choose Tools | Templates. }
	 */

	// methode pour ajouter potion dans liste potion
	public void ajouterPotion(Potion p) {
		listePotions.add(p);
	}

	public void dessinerComponents(Graphics2D g) {

		/*
		 * joueur.PlayerAnimationDown.runAnimation();
		 * joueur.PlayerAnimationUp.runAnimation();
		 * joueur.PlayerAnimationLeft.runAnimation();
		 * joueur.PlayerAnimationRight.runAnimation();
		 */
		// Dessinner COmposants
		Iterator<Personnage> iterator = personnages.iterator();

		while (iterator.hasNext()) {
			Personnage personnage = iterator.next();

			/*
			 * System.out.println(personnage.getClass()); if
			 * (personnage.getClass().getName().equals("codeJeu.Joueur") ||
			 * personnage.getClass().getName().equals("codeJeu.Monstre")) {
			 * System.out.println("c'est un monstre ou joueur"); } else {
			 * System.out.println("AUTRE");
			 * 
			 * }
			 */
			// DESINNER PERSONAGES AVEC ANIMATION
			if (personnage.getClass().getName().equals("codeJeu.Joueur")) {
				joueur = (Joueur) personnage;
				joueur.PlayerAnimationDown.runAnimation();
				joueur.PlayerAnimationUp.runAnimation();
				joueur.PlayerAnimationLeft.runAnimation();
				joueur.PlayerAnimationRight.runAnimation();
				joueur.PlayerAnimationStand.runAnimation();
			}

			if (personnage.getClass().getName().equals("codeJeu.Monstre")) {
				Monstre monstre = (Monstre) personnage;
				monstre.MonstreAnimationDown.runAnimation();
				monstre.MonstreAnimationLeft.runAnimation();
				monstre.MonstreAnimationRight.runAnimation();
				monstre.MonstreAnimationUp.runAnimation();
			}

			// creer les hitboxs
			g.fill(personnage.getHitBox());

			// Dessiner Personnages immobiles
			if (!personnage.getClass().getName().equals("codeJeu.Monstre")
					&& !personnage.getClass().getName().equals("codeJeu.Joueur")) {
				// System.out.println(personnage.getClass().getName());
				personnage.dessiner(g);
			}
		}

		dessinerPortes(g);
		dessinerPassagesSecrets(g);
		dessinerLevierPorte(g);
		dessinerPotion(g);
		fenetreObjets.getProgbarArmure().getProgressBar().setValue((joueur.getArmure()));
		fenetreObjets.getProgbarVie().getProgressBar().setValue(joueur.getPdv());
		fenetreObjets.getProgbarForce().getProgressBar().setValue(joueur.getForce());

	}

	private void dessinerPotion(Graphics2D g) {
		Iterator<Potion> iterateurPotion = listePotions.iterator();
		while (iterateurPotion.hasNext()) {
			Potion p = iterateurPotion.next();
			p.dessinerPotion(g);
			g.fill(p.getHitBox());
		}
	}

	private void dessinerPortes(Graphics2D g) {
		if (isNord()) {
			g.fill(porte[0].getHitBox());
			porte[0].dessiner(g);
		}
		if (isSud()) {
			porte[1].dessinerBas(g);
		}
		if (isEst()) {
			g.fill(porte[2].getHitBox());
			porte[2].dessinerDroite(g);
		}
		if (isOuest()) {
			g.fill(porte[3].getHitBox());
			porte[3].dessinerGauche(g);
		}

	}

	private void dessinerLevierPorte(Graphics2D g) {

		levierPorte.dessiner(g);
	}

	public void actualiser(Graphics2D g2) {
		Clavier.update();

		// bouger le joueur
		joueur.seDeplacer(g2);

		// Parcourir liste pour trouver les personnages qui sont monstres pour le faire
		// bouger
		Iterator<Personnage> iterator = personnages.iterator();
		while (iterator.hasNext()) {
			Personnage personnage = iterator.next();

			// Bouger les monstres
			if (personnage.getClass().getName().equals("codeJeu.Monstre")) {
				Monstre monstre = (Monstre) personnage;
				monstre.chercherJoueur(g2, joueur.getX(), joueur.getY());
			}
		}

		confirmations();

	}

	private void confirmations() {
		collisionMedecin(joueur);
		collisionCuisinier(joueur);
		collisionMagicien(joueur);
		collisionPortes(joueur);
		collisionPrincesse(joueur);
		collisionMonstre(joueur);
		collisionPassageSecretFirst(joueur);
		collisionPassageSecretSecond(joueur);
		collisionLevierPorte(joueur);
		collisionPotion(joueur);

		if (joueur.getPdv() == 0) {
			confirmationPerteJeu = true;
		}
	}

	public ArrayList<Potion> getListePotions() {
		return listePotions;
	}

	/**
	 * 
	 */
	private void collisionLevierPorte(Joueur joueur2) {
		// TODO Auto-generated method stub
		if (levierPorte.getHitBox().intersects(joueur2.getHitBox())) {
			ouvrirPortes();
			levierPorte.setActive(true);
		}

	}

	private void collisionPotion(Joueur joueur) {
		Iterator<Potion> listePotionIter = listePotions.iterator();
		// System.out.println("entre fct");
		while (listePotionIter.hasNext()) {

			// System.out.println("entre boucle");
			Potion potion = listePotionIter.next();
			/*
			 * System.out.println(potion.isType()); System.out.println(potion.getClass());
			 * if (potion.getHitBox().intersects(joueur.getHitBox())) {
			 * if(potion.getClass().equals("codeJeu.PotionVie") && potion.isType()==false) {
			 * System.out.println("entre premier boucle"); if(joueur.getPdv()<90) {
			 * joueur.setPdv(joueur.getPdv()+10); potion.setX(-9000); } else {
			 * joueur.setPdv(100); potion.setX(-9000); }
			 * 
			 * } else if(potion.getClass().equals("codeJeu.PotionVie") &&
			 * potion.isType()==true) { System.out.println("entre premier boucle2");
			 * if(joueur.getPdv()<70) { joueur.setPdv(joueur.getPdv()+30);
			 * potion.setX(-9000); } else { joueur.setPdv(100); potion.setX(-9000); } } else
			 * if (potion.getClass().equals("codeJeu.PotionForce") && potion.isType()==true)
			 * { System.out.println("entre premier boucle2"); if(joueur.getForce()<70) {
			 * joueur.setForce(joueur.getForce()+30); potion.setX(-9000); } else {
			 * joueur.setForce(100); potion.setX(-9000); } } else
			 * if(potion.getClass().equals("codeJeu.PotionForce") && potion.isType()==false)
			 * { System.out.println("entre premier boucle"); if(joueur.getForce()<90) {
			 * joueur.setPdv(joueur.getForce()+10); potion.setX(-9000); } else {
			 * joueur.setForce(100); potion.setX(-9000); }
			 * 
			 * } }
			 */
			if (joueur.getHitBox().intersects(potion.getHitBox())) {
				if (!potion.isType())// petite potion
				{
					System.out.println(potion.getClass());
					if (potion.getClass().getName().equals("codeJeu.PotionVie"))// petite potion vie
					{
						System.out.println("entre petite potion vie");

						if (joueur.getPdv() < 90) {
							joueur.setPdv(joueur.getPdv() + 10);
							potion.setX(-9000);
						} else {
							joueur.setPdv(100);
							potion.setX(-9000);
						}
					} else if (potion.getClass().getName().equals("codeJeu.PotionForce"))// petite potion Force
					{
						System.out.println("entre petite potion force");
						System.out.println(potion.getClass());

						if (joueur.getForce() < 90) {
							joueur.setForce(joueur.getForce() + 10);
							potion.setX(-9000);
						} else {
							joueur.setForce(100);
							potion.setX(-9000);
						}
					} else if (potion.getClass().getName().equals("codeJeu.PotionArmure"))// grande potion Armure
					{
						System.out.println("entre petite potion armure");
						if (joueur.getArmure() < 90) {
							joueur.setArmure(joueur.getArmure() + 10);
							potion.setX(-9000);
						} else {
							joueur.setArmure(100);
							potion.setX(-9000);
						}
					}
				} else if (potion.isType())// grande potion
				{
					if (potion.getClass().getName().equals("codeJeu.PotionVie"))// grande potion vie
					{
						System.out.println("entre grande potion vie");
						if (joueur.getPdv() < 70) {
							joueur.setPdv(joueur.getPdv() + 30);
							potion.setX(-9000);
						} else {
							joueur.setPdv(100);
							potion.setX(-9000);
						}
					} else if (potion.getClass().getName().equals("codeJeu.PotionForce"))// grande potion Force
					{
						System.out.println("entre grande potion force");
						if (joueur.getForce() < 70) {
							joueur.setForce(joueur.getForce() + 30);
							potion.setX(-9000);
						} else {
							joueur.setForce(100);
							potion.setX(-9000);
						}
					} else if (potion.getClass().getName().equals("codeJeu.PotionArmure"))// grande potion Armure
					{
						System.out.println("entre grande potion armure");
						if (joueur.getArmure() < 70) {
							joueur.setArmure(joueur.getArmure() + 30);
							potion.setX(-9000);
						} else {
							joueur.setArmure(100);
							potion.setX(-9000);
						}
					}

				}
			}
		}

	}

	private void collisionPrincesse(Joueur joueur) {
		// GAGNER PARTIE SI COLLISTION

		Iterator<Personnage> iterator = personnages.iterator();

		while (iterator.hasNext()) {
			Personnage personnage = iterator.next();
			if (personnage.getClass().getName().equals("codeJeu.Princesse")) {
				Princesse princesse = (Princesse) personnage;
				// COllition avec le cuisinier
				if (princesse.getHitBox().intersects(joueur.getHitBox())) {
					confirmationGagnerJeu = true;
				}

			}
		}

	}

	private void collisionMedecin(Joueur joueur) {
		Iterator<Personnage> iterator = personnages.iterator();
		while (iterator.hasNext()) {
			Personnage personnage = iterator.next();
			if (personnage.getClass().getName().equals("codeJeu.Medecin")) {
				Medecin medecin = (Medecin) personnage;
				// COllition avec le magicien
				if (medecin.getHitBox().intersects(joueur.getHitBox())) {
					// System.out.println("Collition medecin");

					joueur.setPdv(ConstantesDeJeu.PDVMAX);
					fenetreObjets.getProgbarVie().getProgressBar().setValue(joueur.getPdv());
				}

			}
		}
	}

	private void collisionCuisinier(Joueur joueur) {
		Iterator<Personnage> iterator = personnages.iterator();

		while (iterator.hasNext()) {
			Personnage personnage = iterator.next();
			if (personnage.getClass().getName().equals("codeJeu.Cuisinier")) {
				Cuisinier cuisinier = (Cuisinier) personnage;
				// COllition avec le cuisinier
				if (cuisinier.getHitBox().intersects(joueur.getHitBox())) {
					joueur.setForce(ConstantesDeJeu.FORCEMAX);
					fenetreObjets.getProgbarForce().getProgressBar().setValue(joueur.getForce());

				}

			}
		}
	}

	private void collisionMagicien(Joueur joueur) {

		Iterator<Personnage> iterator = personnages.iterator();

		while (iterator.hasNext()) {
			Personnage personnage = iterator.next();
			if (personnage.getClass().getName().equals("codeJeu.Magicien")) {
				Magicien magicien = (Magicien) personnage;
				// COllition avec le magicien
				if (magicien.getHitBox().intersects(joueur.getHitBox())) {
					magicien.recuperationArmure(joueur);
					fenetreObjets.getProgbarArmure().getProgressBar().setValue((joueur.getArmure()));

				}

			}
		}

	}

	private void collisionMonstre(Joueur joueur) {

		Iterator<Personnage> iterator = personnages.iterator();

		while (iterator.hasNext()) {
			Personnage personnage = iterator.next();
			if (personnage.getClass().getName().equals("codeJeu.Monstre")) {
				Monstre monstre = (Monstre) personnage;
				// COllition avec le magicien
				if (monstre.getHitBox().intersects(joueur.getHitBox())) {
					// monstre.setX((int) (monstre.getX()-joueur.getHitBox().getWidth()));
					// monstre.setY((int) (monstre.getY()-joueur.getHitBox().getHeight()));
					// monstre.setX(monstre.getX()-joueur.getHEIGHT());
					// monstre.setY(monstre.getY()-joueur.getWIDHT());
					// System.out.println("entre fonction");
					/*
					 * if (joueur.getForce() > 0) { //System.out.println("entre force");
					 * joueur.setForce(joueur.getForce() - 1); } if (joueur.getArmure() > 0) {
					 * //System.out.println("entre armure"); joueur.setArmure(joueur.getArmure() -
					 * 1); } else { joueur.setPdv(joueur.getPdv() - 1); }
					 */

					if (monstre.getForce() >= 0 && monstre.getPdv() > 0) {
						// monstre.setPdv(monstre.getPdv()-1);
						// System.out.println("Vies monstres : " + monstre.getPdv());
						// System.out.println("FORCE MONSTRE : " + monstre.getForce());
						monstre.setForce(monstre.getForce() - 1);
						if (monstre.getForce() == 0) {
							monstre.setForce(1);
						}
						if (joueur.getForce() > 0) {
							// System.out.println("entre force");
							joueur.setForce(joueur.getForce() - 5);
							monstre.setPdv(monstre.getPdv() - 1);
						}

						// System.out.println("Vies monstres apres collition: " + monstre.getPdv());
						if (joueur.getArmure() > 0) {
							// System.out.println("entre armure");
							joueur.setArmure(joueur.getArmure() - 10);
						} else {
							joueur.setPdv(joueur.getPdv() - monstre.getForce());
						}

					}

					if (monstre.getPdv() == 0) {
						monstreFin(monstre);
					}

					System.out.println("forcemosntre" + monstre.getForce());
					// System.out.println("viemonstre" + monstre.getPdv());
					System.out.println("perso vie" + joueur.getPdv());

					// BOUGER LES MONSTRES POUR NE PAS RESTER AVEC LE JOUEUR
					if (joueur.getX() > monstre.getX()) {
						monstre.setX(monstre.getX() - 20);
					}

					if (joueur.getY() > monstre.getY()) {
						monstre.setY(monstre.getY() - 20);
					}

					if (joueur.getX() < monstre.getX()) {
						monstre.setX(monstre.getX() + 20);
					}

					if (joueur.getY() < monstre.getY()) {
						monstre.setY(monstre.getY() + 20);
					}

				}

				// System.out.println(joueur.getPdv());
				// System.out.println(joueur.getArmure());
				// System.out.println(joueur.getForce());
				fenetreObjets.getProgbarArmure().getProgressBar().setValue((joueur.getArmure()));
				fenetreObjets.getProgbarVie().getProgressBar().setValue(joueur.getPdv());
				fenetreObjets.getProgbarForce().getProgressBar().setValue(joueur.getForce());

				// System.out.println(joueur.getPdv());
			}
		}

	}

	/**
	 * finmonstre joueur a tuer monstre
	 */
	private void monstreFin(Monstre monstre) {
		// TODO Auto-generated method stub
		monstre.setX(-9999999);
		monstre.setY(-9999999);

		monstre.posInitialX = -9999999;
		monstre.posInitialY = -9999999;

		// System.out.println(monstre.getX()+" "+monstre.getY());
	}

	private void collisionPortes(Joueur joueur) {
		for (int i = 0; i < porte.length; i++) {
			if (isNord()) {
				// System.out.println("collision non");
				if (porte[0].getHitBox().intersects(joueur.getHitBox()) && porte[0].isOuvert()) {
					mettrePortesFermees();
					// joueur doit passer en bas
					TableauJeu.positionPiecePersonnageX--;
					joueur.setX(345);
					joueur.setY(435);
					// System.out.println("collision ok");
					mettreMonstresDansPositionInitiale();

				}
			}
			if (isSud()) {
				// System.out.println("collision non");
				if (porte[1].getHitBox().intersects(joueur.getHitBox()) && porte[1].isOuvert()) {
					mettrePortesFermees();
					// joueur doit passer en bas
					TableauJeu.positionPiecePersonnageX++;
					joueur.setX(350);
					joueur.setY(65);
					// System.out.println("collision ok");
					mettreMonstresDansPositionInitiale();

				}
			}
			if (isEst()) {
				if (porte[2].getHitBox().intersects(joueur.getHitBox()) && porte[2].isOuvert()) {
					mettrePortesFermees();
					// joueur doit passer en bas
					TableauJeu.positionPiecePersonnageY++;
					joueur.setX(66);
					joueur.setY(250);
					// System.out.println("collision ok");
					mettreMonstresDansPositionInitiale();

				}

			}
			if (isOuest()) {
				if (porte[3].getHitBox().intersects(joueur.getHitBox()) && porte[3].isOuvert()) {
					mettrePortesFermees();
					// joueur doit passer en bas
					TableauJeu.positionPiecePersonnageY--;
					joueur.setX(650);
					joueur.setY(250);
					// System.out.println("collision ok");
					mettreMonstresDansPositionInitiale();

				}
			}
		}

	}

	public Rectangle2D getHitBoxFirst() {
		return new Rectangle2D.Double(xFirst + 15, yFirst + 15, WIDHT, HEIGHT - 45);
	}

	public void dessinerFirst(Graphics2D g) {
		g.drawImage(texture.passageSecretFirst[0], xFirst, yFirst, null);
	}

	public Rectangle2D getHitBoxSecond() {
		return new Rectangle2D.Double(xSecond + 15, ySecond + 15, WIDHT, HEIGHT - 45);
	}

	public void dessinerSecond(Graphics2D g) {
		g.drawImage(texture.passageSecretSecond[0], xSecond, ySecond, null);
	}

	private void mettreMonstresDansPositionInitiale() {
		Iterator<Personnage> iterator = personnages.iterator();
		while (iterator.hasNext()) {
			Personnage personnage = iterator.next();
			if (personnage.getClass().getName().equals("codeJeu.Monstre")) {
				Monstre monstre = (Monstre) personnage;
				monstre.setX(monstre.posInitialX);
				monstre.setY(monstre.posInitialY);
			}
		}
	}

	private void dessinerPassagesSecrets(Graphics2D g) {

		// System.out.println("Passage " + passage);
		if (!(TableauJeu.positionPiecePersonnageX == 3 & TableauJeu.positionPiecePersonnageY == 4)
				|| !(TableauJeu.positionPiecePersonnageX == 3 & TableauJeu.positionPiecePersonnageY == 2)) {
			xFirst = -200;
			yFirst = -200;
			xSecond = -200;
			ySecond = -200;

		}

		if (TableauJeu.positionPiecePersonnageX == 3 & TableauJeu.positionPiecePersonnageY == 2) {

			xFirst = 30;
			yFirst = 40;

			dessinerFirst(g);
			g.fill(getHitBoxFirst());
		} else if (TableauJeu.positionPiecePersonnageX == 3 & TableauJeu.positionPiecePersonnageY == 4) {
			xSecond = 635;
			ySecond = 425;
			dessinerSecond(g);
			g.fill(getHitBoxSecond());
		}

	}

	public void collisionPassageSecretFirst(Joueur joueur) {
		if (getHitBoxFirst().intersects(joueur.getHitBox())) {
			TableauJeu.positionPiecePersonnageX = 3;
			TableauJeu.positionPiecePersonnageY = 4;
			joueur.setX(345);
			joueur.setY(435);
			// System.out.println("collision ok");
			mettreMonstresDansPositionInitiale();

//    		joueur.setX(595);
			// joueur.setY(410);
		}
	}

	public void collisionPassageSecretSecond(Joueur joueur) {
		if (getHitBoxSecond().intersects(joueur.getHitBox())) {
			TableauJeu.positionPiecePersonnageX = 3;
			TableauJeu.positionPiecePersonnageY = 2;
			mettreMonstresDansPositionInitiale();
			joueur.setX(60);
			joueur.setY(120);
		}
	}

	private void mettrePortesFermees() {
		for (int i = 0; i < porte.length; i++) {
			if (porte[i] != null) {
				porte[i].setOuvert(false);
			}
		}
	}

	private void ouvrirPortes() {
		if (isNord()) {
			porte[0].setOuvert(true);
		}
		if (isSud()) {
			porte[1].setOuvert(true);
		}
		if (isEst()) {
			porte[2].setOuvert(true);
		}
		if (isOuest()) {
			porte[3].setOuvert(true);
		}
	}
}
