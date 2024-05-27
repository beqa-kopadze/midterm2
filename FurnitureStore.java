import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FurnitureStore {
    private List<Collection> collections;

    public FurnitureStore() {
        collections = new ArrayList<>();
    }

    public void addCollection(Collection collection) {
        collections.add(collection);
    }

    public void removeCollection(String name) {
        Collection collectionToRemove = null;
        for (Collection collection : collections) {
            if (collection.getName().equals(name)) {
                collectionToRemove = collection;
                break;
            }
        }
        if (collectionToRemove != null) {
            collections.remove(collectionToRemove);
        }
    }

    public void saveState() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Collection collection : collections) {
                writer.write(collection.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreState() {
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            collections.clear(); // Clear the existing list
            while ((line = reader.readLine()) != null) {
                Collection collection = Collection.parseFromString(line);
                if (collection != null) {
                    collections.add(collection);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Collection> getCollections() {
        return collections;
    }
}
