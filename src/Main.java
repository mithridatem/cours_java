import Beans.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Utilisateur> liste = new ArrayList<>();
        User test = new User("Mithridate");
        liste.add(new Utilisateur("Mithridate", "Mathieu", 12, "Toulouse"));
        liste.add(new Utilisateur("Test", "Mathieu", 21, "Albi"));
        liste.add(new Utilisateur("Mithridate", "Mathieu", 8, "Castres"));
        liste.add(new Utilisateur("Mithridate", "Mathieu", 12, "Albi"));
        liste.add(new Utilisateur("Mithridate", "Test", 6, "Toulouse"));
        liste.add(new Utilisateur("Mithridate", "Test", 6, "Toulouse"));
        liste.add(new Utilisateur("Mithridate", "Test", 6, "Toulouse"));
        liste.add(new Utilisateur("Mithridate", "Test", 6, "Toulouse"));

        List<Utilisateur> filter = Utilisateur.ListByVille(liste, "Toulouse");
        for (Utilisateur value:filter
        ) {
            System.out.println(value.getNom()+" "+value.getPrenom()+" "+value.getVille().toLowerCase());
        }

        System.out.println(Utilisateur.getCompteur());
    }
    public static class Utilisateur {
        private int age;
        /*Attributs*/
        private String nom;
        private String prenom;

        private String rue;
        private int numRue;
        private String ville;
        private int cp;
        private static int compteur = 0;
        /*Constructeurs*/
        public Utilisateur() {
            increment();
        }
        public Utilisateur(String nom, String prenom, int age, String ville) {
            this.nom = nom;
            this.prenom = prenom;
            this.age = age;
            this.ville = ville;
            increment();
        }
        /*Getters and Setters*/

        public String getNom() {
            return this.nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getRue() {
            return rue;
        }

        public void setRue(String rue) {
            this.rue = rue;
        }

        public int getNumRue() {
            return numRue;
        }

        public void setNumRue(int numRue) {
            this.numRue = numRue;
        }

        public String getVille() {
            return ville;
        }

        public void setVille(String ville) {
            this.ville = ville;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public static int getCompteur() {
            return compteur;
        }
        public static void setCompteur(int compteur) {
            Utilisateur.compteur = compteur;
        }
        /**------------------------------------
                        Méthode
        *------------------------------------*/
        //fonction qui trie une List par age de l'utilisateur
        public static void trie(List<Utilisateur> list) {
            list.sort(Comparator.comparing(Utilisateur::getAge));
        }
        //Fonction qui retourne une List d'utilisateur filtré par ville
        public static List<Utilisateur> ListByVille(List<Utilisateur> liste, String ville){
            //instance d'une nouvelle liste
            List<Utilisateur> newListe = new ArrayList<>();
            //parcour la liste
            for (Utilisateur value :liste) {
                if(value.getVille() == ville){
                    newListe.add(value);
                }
            }
            return newListe;
        }
        //Fonction incrémentation du compteur Utilisateur
        private static void increment(){
            setCompteur(getCompteur()+1);
        }
    }
}