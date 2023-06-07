import java.util.ArrayList;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        //création de la collection
        ArrayList<String> collection = new ArrayList<>();
        //ajout de valeurs à la collection
        collection.add("User");
        collection.add("Visiteur");
        collection.add("Admin");
        //boucle foreach pour parcourir la collection
        for (String value: collection) {
            //affichage dans la console du contenu de chaque élément de la collection
            System.out.println("le contenu de la colonne est :"+value);
        }
    }

    public static void sort(List liste, int age) {
    }
}
