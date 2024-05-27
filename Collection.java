class Collection {
    private final String name;
    private int price;

    public Collection(String name, int size) {
        this.name = name;
        this.price = size;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString() {
        return name + "," + price;
    }

    public static Collection parseFromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 2) {
            String name = parts[0];
            int size = Integer.parseInt(parts[1]);
            return new Collection(name, size);
        }
        return null;
    }
}
