/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import java.awt.image.BufferedImage;

/**
 *
 * @author dioxo
 */

/*
Class en charge de toutes les images du program,
prends tous les sprites et permet d'obtenir une partie specifique
*/
public class Texture {

    SpriteSheet squeletteSpriteSheet;
    private BufferedImage squelette_sheet = null;
    public BufferedImage[] squelette = new BufferedImage[36];

    SpriteSheet personnageSpriteSheet;
    private BufferedImage personnage_sheet = null;
    public BufferedImage[] personnage = new BufferedImage[1];

    SpriteSheet cuisinierSpriteSheet;
    private BufferedImage cuisinier_sheet = null;
    public BufferedImage[] cuisinier = new BufferedImage[1];

    SpriteSheet magicienSpriteSheet;
    private BufferedImage magicien_sheet = null;
    public BufferedImage[] magicien = new BufferedImage[1];

    SpriteSheet medecinSpriteSheet;
    private BufferedImage medecin_sheet = null;
    public BufferedImage[] medecin = new BufferedImage[1];

    SpriteSheet monstreGhostSpriteSheet;
    private BufferedImage monstreGhost_sheet = null;
    public BufferedImage[] monstreGhost = new BufferedImage[12];

    SpriteSheet monstreMinotaureSpriteSheet;
    private BufferedImage monstreMinotaure_sheet = null;
    public BufferedImage[] monstreMinotaure = new BufferedImage[12];

    SpriteSheet porteOuverteSpriteSheet;
    private BufferedImage porteOuverte_sheet = null;
    public BufferedImage[] porteHaut = new BufferedImage[2];

    SpriteSheet porteOuverteBasSpriteSheet;
    private BufferedImage porteOuverteBas_sheet = null;
    public BufferedImage[] porteBas = new BufferedImage[2];

    SpriteSheet porteOuverteDroiteSpriteSheet;
    private BufferedImage porteOuverteDroite_sheet = null;
    public BufferedImage[] porteDroite = new BufferedImage[2];

    SpriteSheet porteOuverteGaucheSpriteSheet;
    private BufferedImage porteOuverteGauche_sheet = null;
    public BufferedImage[] porteGauche = new BufferedImage[2];

    SpriteSheet passageSecretFirstSpriteSheet;
    private BufferedImage passageSecretFirst_sheet = null;
    public BufferedImage[] passageSecretFirst = new BufferedImage[1];

    SpriteSheet passageSecretSecondSpriteSheet;
    private BufferedImage passageSecretSecond_sheet = null;
    public BufferedImage[] passageSecretSecond = new BufferedImage[1];

    SpriteSheet princesseSpriteSheet;
    private BufferedImage princesse_sheet = null;
    public BufferedImage[] princesse = new BufferedImage[1];

    SpriteSheet levierPorteSpriteSheet;
    public BufferedImage levierPorte_sheet = null;
    public BufferedImage[] levierPorte = new BufferedImage[2];
    

    SpriteSheet potionViePetitSpriteSheet;
    public BufferedImage potionViePetit_sheet = null;
    public BufferedImage[] potionViePetit = new BufferedImage[1];
    
    SpriteSheet potionVieGrandSpriteSheet;
    public BufferedImage potionVieGrand_sheet = null;
    public BufferedImage[] potionVieGrand = new BufferedImage[1];
    
    SpriteSheet potionForcePetitSpriteSheet;
    public BufferedImage potionForcePetit_sheet = null;
    public BufferedImage[] potionForcePetit = new BufferedImage[1];
    
    SpriteSheet potionForceGrandSpriteSheet;
    public BufferedImage potionForceGrand_sheet = null;
    public BufferedImage[] potionForceGrand = new BufferedImage[1];
    
    SpriteSheet potionArmurePetitSpriteSheet;
    public BufferedImage potionArmurePetit_sheet = null;
    public BufferedImage[] potionArmurePetit = new BufferedImage[1];
    
    SpriteSheet potionArmureGrandSpriteSheet;
    public BufferedImage potionArmureGrand_sheet = null;
    public BufferedImage[] potionArmureGrand = new BufferedImage[1];
    

    SpriteSheet RickSpriteSheet;
    private BufferedImage Rick_sheet = null;
    public BufferedImage[] Rick = new BufferedImage[36];

    public Texture() {

        BufferedImageLoader loader = new BufferedImageLoader();

        squelette_sheet = loader.loadImage("/squelette.png");
        personnage_sheet = loader.loadImage("/squelette.png");
        //personnage_sheet = loader.loadImage("/personnage.png");
        cuisinier_sheet = loader.loadImage("/cuisinier.png");
        magicien_sheet = loader.loadImage("/magicien.png");
        medecin_sheet = loader.loadImage("/medecin.png");

        porteOuverte_sheet = loader.loadImage("/porteOuverte.png");
        porteOuverteBas_sheet = loader.loadImage("/porteOuverteBas.png");
        porteOuverteDroite_sheet = loader.loadImage("/porteOuverteDroite.png");
        porteOuverteGauche_sheet = loader.loadImage("/porteOuverteGauche.png");
        monstreGhost_sheet = loader.loadImage("/monstre2.png");
        monstreMinotaure_sheet = loader.loadImage("/monstre4.png");
        passageSecretFirst_sheet = loader.loadImage("/passageSecret1.png");
        passageSecretSecond_sheet = loader.loadImage("/passageSecret1.png");
        princesse_sheet = loader.loadImage("/princesse.png");

        levierPorte_sheet = loader.loadImage("/liverPorteGauche.png");

        
        potionViePetit_sheet = loader.loadImage("/potionViePetit.png");
        potionVieGrand_sheet = loader.loadImage("/potionVieGrande.png");
        
        potionForcePetit_sheet = loader.loadImage("/potionForcePetit.png");
        potionForceGrand_sheet = loader.loadImage("/potionForceGrand.png");
        
        potionArmurePetit_sheet = loader.loadImage("/potionArmurePetit.png");
        potionArmureGrand_sheet = loader.loadImage("/potionArmureGrand.png");

        Rick_sheet = loader.loadImage("/Rick.png");

        squeletteSpriteSheet = new SpriteSheet(squelette_sheet);
        personnageSpriteSheet = new SpriteSheet(personnage_sheet);
        cuisinierSpriteSheet = new SpriteSheet(cuisinier_sheet);
        magicienSpriteSheet = new SpriteSheet(magicien_sheet);
        medecinSpriteSheet = new SpriteSheet(medecin_sheet);
        RickSpriteSheet = new SpriteSheet(Rick_sheet);

        porteOuverteSpriteSheet = new SpriteSheet(porteOuverte_sheet);
        porteOuverteBasSpriteSheet = new SpriteSheet(porteOuverteBas_sheet);
        porteOuverteDroiteSpriteSheet = new SpriteSheet(porteOuverteDroite_sheet);
        porteOuverteGaucheSpriteSheet = new SpriteSheet(porteOuverteGauche_sheet);

        monstreGhostSpriteSheet = new SpriteSheet(monstreGhost_sheet);
        monstreMinotaureSpriteSheet = new SpriteSheet(monstreMinotaure_sheet);

        passageSecretFirstSpriteSheet = new SpriteSheet(passageSecretFirst_sheet);
        passageSecretSecondSpriteSheet = new SpriteSheet(passageSecretSecond_sheet);

        princesseSpriteSheet = new SpriteSheet(princesse_sheet);

        levierPorteSpriteSheet = new SpriteSheet(levierPorte_sheet);
        
        potionViePetitSpriteSheet = new SpriteSheet(potionViePetit_sheet);
        potionVieGrandSpriteSheet = new SpriteSheet(potionVieGrand_sheet);
        potionForcePetitSpriteSheet = new SpriteSheet(potionForcePetit_sheet);
        potionForceGrandSpriteSheet = new SpriteSheet(potionForceGrand_sheet);
        potionArmurePetitSpriteSheet = new SpriteSheet(potionArmurePetit_sheet);
        potionArmureGrandSpriteSheet = new SpriteSheet(potionArmureGrand_sheet);

        getPersonnage();
        //getSquelette();
        getCuisinier();
        getMagicien();
        getMedecin();

        getPorteOuverte();
        getPorteOuverteBas();
        getPorteOuverteDroite();
        getPorteOuverteGauche();

        getMonstreGhost();
        getMonstreMinotaure();

        getPassageSecretFirst();
        getPassageSecretSecond();

        getPrincesse();

        getLevierPorte();

        
        getPotionViePetit();
        getPotionVieGrand();
        
        getPotionForcePetit();
        getPotionForceGrand();
        
        getPotionArmurePetit();
        getPotionArmureGrand();
        
        

        getRick();
    }

    /**
	 * 
	 */
	private void getPotionArmureGrand() {
		// TODO Auto-generated method stub
		potionArmureGrand[0] = potionArmureGrandSpriteSheet.grabImage(1, 1, 32, 42);
	}

	/**
	 * 
	 */
	private void getPotionArmurePetit() {
		// TODO Auto-generated method stub
		potionArmurePetit[0] = potionArmurePetitSpriteSheet.grabImage(1, 1, 28, 27);
	}

	/**
	 * 
	 */
	private void getPotionForceGrand() {
		// TODO Auto-generated method stub
		potionForceGrand[0] = potionForceGrandSpriteSheet.grabImage(1, 1, 31, 42);
	}

	/**
	 * 
	 */
	private void getPotionForcePetit() {
		// TODO Auto-generated method stub
		potionForcePetit[0] = potionForcePetitSpriteSheet.grabImage(1, 1, 20, 23);
	}

	/**
	 * 
	 */
	private void getPotionVieGrand() {
		// TODO Auto-generated method stub
		potionVieGrand[0] = potionVieGrandSpriteSheet.grabImage(1, 1, 31, 42);
	}

	/**
	 * 
	 */
	private void getPotionViePetit() {
		// TODO Auto-generated method stub
		potionViePetit[0] = potionViePetitSpriteSheet.grabImage(1, 1, 17, 24);
	}

	private void getLevierPorte() {
        // TODO Auto-generated method stub
        levierPorte[0] = levierPorteSpriteSheet.grabImage(1, 1, 35, 32);
        levierPorte[1] = levierPorteSpriteSheet.grabImage(2, 1, 35, 32);
    }

    /**
     *
     */
    private void getPrincesse() {
        // TODO Auto-generated method stub
        princesse[0] = princesseSpriteSheet.grabImage(1, 1, 33, 47);
    }

    /**
     *        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

     */
    private void getPassageSecretFirst() {
        // TODO Auto-generated method stub
        passageSecretFirst[0] = passageSecretFirstSpriteSheet.grabImage(1, 1, 118, 87);
    }

    /**
     *
     */
    private void getPassageSecretSecond() {
        // TODO Auto-generated method stub
        passageSecretSecond[0] = passageSecretSecondSpriteSheet.grabImage(1, 1, 118, 87);
    }

    private void getSquelette() {

        //ANIMATIONS Enemi Squelette
        //Squelette immobile
        squelette[0] = squeletteSpriteSheet.grabImage(1, 3, 64, 64);

        //Walk Down
        squelette[1] = squeletteSpriteSheet.grabImage(2, 3, 64, 64);
        squelette[2] = squeletteSpriteSheet.grabImage(3, 3, 64, 64);
        squelette[3] = squeletteSpriteSheet.grabImage(4, 3, 64, 64);
        squelette[4] = squeletteSpriteSheet.grabImage(5, 3, 64, 64);
        squelette[5] = squeletteSpriteSheet.grabImage(6, 3, 64, 64);
        squelette[6] = squeletteSpriteSheet.grabImage(7, 3, 64, 64);
        squelette[7] = squeletteSpriteSheet.grabImage(8, 3, 64, 64);
        squelette[8] = squeletteSpriteSheet.grabImage(9, 3, 64, 64);

        //Walk Up
        squelette[9] = squeletteSpriteSheet.grabImage(1, 1, 64, 64);
        squelette[10] = squeletteSpriteSheet.grabImage(2, 1, 64, 64);
        squelette[11] = squeletteSpriteSheet.grabImage(3, 1, 64, 64);
        squelette[12] = squeletteSpriteSheet.grabImage(4, 1, 64, 64);
        squelette[13] = squeletteSpriteSheet.grabImage(5, 1, 64, 64);
        squelette[14] = squeletteSpriteSheet.grabImage(6, 1, 64, 64);
        squelette[15] = squeletteSpriteSheet.grabImage(7, 1, 64, 64);
        squelette[16] = squeletteSpriteSheet.grabImage(8, 1, 64, 64);
        squelette[17] = squeletteSpriteSheet.grabImage(9, 1, 64, 64);

        //Walk Left
        squelette[18] = squeletteSpriteSheet.grabImage(1, 2, 64, 64);
        squelette[19] = squeletteSpriteSheet.grabImage(2, 2, 64, 64);
        squelette[20] = squeletteSpriteSheet.grabImage(3, 2, 64, 64);
        squelette[21] = squeletteSpriteSheet.grabImage(4, 2, 64, 64);
        squelette[22] = squeletteSpriteSheet.grabImage(5, 2, 64, 64);
        squelette[23] = squeletteSpriteSheet.grabImage(6, 2, 64, 64);
        squelette[24] = squeletteSpriteSheet.grabImage(7, 2, 64, 64);
        squelette[25] = squeletteSpriteSheet.grabImage(8, 2, 64, 64);
        squelette[26] = squeletteSpriteSheet.grabImage(9, 2, 64, 64);

        //Walk Right
        squelette[27] = squeletteSpriteSheet.grabImage(1, 4, 64, 64);
        squelette[28] = squeletteSpriteSheet.grabImage(2, 4, 64, 64);
        squelette[29] = squeletteSpriteSheet.grabImage(3, 4, 64, 64);
        squelette[30] = squeletteSpriteSheet.grabImage(4, 4, 64, 64);
        squelette[31] = squeletteSpriteSheet.grabImage(5, 4, 64, 64);
        squelette[32] = squeletteSpriteSheet.grabImage(6, 4, 64, 64);
        squelette[33] = squeletteSpriteSheet.grabImage(7, 4, 64, 64);
        squelette[34] = squeletteSpriteSheet.grabImage(8, 4, 64, 64);
        squelette[35] = squeletteSpriteSheet.grabImage(9, 4, 64, 64);
    }

    private void getPersonnage() {

    }

    private void getCuisinier() {
        cuisinier[0] = cuisinierSpriteSheet.grabImage(1, 1, 39, 45);
    }

    private void getMagicien() {
        magicien[0] = magicienSpriteSheet.grabImage(1, 1, 43, 60);
    }

    private void getMedecin() {
        medecin[0] = medecinSpriteSheet.grabImage(1, 1, 29, 45);
    }

    private void getMonstreGhost() {
        //ANIMATIONS Enemi Squelette
        //Ghost immobile
        monstreGhost[0] = monstreGhostSpriteSheet.grabImage(1, 1, 47, 48);

        //Walk Down
        monstreGhost[1] = monstreGhostSpriteSheet.grabImage(2, 1, 47, 48);
        monstreGhost[2] = monstreGhostSpriteSheet.grabImage(3, 1, 47, 48);

        //Walk Left
        monstreGhost[3] = monstreGhostSpriteSheet.grabImage(1, 2, 47, 48);
        monstreGhost[4] = monstreGhostSpriteSheet.grabImage(2, 2, 47, 48);
        monstreGhost[5] = monstreGhostSpriteSheet.grabImage(3, 2, 47, 48);

        //Walk Right
        monstreGhost[6] = monstreGhostSpriteSheet.grabImage(1, 3, 47, 48);
        monstreGhost[7] = monstreGhostSpriteSheet.grabImage(2, 3, 47, 48);
        monstreGhost[8] = monstreGhostSpriteSheet.grabImage(3, 3, 47, 48);

        //Walk Up
        monstreGhost[9] = monstreGhostSpriteSheet.grabImage(1, 4, 47, 48);
        monstreGhost[10] = monstreGhostSpriteSheet.grabImage(2, 4, 47, 48);
        monstreGhost[11] = monstreGhostSpriteSheet.grabImage(3, 4, 47, 48);
    }

    private void getMonstreMinotaure() {
        //ANIMATIONS Enemi 
        //Minotaure immobile
        monstreMinotaure[0] = monstreMinotaureSpriteSheet.grabImage(1, 1, 46, 48);

        //Walk Down
        monstreMinotaure[1] = monstreMinotaureSpriteSheet.grabImage(2, 1, 46, 48);
        monstreMinotaure[2] = monstreMinotaureSpriteSheet.grabImage(3, 1, 46, 48);

        //Walk Left
        monstreMinotaure[3] = monstreMinotaureSpriteSheet.grabImage(1, 2, 46, 48);
        monstreMinotaure[4] = monstreMinotaureSpriteSheet.grabImage(2, 2, 46, 48);
        monstreMinotaure[5] = monstreMinotaureSpriteSheet.grabImage(3, 2, 46, 48);

        //Walk Right
        monstreMinotaure[6] = monstreMinotaureSpriteSheet.grabImage(1, 3, 46, 48);
        monstreMinotaure[7] = monstreMinotaureSpriteSheet.grabImage(2, 3, 46, 48);
        monstreMinotaure[8] = monstreMinotaureSpriteSheet.grabImage(3, 3, 46, 48);

        //Walk Up
        monstreMinotaure[9] = monstreMinotaureSpriteSheet.grabImage(1, 4, 46, 48);
        monstreMinotaure[10] = monstreMinotaureSpriteSheet.grabImage(2, 4, 46, 48);
        monstreMinotaure[11] = monstreMinotaureSpriteSheet.grabImage(3, 4, 46, 48);
    }

    private void getPorteOuverte() {
        porteHaut[0] = porteOuverteSpriteSheet.grabImage(1, 1, 66, 66);
        porteHaut[1] = porteOuverteSpriteSheet.grabImage(2, 1, 66, 66);
    }

    private void getPorteOuverteBas() {
        porteBas[0] = porteOuverteBasSpriteSheet.grabImage(1, 1, 66, 66);
        porteBas[1] = porteOuverteBasSpriteSheet.grabImage(2, 1, 66, 66);
    }

    private void getPorteOuverteDroite() {
        porteDroite[0] = porteOuverteDroiteSpriteSheet.grabImage(1, 1, 66, 66);
        porteDroite[1] = porteOuverteDroiteSpriteSheet.grabImage(1, 2, 66, 66);
    }

    private void getPorteOuverteGauche() {
        porteGauche[0] = porteOuverteGaucheSpriteSheet.grabImage(1, 1, 66, 66);
        porteGauche[1] = porteOuverteGaucheSpriteSheet.grabImage(1, 2, 66, 66);
    }

    private void getRick() {
        //Sans movement
        Rick[0] = RickSpriteSheet.grabImage(1, 1, 40, 80);
        Rick[1] = RickSpriteSheet.grabImage(2, 1, 40, 80);
        Rick[2] = RickSpriteSheet.grabImage(3, 1, 40, 80);

        //marcher en bas
        Rick[3] = RickSpriteSheet.grabImage(4, 1, 40, 80);
        Rick[4] = RickSpriteSheet.grabImage(5, 1, 40, 80);
        Rick[5] = RickSpriteSheet.grabImage(6, 1, 40, 80);

        //marcher en haut
        Rick[6] = RickSpriteSheet.grabImage(7, 1, 40, 80);
        Rick[7] = RickSpriteSheet.grabImage(8, 1, 40, 80);
        Rick[8] = RickSpriteSheet.grabImage(9, 1, 40, 80);
        
        //marcher en droit
        Rick[9] = RickSpriteSheet.grabImage(1, 2, 40, 80);
        Rick[10] = RickSpriteSheet.grabImage(2, 2, 40, 80);
        Rick[11] = RickSpriteSheet.grabImage(3, 2, 40, 80);
        Rick[12] = RickSpriteSheet.grabImage(4, 2, 40, 80);
                
        //marcher gauche
        Rick[13] = RickSpriteSheet.grabImage(8, 2, 40, 80);
        Rick[14] = RickSpriteSheet.grabImage(7, 2, 40, 80);
        Rick[15] = RickSpriteSheet.grabImage(6, 2, 40, 80);
        Rick[16] = RickSpriteSheet.grabImage(5, 2, 40, 80);
        
        
        
        
        

    }

}
