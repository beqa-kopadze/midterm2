import java.util.List;

public class StoreTester {
    public static void main(String[] args) {
        FurnitureStore store = new FurnitureStore();

        // Bedroom Collections
        store.addCollection(new Collection("Bedroom Furniture Set", 7));
        store.addCollection(new Collection("Bedside Tables", 4));
        store.addCollection(new Collection("Dressers", 6));
        store.addCollection(new Collection("Armoires", 3));

        // Living Room Collections
        store.addCollection(new Collection("Sofa Sets", 9));
        store.addCollection(new Collection("Coffee Tables", 5));
        store.addCollection(new Collection("TV Stands", 8));
        store.addCollection(new Collection("Bookshelves", 6));

        // Dining Room Collections
        store.addCollection(new Collection("Dining Table Sets", 10));
        store.addCollection(new Collection("Buffet Cabinets", 4));
        store.addCollection(new Collection("Bar Stools", 12));
        store.addCollection(new Collection("Sideboards", 6));

        // Office Collections
        store.addCollection(new Collection("Home Office Desks", 8));
        store.addCollection(new Collection("Office Chairs", 15));
        store.addCollection(new Collection("Filing Cabinets", 6));
        store.addCollection(new Collection("Bookcases", 10));

        // Outdoor Collections
        store.addCollection(new Collection("Patio Furniture Sets", 12));
        store.addCollection(new Collection("Outdoor Dining Sets", 8));
        store.addCollection(new Collection("Outdoor Benches", 6));
        store.addCollection(new Collection("Garden Decor", 20));

        // Kids Room Collections
        store.addCollection(new Collection("Kids Bedroom Sets", 6));
        store.addCollection(new Collection("Kids Study Tables", 8));
        store.addCollection(new Collection("Kids Bookshelves", 4));
        store.addCollection(new Collection("Kids Storage", 10));

        // Save the state
        store.saveState();

        // Clear the collections
        store.getCollections().clear();

        // Load the state
        store.restoreState();

        // Print the restored collections
        List<Collection> restoredCollections = store.getCollections();
        for (Collection collection : restoredCollections) {
            System.out.println("Name: " + collection.getName() + ", Price: " + collection.getPrice() + "$");
        }

        store.removeCollection("Bedroom Furniture Set");
        store.removeCollection("Bedside Tables");
        store.removeCollection("Dressers");
        store.removeCollection("Armoires");

        // Save the state
        store.saveState();


        System.out.println("After Changes");
        for (Collection collection : restoredCollections) {
            System.out.println("Name: " + collection.getName() + ", Price: " + collection.getPrice() + "$");
        }
    }
}
